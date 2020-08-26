package com.touchkiss.catelogueoflife.spider.kuaishou.bean;

/**
 * Created on 2020/07/24 15:35
 *
 * @author Touchkiss
 */
public class KsFeedProfileRequest {

    /**
     * count : 24
     * eid : 555258693
     * pcursor : 1.592951195167E12
     */

    private int count;
    private String eid;
    private String pcursor;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getPcursor() {
        return pcursor;
    }

    public void setPcursor(String pcursor) {
        this.pcursor = pcursor;
    }
}
