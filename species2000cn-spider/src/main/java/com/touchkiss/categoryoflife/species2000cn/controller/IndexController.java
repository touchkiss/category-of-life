package com.touchkiss.categoryoflife.species2000cn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2020/07/07 18:36
 *
 * @author Touchkiss
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public void index(HttpServletResponse response){
        try {
            response.sendRedirect("/index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("")
    public void index2(HttpServletResponse response){
        try {
            response.sendRedirect("/index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
