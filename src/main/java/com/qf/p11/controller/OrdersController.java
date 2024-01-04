package com.qf.p11.controller;

import com.qf.p11.pojo.Address;
import com.qf.p11.pojo.User;
import com.qf.p11.service.UserService;
import com.qf.p11.vo.CartVO;
import com.qf.p11.vo.OrderDetailVO;
import com.qf.p11.vo.OrdersVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Lj
 * @version 1.0
 */

@Controller
public class OrdersController {

    @Resource
    UserService userService;

    @RequestMapping("getOrderView")
    public String getOrderView(HttpSession session, Model model){
        User user = (User) session.getAttribute("loginUser");
        CartVO cartVO = userService.queryUserCart(user.getuId());
        List<Address> addresses = userService.queryAllAddressByUid(user.getuId());
        model.addAttribute("cart",cartVO);
        model.addAttribute("addList",addresses);
        return "order";
    }

    @RequestMapping("/addOrder")
    public String addOrder(int aid,HttpSession session,Model model){
        User user = (User) session.getAttribute("loginUser");
        int orderId = userService.addSingleOrder(aid, user.getuId());
        OrderDetailVO orderDetailVO = userService.queryOrderDetailVOByOid(orderId);
        model.addAttribute("od",orderDetailVO);

        return "orderDetail";
    }


    @RequestMapping("/getOrderDetail")
    public String getOrderDetail(int oid,Model model){
        OrderDetailVO orderDetailVO = userService.queryOrderDetailVOByOid(oid);
        model.addAttribute("od",orderDetailVO);
        return "orderDetail";
    }

    @RequestMapping("/getOrderList")
    public String getOrderList(HttpSession session,Model model){
        User user = (User) session.getAttribute("loginUser");
        List<OrdersVO> ordersVOS = userService.queryAllOrderWithAddressByUid(user.getuId());
        model.addAttribute("orderList",ordersVOS);

        return "orderList";
    }
}
