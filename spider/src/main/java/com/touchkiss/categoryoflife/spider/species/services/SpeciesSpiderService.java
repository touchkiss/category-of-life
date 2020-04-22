package com.touchkiss.categoryoflife.spider.species.services;

import java.io.IOException;

/**
 * Created on 2020/03/20 18:23
 *
 * @author Touchkiss
 */
public interface SpeciesSpiderService {
    boolean fetchSpecies(String id) throws IOException;

    void autoFetch();
}
