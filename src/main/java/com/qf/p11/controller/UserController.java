package com.qf.p11.controller;

import cn.hutool.core.codec.Base32;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.qf.p11.mapper.TypeMapper;
import com.qf.p11.pojo.*;
import com.qf.p11.service.UserService;
import com.qf.p11.vo.CartVO;
import com.qf.p11.vo.OrderDetailVO;
import com.qf.p11.vo.OrdersVO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.annotation.Resource;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Lj
 * @version 1.0
 */

@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "register";
    }

    @RequestMapping("/checkUserName")
    @ResponseBody
    public Object checkUserName(String username){
        boolean checked = userService.checkUserName(username);
        if (checked){
            return "0";
        }
        return "1";
    }

    @RequestMapping("/userRegister")
    public String userRegister(User user, HttpSession session, HttpServletResponse resp){
        user.setuCode(RandomUtil.randomString(5));
        boolean isResist = userService.userRegister(user);
        if (isResist){
            userService.sendVaryEmail(user.getuCode(), Base32.encode(user.getuName()));
            session.setAttribute("registerMsg","注册成功  3秒后跳转至登录页");
            resp.setHeader("refresh","3;url=registerSuccess.jsp");
        }else {
            session.setAttribute("registerMsg","注册失败");
        }
        return "register";
    }

    public User getNameAndPwdFromParamOrCookieFromReq(User user, HttpServletRequest req){
        if (user.getuName()==null || user.getuPassword()==null){
            for (Cookie cookie : req.getCookies()) {
                if (cookie.getName().equals("name")){
                    user.setuName(cookie.getValue());
                }
                if (cookie.getName().equals("password")){
                    user.setuPassword(cookie.getValue());
                }
            }
        }
        return user;
    }

    public void setLoginCookie(User user,int maxAge,HttpServletResponse resp){
        Cookie cookie1 = new Cookie("name",user.getuName());
        Cookie cookie2 = new Cookie("password",user.getuPassword());
        cookie1.setMaxAge(maxAge);
        cookie2.setMaxAge(maxAge);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }

    @RequestMapping("/userLogin")
    public Object userLogin(User user,String auto,
                            HttpSession session,HttpServletResponse resp,
                            HttpServletRequest req){

        user=getNameAndPwdFromParamOrCookieFromReq(user,req);
        user = userService.login(user.getuName(), user.getuPassword());
        if (user==null){
            req.setAttribute("msg","账号或密码错误");
            return "redirect:login.jsp";
        }
        if ("on".equals(auto)){
            setLoginCookie(user,60*60*24*14,resp);
        }
        session.setAttribute("loginUser",user);
        return "redirect:index.jsp";
    }

    @RequestMapping("/activate")
    public String active(String c,String uName, Map<String,Object> map){

        uName = Base32.decodeStr(uName);
        User user = userService.getUserByName(uName);
        boolean checked = false;
        if (user.getuCode().equals(c)){
            checked=userService.activate(user.getuId());
        }
        if (checked){
            userService.addCartByUid(user.getuId());
            return "registerSuccess";
        }
        map.put("msg","验证码错误");
        return "message";
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session,HttpServletRequest req,HttpServletResponse resp){
        User user = (User) session.getAttribute("loginUser");
        session.removeAttribute("loginUser");
        setLoginCookie(user,0,resp);
        return "login";
    }


    @RequestMapping("/getSelfInfo")
    public String getSelfInfo(HttpSession session,HttpServletRequest request){
        User user = (User) session.getAttribute("loginUser");
        List<Address> addresses = userService.queryAllAddressByUid(user.getuId());
        request.setAttribute("addList",addresses);
        return "self_info";
    }

}
