package com.touchkiss.categoryoflife.spider.controller;

import com.touchkiss.categoryoflife.spider.life.services.LifeCategorySpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created on 2020/03/18 18:09
 *
 * @author Touchkiss
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private LifeCategorySpiderService lifeCategoryService;

    @GetMapping("fetch")
    public int testFetch(@RequestParam("id") Integer id) {
        try {
            return lifeCategoryService.fetchLifeCategoryFromWeb(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
