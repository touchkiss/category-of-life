package com.touchkiss.categoryoflife.spider.wikipedia.services;

import java.io.IOException;

/**
 * Created on 2020/04/02 17:11
 *
 * @author Touchkiss
 */
public interface WikiService {
    void fetchContent(String title);

    void autoFetch();
}
