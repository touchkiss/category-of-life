package com.touchkiss.categoryoflife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created on 2020/07/07 16:15
 *
 * @author Touchkiss
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class Species2000cnApplication  extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Species2000cnApplication.class);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(Species2000cnApplication.class);
    }
}
