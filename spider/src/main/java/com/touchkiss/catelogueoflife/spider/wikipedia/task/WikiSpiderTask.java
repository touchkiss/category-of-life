package com.touchkiss.catelogueoflife.spider.wikipedia.task;

import com.touchkiss.catelogueoflife.spider.wikipedia.services.WikiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 2020/04/02 17:56
 *
 * @author Touchkiss
 */
@Component
@Slf4j
public class WikiSpiderTask {
    @Autowired
    private WikiService wikiService;

//    @Scheduled(cron = "*/10 * * * * ?")
    public void autoFetch() {
        log.info("====================定时任务抓维基百科==========");
        wikiService.autoFetch();
        log.info("====================定时任务抓维基百科==结束=====");
    }
}
