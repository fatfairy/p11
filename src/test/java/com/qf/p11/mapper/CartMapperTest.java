package com.qf.p11.mapper;

import com.qf.p11.pojo.Cart;
import com.qf.p11.vo.CartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author Lj
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class CartMapperTest {

    @Resource
    CartMapper cartMapper;


    @Test
    public void test01(){
        Cart cart = cartMapper.selectCartInfo(4);
        System.out.println(cart);
    }


    @Test
    public void test02(){
        CartVO cartVO = cartMapper.selectUserCart(4);
        System.out.println(cartVO);
    }
}
