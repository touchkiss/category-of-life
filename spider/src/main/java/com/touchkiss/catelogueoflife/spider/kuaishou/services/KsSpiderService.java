package com.touchkiss.catelogueoflife.spider.kuaishou.services;

import com.touchkiss.catelogueoflife.spider.kuaishou.bean.*;

/**
 * Created on 2020/07/21 11:11
 *
 * @author Touchkiss
 */
public interface KsSpiderService {
    /**
     * 按关键词搜索作品
     *
     * @param ksSearchFeedRequest
     */
    KsSearchFeedResponse searchFeed(KsSearchFeedRequest ksSearchFeedRequest);

    /**
     * 按关键词搜索用户
     *
     * @param ksSearchFeedRequest
     * @return
     */
    KsSearchUserResponse searchUser(KsSearchFeedRequest ksSearchFeedRequest);

    /**
     * 查询用户信息
     *
     * @param ksUserProfileRequest
     * @return
     */
    KsUserProfileResponse userProfile(KsUserProfileRequest ksUserProfileRequest);

    /**
     * 查询用户作品
     *
     * @param ksFeedProfileRequest
     * @return
     */
    KsFeedProfileResponse userFeed(KsFeedProfileRequest ksFeedProfileRequest);

    /**
     * 快手推荐
     *
     * @param ksRecommendRequest
     * @return
     */
    KsRecommendResponse recommend(KsRecommendRequest ksRecommendRequest);
}
