package com.touchkiss.catelogueoflife.spider.life.task;

import com.touchkiss.catelogueoflife.spider.life.services.LifeCategorySpiderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 2020/03/21 17:59
 *
 * @author Touchkiss
 */
@Component
@Slf4j
public class LifeCategorySpiderTask {
    @Autowired
    private LifeCategorySpiderService lifeCategorySpiderService;

//    @Scheduled(cron = "*/5 * * * * ?")
    public void autoFetch() {
        log.info("====================定时任务抓取物种分类==========");
        lifeCategorySpiderService.autoFetch();
        log.info("====================定时任务抓取物种分类====结束====");
    }
}
