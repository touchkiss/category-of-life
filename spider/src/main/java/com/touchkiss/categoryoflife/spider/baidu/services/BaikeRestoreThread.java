package com.touchkiss.categoryoflife.spider.baidu.services;

import com.touchkiss.categoryoflife.spider.constants.RedisConstants;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created on 2020/04/18 23:21
 *
 * @author Touchkiss
 */
public class BaikeRestoreThread implements Runnable {
    private String key;
    private BaikeSpiderService baikeSpiderService;
    private StringRedisTemplate stringRedisTemplate;

    public BaikeRestoreThread(String key, BaikeSpiderService baikeSpiderService, StringRedisTemplate stringRedisTemplate) {
        this.key = key;
        this.baikeSpiderService = baikeSpiderService;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void run() {
        if (!stringRedisTemplate.opsForHash().hasKey(key, "transfered")) {
            baikeSpiderService.storeToES(stringRedisTemplate.opsForHash().entries(key));
            stringRedisTemplate.opsForHash().put(key, "transfered", "1");
            stringRedisTemplate.opsForSet().remove(RedisConstants.BAIKE_NOT_STORED_TO_ES,key);
        }
    }
}
