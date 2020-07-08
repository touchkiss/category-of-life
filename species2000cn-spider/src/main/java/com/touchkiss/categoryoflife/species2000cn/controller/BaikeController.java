package com.touchkiss.categoryoflife.species2000cn.controller;

import com.touchkiss.categoryoflife.species2000cn.bean.BaikeResponse;
import com.touchkiss.categoryoflife.species2000cn.services.BaikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2020/07/08 23:11
 *
 * @author Touchkiss
 */
@RestController
public class BaikeController {
    @Autowired
    private BaikeService baikeService;
    @RequestMapping("query/{word}")
    public List<BaikeResponse> query(@PathVariable("word")String word){
        return baikeService.query(word);
    }
}
