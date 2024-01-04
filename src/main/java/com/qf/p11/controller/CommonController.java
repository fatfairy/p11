package com.qf.p11.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.core.lang.Console;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.io.IOException;

/**
 * @author Lj
 * @version 1.0
 */


@Controller
@RequestMapping("/common")
public class CommonController {


    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpServletResponse resp, HttpSession session){
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(80, 30, 4, 0);
        try {
            circleCaptcha.write(resp.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        session.setAttribute("code",circleCaptcha.getCode());
        Console.log(circleCaptcha.getCode());
    }

    @RequestMapping("/checkCode")
    @ResponseBody
    public Object checkCode(String code,HttpSession session){
        String c =(String) session.getAttribute("code");
        if (code.equalsIgnoreCase(c)){
            return "0";
        }
        return "1";
    }
}
