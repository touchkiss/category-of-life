package com.touchkiss.catelogueoflife.spider.kuaishou.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2020/08/26 18:14
 *
 * @author Touchkiss
 */
@NoArgsConstructor
@Data
public class KsRecommendRequest {

    /**
     * count : 8
     * portal : 1
     * pageType : 2
     * sourceFrom : 2
     * thirdPartyUserId : 834536258
     * extraRequestInfo : {"scene":1001}
     */

    private int count;
    private int portal;
    private int pageType;
    private int sourceFrom;
    private int thirdPartyUserId;
    private String extraRequestInfo;
}
