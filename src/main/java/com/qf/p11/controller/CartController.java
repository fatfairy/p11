package com.qf.p11.controller;

import com.qf.p11.pojo.User;
import com.qf.p11.service.UserService;
import com.qf.p11.vo.CartVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.Resource;

import java.math.BigDecimal;

/**
 * @author Lj
 * @version 1.0
 */

@Controller
public class CartController {

    @Resource
    UserService userService;

    @RequestMapping("/addCart")
    public String addCart(int goodsId, HttpSession session){
        User user = (User) session.getAttribute("loginUser");
        System.out.println(user);
        userService.addProductToCart(user.getuId(),goodsId);
        return "cartSuccess";
    }


    @RequestMapping("/getCart")
    public String getCart(HttpSession session, Model model){
        User user = (User) session.getAttribute("loginUser");
        CartVO cartVO = userService.queryUserCart(user.getuId());
        model.addAttribute("cart",cartVO);
        return "cart";
    }

    @RequestMapping("/updateCartNum")
    @ResponseBody
    public String updateCartNum(int pid, int num, BigDecimal price, HttpSession session){
        User user = (User) session.getAttribute("loginUser");
        userService.updateCartCountAndNum(user.getuId(),pid,num);
        return "1";
    }

    @RequestMapping("/clearCart")
    public String clearCart(int pid,HttpSession session){
        User user = (User) session.getAttribute("loginUser");

        if (pid!=0){
            userService.removeProductFromCart(pid,user.getuId());
        }else {
            userService.removeAllProductFromCart(user.getuId());
        }
        return "forward:getCart";
    }
}
