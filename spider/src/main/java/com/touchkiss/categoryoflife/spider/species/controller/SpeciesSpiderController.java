package com.touchkiss.categoryoflife.spider.species.controller;

import com.touchkiss.categoryoflife.spider.species.services.SpeciesSpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created on 2020/03/21 10:56
 *
 * @author Touchkiss
 */
@RestController
@RequestMapping("spider/species")
public class SpeciesSpiderController {
    @Autowired
    private SpeciesSpiderService speciesSpiderService;
    @RequestMapping("species/{id}")
    public boolean speciesSpider(@PathVariable("id")String id){
        try {
            return speciesSpiderService.fetchSpecies(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
