package com.qf.p11.mapper;

import com.qf.p11.service.UserService;
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
public class ItemMapperTest {

    @Resource
    ItemMapper itemMapper;

    @Resource
    UserService userService;

    @Test
    public void test01(){
        CartVO cartVO = userService.queryUserCart(4);
//        itemMapper.insertBatch(cartVO,1);
    }
}
