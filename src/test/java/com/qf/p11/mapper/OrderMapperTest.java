package com.qf.p11.mapper;

import com.qf.p11.vo.OrderDetailVO;
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
public class OrderMapperTest {

    @Resource
    OrdersMapper ordersMapper;


    @Test
    public void test01(){
        OrderDetailVO orderDetailVO = ordersMapper.selectOrderDetailByOid(12);
        System.out.println(orderDetailVO);
    }
}
