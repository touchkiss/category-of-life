package com.touchkiss.categoryoflife.spider.baidu.controller;

import com.touchkiss.categoryoflife.es.repositories.impl.BaseRepositoryImpl;
import com.touchkiss.categoryoflife.spider.baidu.bean.BaikeResponse;
import com.touchkiss.categoryoflife.spider.baidu.bean.ESBaikeItem;
import com.touchkiss.categoryoflife.spider.baidu.services.BaikeSpiderService;
import com.touchkiss.categoryoflife.spider.constants.RedisConstants;
import com.touchkiss.categoryoflife.utils.StringUtil;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created on 2020/04/15 10:57
 *
 * @author Touchkiss
 */
@RestController
@RequestMapping("baike")
public class BaikeController {
    @Autowired
    private BaseRepositoryImpl baseRepository;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private BaikeSpiderService baikeSpiderService;

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
    @RequestMapping("query")
    public BaikeResponse queryBaike(@RequestParam("word") String word) {
        return baikeSpiderService.queryBaike(word);
    }
}




