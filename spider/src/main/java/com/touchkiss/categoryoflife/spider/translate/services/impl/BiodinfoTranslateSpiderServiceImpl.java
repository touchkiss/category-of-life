package com.touchkiss.categoryoflife.spider.translate.services.impl;

import com.touchkiss.categoryoflife.spider.constants.UrlConstants;
import com.touchkiss.categoryoflife.spider.translate.bean.convertor.BiodinfoTranslateConvertor;
import com.touchkiss.categoryoflife.spider.translate.bean.response.BiodinfoTranslateResponse;
import com.touchkiss.categoryoflife.spider.translate.services.BiodinfoTranslateSpiderService;
import com.touchkiss.categoryoflife.translate.bean.Translate;
import com.touchkiss.categoryoflife.translate.services.TranslateDaoService;
import com.touchkiss.categoryoflife.utils.AHttpUtil;
import com.touchkiss.categoryoflife.utils.GsonUtil;
import com.touchkiss.categoryoflife.utils.HttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created on 2020/03/21 17:12
 *
 * @author Touchkiss
 */
@Service
public class BiodinfoTranslateSpiderServiceImpl implements BiodinfoTranslateSpiderService {
    @Autowired
    private BiodinfoTranslateConvertor biodinfoTranslateConvertor;
    @Autowired
    private TranslateDaoService translateDaoService;
    @Autowired
    private AHttpUtil aHttpUtil;

    @Override
    public boolean fetchTranslate(String id, String treeid) throws IOException {
        String url = UrlConstants.Biodinfo_FETCH_URL + "?treeid=" + treeid;
        boolean notBlank = StringUtils.isNotBlank(id);
        if (notBlank) {
            url += "&id=" + id;
        }
        String response = aHttpUtil.post(url,"");
        BiodinfoTranslateResponse biodinfoTranslateResponse = GsonUtil.fromJson(response, BiodinfoTranslateResponse.class);
        if (biodinfoTranslateResponse != null) {
            biodinfoTranslateResponse.forEach(biodinfoTranslateBO -> {
                if (CollectionUtils.isEmpty(translateDaoService.queryTranslateList(new HashMap() {{
                    put("canonicalName", biodinfoTranslateBO.getCanonicalName());
                    put("language", "Chinese");
                }})) || StringUtils.isBlank(id)) {
                    Translate translate = biodinfoTranslateConvertor.convert(biodinfoTranslateBO);
                    translateDaoService.insert(translate);
                }
            });
        }
        if (notBlank) {
            List<Translate> lid = translateDaoService.queryTranslateList(new HashMap() {{
                put("lid", id);
            }});
            if (!CollectionUtils.isEmpty(lid)) {
                Translate translate = lid.get(0);
                translate.setFetched(true);
                translateDaoService.updateById(translate, translate.getId());
            }
        }
        return true;
    }

    @Override
    public void autoFetch() {
        List<Translate> list = translateDaoService.queryTranslateList(new HashMap() {{
            put("fetched", "0");
            put("limit", "limit 10");
        }});
        list.forEach(translate -> {
            try {
                fetchTranslate(translate.getLid(), translate.getTreeId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
