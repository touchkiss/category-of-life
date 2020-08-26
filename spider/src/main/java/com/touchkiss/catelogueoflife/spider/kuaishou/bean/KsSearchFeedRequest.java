package com.touchkiss.catelogueoflife.spider.kuaishou.bean;

import lombok.Data;

/**
 * Created on 2020/07/24 15:26
 *
 * @author Touchkiss
 */
@Data
public class KsSearchFeedRequest {
    private String keyword;
    private String pcursor;
    private String ussid;
}
