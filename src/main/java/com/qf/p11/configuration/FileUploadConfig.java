package com.qf.p11.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

/**
 * @author Lj
 * @version 1.0
 */

@Configuration
public class FileUploadConfig {

    @Bean(name = "multipartResolver")
    public StandardServletMultipartResolver multipartResolver(){
        StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
        return resolver;
    }
}
