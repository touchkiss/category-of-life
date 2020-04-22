package com.touchkiss.categoryoflife.spider.wikipedia.services;

/**
 * Created on 2020/04/03 9:42
 *
 * @author Touchkiss
 */
public class WikiSpiderThread implements Runnable{
    private WikiService wikiService;
    private String title;

    public WikiSpiderThread(WikiService wikiService, String title) {
        this.wikiService = wikiService;
        this.title = title;
    }

    @Override
    public void run() {
        this.wikiService.fetchContent(title);
    }
}
