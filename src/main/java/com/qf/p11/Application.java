package com.qf.p11;

import com.qf.p11.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Lj
 * @version 1.0
 */

@SpringBootApplication
@MapperScan("com.qf.p11.mapper")
@EnableTransactionManagement
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        for (String s : run.getBeanNamesForType(UserService.class)) {
            System.out.println(s);
        }
    }
}
