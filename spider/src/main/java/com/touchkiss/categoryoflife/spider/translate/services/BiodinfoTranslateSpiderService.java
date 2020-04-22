package com.touchkiss.categoryoflife.spider.translate.services;

import java.io.IOException;

/**
 * Created on 2020/03/21 17:11
 *
 * @author Touchkiss
 */
public interface BiodinfoTranslateSpiderService {
    boolean fetchTranslate(String id, String treeid) throws IOException;

    void autoFetch();
}
