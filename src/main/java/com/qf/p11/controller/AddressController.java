package com.qf.p11.controller;

import com.qf.p11.pojo.Address;
import com.qf.p11.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Lj
 * @version 1.0
 */

@Controller
public class AddressController {

    @Resource
    UserService userService;

    @RequestMapping("/addAddress")
    public String addAddress(Address address){
        userService.addAddress(address);
        return "redirect:self_info.jsp";
    }
}
