package com.qf.p11.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.qf.p11.pojo.Product;
import com.qf.p11.pojo.Type;
import com.qf.p11.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Lj
 * @version 1.0
 */

@Controller
public class GoodsController {

    @Resource
    UserService userService;

    @RequestMapping("/goodsTypeAjax")
    @ResponseBody
    public Object goodsTypeAjax(){
        List<Type> types = userService.queryAllType();
        return JSON.toJSONString(types);
    }

    @RequestMapping("getGoodsListByTypeId")
    public String getGoodsListByTypeId(int typeid, int pageNo, Map<String,Object> map){
        PageInfo<Product> products = userService.queryPageProductByTypeId(pageNo,typeid);
        System.out.println(products);
        map.put("glist",products);
        return "goodsList";
    }

    @RequestMapping("/getGoodsById")
    public String getGoodsById(int id, Model model){
        Product product = userService.queryProductById(id);
        model.addAttribute("goods",product);
        return "goodsDetail";
    }

}
