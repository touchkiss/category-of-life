package com.touchkiss.catelogueoflife.spider.species.bean.convertor;

import com.touchkiss.catelogueoflife.species.bean.SpeciesReferences;
import com.touchkiss.catelogueoflife.spider.base.BaseConvertor;
import com.touchkiss.catelogueoflife.spider.species.bean.bo.SpeciesReferencesBO;
import com.touchkiss.catelogueoflife.utils.NumberUtil;
import org.springframework.stereotype.Component;

/**
 * Created on 2020/03/21 11:22
 *
 * @author Touchkiss
 */
@Component
public class SpeciesReferencesConvertor implements BaseConvertor<SpeciesReferences, SpeciesReferencesBO> {
    @Override
    public SpeciesReferences convert(SpeciesReferencesBO speciesReferencesBO) {
        if (speciesReferencesBO == null) {
            return null;
        }
        SpeciesReferences speciesReferences = new SpeciesReferences();
        speciesReferences.setAuthor(speciesReferencesBO.getAuthor());
        speciesReferences.setYear(NumberUtil.stringToInt(speciesReferencesBO.getYear()));
        speciesReferences.setSource(speciesReferencesBO.getSource());
        return speciesReferences;
    }
}
