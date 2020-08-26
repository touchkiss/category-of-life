package com.touchkiss.catelogueoflife.spider.kuaishou.task;

import com.touchkiss.catelogueoflife.aop.Timer;
import com.touchkiss.catelogueoflife.kuaishou.bean.KsRecVideo;
import com.touchkiss.catelogueoflife.kuaishou.services.KsRecVideoDaoService;
import com.touchkiss.catelogueoflife.spider.kuaishou.bean.KsRecommendRequest;
import com.touchkiss.catelogueoflife.spider.kuaishou.bean.KsRecommendResponse;
import com.touchkiss.catelogueoflife.spider.kuaishou.services.KsSpiderService;
import com.touchkiss.catelogueoflife.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created on 2020/08/26 17:36
 *
 * @author Touchkiss
 */
@Component
public class KsTask {
    @Autowired
    private KsSpiderService ksSpiderService;
    @Autowired
    private KsRecVideoDaoService ksRecVideoDaoService;

    @Scheduled(cron = "0 * * * * ?")
    @Timer("抓取快手推荐列表")
    public void fetchRecVideoList() {
        for (int i = 0; i < 10; i++) {
            KsRecommendRequest ksRecommendRequest = new KsRecommendRequest();
            ksRecommendRequest.setCount(10);
            ksRecommendRequest.setPortal(1);
            ksRecommendRequest.setPageType(2);
            ksRecommendRequest.setExtraRequestInfo("{\"scene\":1006}");
            String userId = generateUserId(9);
            ksRecommendRequest.setThirdPartyUserId(Integer.parseInt(userId));
            KsRecommendResponse recommend = ksSpiderService.recommend(ksRecommendRequest);
            if (recommend != null) {
                recommend.getFeeds().stream().filter(KsRecommendResponse.FeedsBean::isVideo).filter(feedsBean -> ksRecVideoDaoService.selectByPhotoId(feedsBean.getPhotoId()) == null).forEach(feedsBean -> {
                    try {
                        KsRecVideo ksRecVideo = new KsRecVideo();
                        ksRecVideo.setPhotoId(feedsBean.getPhotoId());
                        ksRecVideo.setSourceUserId(String.valueOf(feedsBean.getUserId()));
                        ksRecVideo.setSourceKuaiId(feedsBean.getKwaiId());
                        ksRecVideo.setSourceUserName(feedsBean.getUserName());
                        ksRecVideo.setTitle(feedsBean.getCaption());
                        ksRecVideo.setUploadTime(feedsBean.getTimestamp());
                        SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyyMMdd");
                        ksRecVideo.setUploadDate(Long.parseLong(yyyymmdd.format(new Date(feedsBean.getTimestamp()))));
                        ksRecVideo.setLikeCount((long) feedsBean.getLikeCount());
                        ksRecVideo.setCommentCount((long) feedsBean.getCommentCount());
                        ksRecVideo.setShareCount((long) feedsBean.getShareCount());
                        ksRecVideo.setViewCount((long) feedsBean.getViewCount());
                        ksRecVideo.setVideoUrl(feedsBean.getMainMvUrls().get(0).getUrl());
                        ksRecVideo.setCreateDate(Long.parseLong(yyyymmdd.format(new Date())));
                        ksRecVideoDaoService.insert(ksRecVideo);
                    }catch (Exception ignore){ignore.printStackTrace();}
                });
            }
        }
    }

    public static String generateUserId(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            stringBuilder.append((random.nextInt(9) + 1));
        }
        return stringBuilder.toString();
    }
}
