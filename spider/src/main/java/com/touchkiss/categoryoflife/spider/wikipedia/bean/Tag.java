package com.touchkiss.categoryoflife.spider.wikipedia.bean;

import com.touchkiss.categoryoflife.utils.HttpUtil;

import java.io.IOException;

/**
 * Created on 2020/04/02 15:37
 *
 * @author Touchkiss
 */
public class Tag {
    private String name;

    public static void main(String[] args) throws IOException {
//        System.out.println(HttpUtil.get("https://species.wikipedia.org/w/api.php?action=query&prop=revisions&rvprop=content&format=json&formatversion=2&titles=Cephalorhynchus_commersonii"));
        System.out.println(HttpUtil.get("https://www.google.com"));
    }
}
