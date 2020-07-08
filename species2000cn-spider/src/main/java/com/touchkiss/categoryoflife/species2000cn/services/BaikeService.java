package com.touchkiss.categoryoflife.species2000cn.services;

import com.touchkiss.categoryoflife.species2000cn.bean.BaikeResponse;

import java.util.List;

/**
 * Created on 2020/07/08 23:13
 *
 * @author Touchkiss
 */
public interface BaikeService {
    List<BaikeResponse> query(String queryStr);
}
