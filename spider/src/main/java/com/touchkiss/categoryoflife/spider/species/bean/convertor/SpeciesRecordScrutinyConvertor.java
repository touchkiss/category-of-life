package com.touchkiss.categoryoflife.spider.species.bean.convertor;

import com.touchkiss.categoryoflife.species.bean.SpeciesRecordScrutiny;
import com.touchkiss.categoryoflife.spider.base.BaseConvertor;
import com.touchkiss.categoryoflife.spider.species.bean.bo.SpeciesRecordScrutinyBO;
import com.touchkiss.categoryoflife.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.ParseException;

/**
 * Created on 2020/03/21 11:17
 *
 * @author Touchkiss
 */
@Component
public class SpeciesRecordScrutinyConvertor implements BaseConvertor<SpeciesRecordScrutiny, SpeciesRecordScrutinyBO> {
    @Override
    public SpeciesRecordScrutiny convert(SpeciesRecordScrutinyBO speciesRecordScrutinyBO) {
        if (speciesRecordScrutinyBO==null){
            return null;
        }
        SpeciesRecordScrutiny speciesRecordScrutiny = new SpeciesRecordScrutiny();
        speciesRecordScrutiny.setScrutiny(speciesRecordScrutinyBO.getScrutiny());
        return speciesRecordScrutiny;
    }
}
