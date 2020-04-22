package com.touchkiss.categoryoflife.spider.baidu.task;

import com.touchkiss.categoryoflife.spider.baidu.services.BaikeRestoreThread;
import com.touchkiss.categoryoflife.spider.baidu.services.BaikeSpiderService;
import com.touchkiss.categoryoflife.spider.base.ThreadPoolExecutors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created on 2020/04/07 14:44
 *
 * @author Touchkiss
 */
@Component
@Slf4j
public class BaikeSpiderTask {
    @Autowired
    private BaikeSpiderService baikeSpiderService;

//    @Scheduled(cron = "* * * * * ?")
    public void autoFetch() {
        log.info("====================定时任务抓百度百科==========");
        baikeSpiderService.fetchBaike();
        log.info("====================定时任务抓百度百科==结束=====");
    }
//    @Scheduled(cron = "* * * * * ?")
    public void storeToESFromRedis(){
        log.info("====================定时任务将百度百科从redis转存到es==========");
        baikeSpiderService.storeToESFromRedis();
        log.info("====================定时任务将百度百科从redis转存到es==结束=====");
    }
}
