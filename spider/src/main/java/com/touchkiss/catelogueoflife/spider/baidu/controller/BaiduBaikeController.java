package com.touchkiss.catelogueoflife.spider.baidu.controller;

import com.touchkiss.catelogueoflife.es.repositories.impl.BaseRepositoryImpl;
import com.touchkiss.catelogueoflife.spider.baidu.bean.BaikeItemResponse;
import com.touchkiss.catelogueoflife.spider.baidu.bean.ESBaikeItem;
import com.touchkiss.catelogueoflife.spider.baidu.services.BaikeService;
import com.touchkiss.catelogueoflife.spider.constants.RedisConstants;
import com.touchkiss.catelogueoflife.utils.StringUtil;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created on 2020/04/15 10:57
 *
 * @author Touchkiss
 */
@RestController
@RequestMapping("baike")
public class BaiduBaikeController {
    @Autowired
    private BaseRepositoryImpl baseRepository;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //    @Autowired
//    private BaikeSpiderService baikeSpiderService;
    @Autowired
    private BaikeService baikeService;

    @RequestMapping("createIndex")
    public CreateIndexResponse createIndex() {
        return baseRepository.createIndex(ESBaikeItem.class);
    }

    @RequestMapping("compare")
    public void compare() {
        Set<String> keys = stringRedisTemplate.keys("*");
        Set<String> members = stringRedisTemplate.opsForSet().members(RedisConstants.BAIKE_HAS_STORED_TO_ES);
        keys.removeAll(members);
        Long add = stringRedisTemplate.opsForSet().add(RedisConstants.BAIKE_NOT_STORED_TO_ES, StringUtil.toStringArray(keys));
        System.out.println("将" + add + "个key放入redsi");
    }

    //    @RequestMapping("query")
//    public BaikeResponse queryBaike(@RequestParam("word") String word) {
//        return baikeSpiderService.queryBaike(word);
//    }
    @RequestMapping("query/{word}")
    public List<BaikeItemResponse> query(@PathVariable("word") String word) {
        return baikeService.query(word);
    }
}




