package com.touchkiss.catelogueoflife.spider.life.controller;

import com.touchkiss.catelogueoflife.controller.BaseController;
import com.touchkiss.catelogueoflife.life.services.LifeCategoryDaoService;
import com.touchkiss.catelogueoflife.spider.life.services.LifeCategorySpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created on 2020/03/19 18:33
 *
 * @author Touchkiss
 */
@RestController
@RequestMapping("spider/life")
public class LifeCategorySpiderController implements BaseController {
    @Autowired
    private LifeCategorySpiderService lifeCategoryService;
    @Autowired
    private LifeCategoryDaoService lifeCategoryDaoService;

    @RequestMapping("lifeCategory/{id}")
    public int lifeCategorySpider(@PathVariable("id") Integer id) {
        try {
            return lifeCategoryService.fetchLifeCategoryFromWeb(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
//    @RequestMapping("list")
//    List<LifeCategory>list(HttpServletRequest request){
//        HashMap<String, String> map = parameterMap(request);
//        return lifeCategoryDaoService.queryLifeCategoryList(map);
//    }
}































































































































































































































































