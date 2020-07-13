package com.touchkiss.catelogueoflife.spider.baidu.services;

import com.touchkiss.catelogueoflife.spider.baidu.bean.BaikeItem;
import com.touchkiss.catelogueoflife.spider.constants.RedisConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on 2020/04/11 17:06
 *
 * @author Touchkiss
 */
@Slf4j
public class BaikeSpiderThread implements Runnable {
    private StringRedisTemplate stringRedisTemplate;
    private BaikeSpiderService baikeSpiderService;
    private String url;

    public BaikeSpiderThread(StringRedisTemplate stringRedisTemplate, BaikeSpiderService baikeSpiderService, String url) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.baikeSpiderService = baikeSpiderService;
        this.url = url;
    }

    @Override
    public void run() {
        BaikeItem baikeItem = this.baikeSpiderService.fetchBaike(url.startsWith("/item") ? "https://baike.baidu.com" + url : url);
        Map<String, String> map = baikeItem.toMap();
        baikeSpiderService.storeToES(map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        map.put("transfered", "1");
        String title = baikeItem.getTitle();
        stringRedisTemplate.opsForSet().add(RedisConstants.BAIKE_HAS_STORED_TO_ES, title);
        stringRedisTemplate.opsForHash().putAll(baikeItem.getTitle(), map);
        baikeItem.getLinks().forEach(link -> {
            if (!stringRedisTemplate.opsForSet().isMember(RedisConstants.BAIKE_HAS_FETCHED_URLS, link)) {
                stringRedisTemplate.opsForSet().add(RedisConstants.BAIKE_NOT_FETCHED_URLS, link);
            }
        });
        stringRedisTemplate.opsForSet().add(RedisConstants.BAIKE_HAS_FETCHED_URLS, url);
    }
}
