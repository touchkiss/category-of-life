package com.touchkiss.categoryoflife.spider.translate.controller;

import com.touchkiss.categoryoflife.spider.translate.services.BiodinfoTranslateSpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created on 2020/03/21 17:22
 *
 * @author Touchkiss
 */
@RestController
@RequestMapping("spider/biodinfo")
public class BiodinfoTranslateSpiderController {
    @Autowired
    private BiodinfoTranslateSpiderService biodinfoTranslateSpiderService;

    @RequestMapping("{treeid}/{id}")
    public boolean biodinfoTranslateSpider(@PathVariable("treeid") String treeid, @PathVariable(name = "id", required = false) String id) {
        try {
            return biodinfoTranslateSpiderService.fetchTranslate(id, treeid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 初始treeid:[
     * 11b1c7f7-80df-42b0-b0d5-8e770a245c26
     * f359fe39-0bee-4f69-89a2-f86758d256e6
     * cc9550f4-3c0c-40fa-a497-c90a6dacbeb1
     * fc90163c-c149-424d-b3bb-ab9b4689096c
     * e17f16f8-f0c5-41f0-a30c-dab5ff962854
     * ]
     *
     * @param treeid
     * @return
     */
    @RequestMapping("{treeid}")
    public boolean biodinfoTranslateSpider(@PathVariable("treeid") String treeid) {
        try {
            return biodinfoTranslateSpiderService.fetchTranslate(null, treeid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
