package com.touchkiss.catelogueoflife.spider.life.services;

import java.io.IOException;

/**
 * Created on 2020/03/18 17:31
 *
 * @author Touchkiss
 */
public interface LifeCategorySpiderService {
    int fetchLifeCategoryFromWeb(int id) throws IOException;

    void autoFetch();
}
