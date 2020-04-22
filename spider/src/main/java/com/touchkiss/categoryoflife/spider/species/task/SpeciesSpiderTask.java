package com.touchkiss.categoryoflife.spider.species.task;

import com.touchkiss.categoryoflife.spider.species.services.SpeciesSpiderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created on 2020/03/25 15:39
 *
 * @author Touchkiss
 */
@Component
@Slf4j
public class SpeciesSpiderTask {
    @Autowired
    private SpeciesSpiderService speciesSpiderService;
//    @Scheduled(cron = "* * * * * ?")
    public void autoFetch(){
        log.info("====================定时任务抓取物种详情==========");
        speciesSpiderService.autoFetch();
        log.info("====================定时任务抓取物种详情结束=======");
    }
}
