package com.touchkiss.catelogueoflife.spider.kuaishou.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created on 2020/08/26 17:36
 *
 * @author Touchkiss
 */
@Component
public class KsTask {
    @Scheduled(cron = "0 *")
    public void fetchRecVideoList(){

    }
}
