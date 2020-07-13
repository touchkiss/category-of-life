package com.touchkiss.catelogueoflife.spider.species.bean.convertor;

import com.touchkiss.catelogueoflife.species.bean.SpeciesCommonNameReferences;
import com.touchkiss.catelogueoflife.spider.base.BaseConvertor;
import com.touchkiss.catelogueoflife.spider.species.bean.bo.SpeciesCommonNameReferencesBO;
import com.touchkiss.catelogueoflife.utils.NumberUtil;
import org.springframework.stereotype.Component;

/**
 * Created on 2020/03/21 11:16
 *
 * @author Touchkiss
 */
@Component
public class SpeciesCommonNameReferencesConvertor implements BaseConvertor<SpeciesCommonNameReferences, SpeciesCommonNameReferencesBO> {
    @Override
    public SpeciesCommonNameReferences convert(SpeciesCommonNameReferencesBO speciesCommonNameReferencesBO) {
        if (speciesCommonNameReferencesBO==null){
            return null;
        }
        SpeciesCommonNameReferences speciesCommonNameReferences = new SpeciesCommonNameReferences();
        speciesCommonNameReferences.setAuthor(speciesCommonNameReferencesBO.getAuthor());
        speciesCommonNameReferences.setYear(NumberUtil.stringToInt(speciesCommonNameReferencesBO.getYear()));
        speciesCommonNameReferences.setSource(speciesCommonNameReferencesBO.getSource());
        return speciesCommonNameReferences;
    }
}
