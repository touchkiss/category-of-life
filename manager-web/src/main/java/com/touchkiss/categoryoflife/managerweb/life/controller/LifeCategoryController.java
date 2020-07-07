package com.touchkiss.categoryoflife.managerweb.life.controller;

import com.touchkiss.categoryoflife.base.PageResult;
import com.touchkiss.categoryoflife.life.bean.LifeCategory;
import com.touchkiss.categoryoflife.life.services.LifeCategoryDaoService;
import com.touchkiss.categoryoflife.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created on 2020-03-19 16:45:10
 *
 * @author Touchkiss
 */
@RestController
@RequestMapping("life")
public class LifeCategoryController implements BaseController {
    @Autowired
    private LifeCategoryDaoService lifeCategoryDaoService;

    @GetMapping("lifeCategory")
    public PageResult list(HttpServletRequest request, Integer p, Integer pagesize) {
        HashMap<String, String> whereMap = parameterMap(request);
        return new PageResult(lifeCategoryDaoService.findByPage(p == null ? 1 : p, pagesize == null ? 10 : pagesize, whereMap));
    }

    @GetMapping("/lifeCategory/{id}")
    public LifeCategory getOne(@PathVariable("id") Integer id) {
        return lifeCategoryDaoService.selectById(id);
    }

    @DeleteMapping("/lifeCategory/{id}")
    public boolean deleteOne(@PathVariable("id") Integer id) {
        return lifeCategoryDaoService.deleteById(id);
    }

    @PostMapping("lifeCategory")
    public boolean insertOne(@RequestBody LifeCategory lifeCategory) {
        return lifeCategoryDaoService.insert(lifeCategory);
    }

    @PutMapping("lifeCategory/{id}")
    public boolean updateOne(@RequestBody LifeCategory lifeCategory, @PathVariable("id") Integer id) {
        return lifeCategoryDaoService.updateById(lifeCategory, id);
    }

    @PatchMapping("lifeCategory/{id}")
    public boolean updateSelective(@RequestBody LifeCategory lifeCategory, @PathVariable("id") Integer id) {
        return lifeCategoryDaoService.updateSelectiveById(lifeCategory, id);
    }

    @PostMapping("tree/{id}")
    public List<LifeCategory> tree(@PathVariable("id") Integer id){
        return lifeCategoryDaoService.queryTree(id);
    }
}
