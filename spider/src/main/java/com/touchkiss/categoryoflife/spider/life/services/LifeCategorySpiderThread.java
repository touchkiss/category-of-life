package com.touchkiss.categoryoflife.spider.life.services;

import java.io.IOException;

/**
 * Created on 2020/03/26 14:03
 *
 * @author Touchkiss
 */
public class LifeCategorySpiderThread implements Runnable {
    private int id;
    private LifeCategorySpiderService lifeCategorySpiderService;

    public LifeCategorySpiderThread(int id, LifeCategorySpiderService lifeCategorySpiderService) {
        this.id = id;
        this.lifeCategorySpiderService = lifeCategorySpiderService;
    }

    @Override
    public void run() {
        try {
            this.lifeCategorySpiderService.fetchLifeCategoryFromWeb(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
