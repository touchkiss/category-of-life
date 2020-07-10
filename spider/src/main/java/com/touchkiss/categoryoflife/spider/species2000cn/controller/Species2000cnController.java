package com.touchkiss.categoryoflife.spider.species2000cn.controller;

import com.touchkiss.categoryoflife.spider.species2000cn.bean.TreeItemResponse;
import com.touchkiss.categoryoflife.spider.species2000cn.services.Species2000CnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2020/07/07 16:20
 *
 * @author Touchkiss
 */
@RestController
@RequestMapping("species2000cn")
public class Species2000cnController {
    @Autowired
    private Species2000CnService species2000CnService;

    @PostMapping("browse/{id}")
    public List<TreeItemResponse> browser(@PathVariable(name = "id", required = false) String id) {
        return species2000CnService.browse(id);
    }
    @PostMapping("browse")
    public List<TreeItemResponse> browser() {
        return species2000CnService.browse(null);
    }
}
