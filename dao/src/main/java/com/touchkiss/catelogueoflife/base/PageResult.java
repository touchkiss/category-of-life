package com.touchkiss.catelogueoflife.base;

import com.github.pagehelper.Page;
import lombok.Data;

import java.util.List;

/**
 * Created on 2020/03/19 16:41
 *
 * @author Touchkiss
 */
@Data
public class PageResult {
    private Integer draw;
    private Long count;
    private Long recordsFiltered;
    private List results;

    public PageResult() {
    }

    public PageResult(Integer draw, Long recordsTotal, Long recordsFiltered, List results) {
        this.draw = draw;
        this.count = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.results = results;
    }

    /**
     * 构建Datatables返回结果
     *
     * @param draw
     * @param page
     */
    public PageResult(Integer draw, Page page) {
        this.draw = draw;
        this.count = page == null ? 0 : page.getTotal();
        this.recordsFiltered = page == null ? 0 : page.getTotal();
        this.results = page == null ? null : page.getResult();
    }

    public PageResult(Page page){
        this.count = page == null ? 0 : page.getTotal();
        this.recordsFiltered = page == null ? 0 : page.getTotal();
        this.results = page == null ? null : page.getResult();
    }
}
