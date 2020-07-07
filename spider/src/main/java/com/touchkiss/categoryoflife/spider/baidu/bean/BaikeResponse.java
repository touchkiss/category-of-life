package com.touchkiss.categoryoflife.spider.baidu.bean;

import com.touchkiss.categoryoflife.response.BaseResponse;

import java.util.Map;

/**
 * Created on 2020/04/07 16:58
 *
 * @author Touchkiss
 */
public class BaikeResponse extends BaseResponse<Map<String, String>> {
    public void addAllProperties(Map<String, String> properties) {
        getData().putAll(properties);
    }

    public void addProperty(String key, String value) {
        getData().put(key, value);
    }
}
