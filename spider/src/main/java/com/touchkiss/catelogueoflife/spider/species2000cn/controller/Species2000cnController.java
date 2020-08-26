package com.touchkiss.catelogueoflife.spider.species2000cn.controller;

import com.touchkiss.catelogueoflife.response.BaseResponse;
import com.touchkiss.catelogueoflife.spider.species2000cn.bean.TreeItemResponse;
import com.touchkiss.catelogueoflife.spider.species2000cn.services.Species2000CnService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("browse")
    public BaseResponse<List<TreeItemResponse>> browser(@RequestParam(name = "id", required = false) String id) {
        List<TreeItemResponse> browse = species2000CnService.browse(id);
        if (CollectionUtils.isEmpty(browse)){
            return new BaseResponse<>(HttpStatus.SC_NOT_FOUND,"请求的资源不存在",null);
        }else {
            return new BaseResponse<>(HttpStatus.SC_OK,"success",browse);
        }
    }
}
