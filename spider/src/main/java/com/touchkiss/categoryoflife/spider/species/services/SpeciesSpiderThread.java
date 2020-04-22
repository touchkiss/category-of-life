package com.touchkiss.categoryoflife.spider.species.services;

import com.touchkiss.categoryoflife.life.bean.LifeCategory;
import com.touchkiss.categoryoflife.life.services.LifeCategoryDaoService;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 2020/03/26 14:20
 *
 * @author Touchkiss
 */
@Slf4j
public class SpeciesSpiderThread implements Runnable {
    Pattern ID_PATTERN = Pattern.compile("[a-z0-9]{32}");
    private LifeCategory lifeCategory;
    private SpeciesSpiderService speciesSpiderService;
    private LifeCategoryDaoService lifeCategoryDaoService;

    public SpeciesSpiderThread(LifeCategory lifeCategory, SpeciesSpiderService speciesSpiderService, LifeCategoryDaoService lifeCategoryDaoService) {
        this.lifeCategory = lifeCategory;
        this.speciesSpiderService = speciesSpiderService;
        this.lifeCategoryDaoService = lifeCategoryDaoService;
    }

    @Override
    public void run() {
        String url = lifeCategory.getUrl();
        Matcher matcher = ID_PATTERN.matcher(url);
        if (matcher.find()) {
            String species_id = matcher.group(0);
            try {
                if (speciesSpiderService.fetchSpecies(species_id)) {
                    lifeCategory.setFetched(true);
                    lifeCategoryDaoService.updateById(lifeCategory, lifeCategory.getId());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
