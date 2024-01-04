package com.qf.p11.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.qf.p11.pojo.Product;
import com.qf.p11.pojo.Type;
import com.qf.p11.pojo.User;
import com.qf.p11.service.AdminService;
import com.qf.p11.vo.AdminOrderVO;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Lj
 * @version 1.0
 */

@Controller
public class AdminController {

    @Resource
    AdminService adminService;

    @RequestMapping("/adminLogin")
    public String adminLogin(String username, String password, HttpSession session){
        User login = adminService.login(username, password);
        if (login==null){
            return "admin/login";
        }
        session.setAttribute("admin",login);
        return "admin/admin";
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    public Object getUserList(){
        List<User> users = adminService.queryAllUser();
        return JSON.toJSONString(users);
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(int id){
        boolean removed = adminService.removeUser(id);
        if (removed){
            return "1";
        }
        return "0";
    }

    @RequestMapping("/searchUser")
    @ResponseBody
    public Object searchUser(String uName,String uSex){
        List<User> users = adminService.queryUserByNameAndSex(uName, uSex);
        return JSON.toJSONString(users);
    }

    @RequestMapping("/getGoodsType")
    @ResponseBody
    public Object getGoodsType(){
        List<Type> types = adminService.queryAllType();
        return JSON.toJSONString(types);
    }

    @RequestMapping("/addGoods")
    public String addGoods(Product product, MultipartFile picture, HttpServletRequest req){

        System.out.println("------------------"+product);

        String path = req.getServletContext().getRealPath("upload");

        String filename = picture.getOriginalFilename();
        filename = IdUtil.fastSimpleUUID() + filename.substring(filename.lastIndexOf("."));

        String realPath = path+ File.separator+filename;

        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }

        try {
            picture.transferTo(new File(realPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        product.setpImage(filename);

        adminService.addProduct(product);

        return "admin/addGoods";
    }


    @RequestMapping("/showGoods")
    public String showGoods(Map<String,Object> map){
        List<Product> products = adminService.queryAllProduct();
        map.put("goodsList",products);
        return "admin/showGoods";
    }


    @RequestMapping("/showAllOrder")
    public String showAllOrder(Model model){
        List<AdminOrderVO> adminOrderVOS = adminService.queryAllAdminOrderVO();
        model.addAttribute("orderList",adminOrderVOS);


        System.out.println(adminOrderVOS);
        return "admin/showAllOrder";
    }

    @RequestMapping("/sendOrder")
    public void sendOrder(int oid,String m){
        if ("refund".equals(m)){

        }else {
            adminService.modifyOrderStateToSend(oid);
        }
    }
}
