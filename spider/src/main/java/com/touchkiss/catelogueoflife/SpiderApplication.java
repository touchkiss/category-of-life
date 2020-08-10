package com.touchkiss.catelogueoflife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created on 2020/03/18 16:59
 *
 * @author Touchkiss
 */
@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
@ServletComponentScan
public class SpiderApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SpiderApplication.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpiderApplication.class);
    }
}
