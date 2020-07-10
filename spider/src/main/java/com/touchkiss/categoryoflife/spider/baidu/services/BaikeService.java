package com.touchkiss.categoryoflife.spider.baidu.services;

import com.touchkiss.categoryoflife.spider.baidu.bean.BaikeItemResponse;

import java.util.List;

/**
 * Created on 2020/07/08 23:13
 *
 * @author Touchkiss
 */
public interface BaikeService {
    List<BaikeItemResponse> query(String queryStr);
}
