package com.qf.p11.mapper;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.qf.p11.pojo.User;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * @author Lj
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class UserMapperTest {

    @Resource
    UserMapper userMapper;


    @Test
    public void test01(){
        List<User> users = userMapper.selectAllUser();
        Console.log(users);
    }


    @Test
    public void test02(){
        User user = new User();
        user.setuName("张三");
        user.setuPassword("123456");
        user.setuEmail("zs@qq.com");
        user.setuSex("男");
//        int i = 1/0;
        userMapper.insertSingleUser(user);
    }


    @Test
    public void test03(){
        User user=userMapper.selectCountByUsername("tom");
        System.out.println(user);
    }


    @Test
    public void test04(){
        System.out.println(IdUtil.fastSimpleUUID());
        System.out.println(IdUtil.simpleUUID());
    }


    @Test
    public void test05(){
        String filename = "m.png";

        filename = IdUtil.fastSimpleUUID() + filename.substring(filename.lastIndexOf("."));
        System.out.println(filename);
    }


    @Test
    public void test06(){
        MailAccount mailAccount = new MailAccount();
//        mailAccount.setHost("smtp.163.com");
//        mailAccount.setPort(25);
//        mailAccount.setAuth(true);
        mailAccount.setFrom("13480743727@163.com");
//        mailAccount.setUser("13480743727");
        mailAccount.setPass("dsx123456");

        MailUtil.send(mailAccount,
                "519345977@qq.com","hello","Hello world",false);
    }


    @Test
    public void test07() throws UnsupportedEncodingException {
        String s = "%CC%EF%C6%DF";

        String decode = URLDecoder.decode(s, "GBK");
        System.out.println(decode);
    }
}
