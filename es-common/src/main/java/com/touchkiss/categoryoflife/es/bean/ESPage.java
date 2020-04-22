package com.touchkiss.categoryoflife.es.bean;

import java.util.List;

/**
 * Created on 2020/04/10 9:46
 *
 * @author Touchkiss
 */
public class ESPage<T> {
    private Long recordsTotal;
    private List<T> data;

    public ESPage() {
    }

    public ESPage(Long recordsTotal, List<T> data) {
        this.recordsTotal = recordsTotal;
        this.data = data;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
