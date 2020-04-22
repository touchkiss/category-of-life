package com.touchkiss.categoryoflife.spider.baidu.bean;

import com.touchkiss.categoryoflife.response.BaseResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020/04/07 16:58
 *
 * @author Touchkiss
 */
public class BaikeResponse extends BaseResponse {
    private Map<String, String> data = new HashMap<>();

    public void addAllProperties(Map<String, String> properties) {
        this.data.putAll(properties);
    }

    public void addProperty(String key, String value) {
        this.data.put(key, value);
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
