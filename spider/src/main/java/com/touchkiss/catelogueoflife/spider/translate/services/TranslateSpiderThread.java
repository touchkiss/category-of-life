package com.touchkiss.catelogueoflife.spider.translate.services;

import java.io.IOException;

/**
 * Created on 2020/06/06 14:12
 *
 * @author Touchkiss
 */
public class TranslateSpiderThread implements Runnable {
    private BiodinfoTranslateSpiderService biodinfoTranslateSpiderService;
    private String id;
    private String treeid;

    public TranslateSpiderThread(BiodinfoTranslateSpiderService biodinfoTranslateSpiderService,String id, String treeid) {
        this.biodinfoTranslateSpiderService=biodinfoTranslateSpiderService;
        this.id = id;
        this.treeid = treeid;
    }

    @Override
    public void run() {
        try {
            biodinfoTranslateSpiderService.fetchTranslate(id, treeid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
