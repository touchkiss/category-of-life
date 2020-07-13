package com.touchkiss.catelogueoflife.spider.baidu.services;

import com.touchkiss.catelogueoflife.spider.baidu.bean.BaikeItem;
import com.touchkiss.catelogueoflife.spider.baidu.bean.BaikeResponse;

import java.util.Map;

/**
 * Created on 2020/04/07 10:44
 *
 * @author Touchkiss
 */
public interface BaikeSpiderService {
    BaikeItem fetchBaike(String url);

    void fetchBaike();

    BaikeResponse queryBaike(String word);

    void storeToESFromRedis();

    void storeToES(Map<Object, Object> entries);
}
