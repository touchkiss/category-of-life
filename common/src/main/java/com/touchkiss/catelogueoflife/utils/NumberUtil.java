package com.touchkiss.catelogueoflife.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created on 2020/03/18 17:15
 *
 * @author Touchkiss
 */
public class NumberUtil {
    public static int stringToInt(String numberStr) {
        if (StringUtils.isNotBlank(numberStr)) {
            try {
                return Integer.parseInt(numberStr.replaceAll("[,?]", ""));
            }catch (Exception e){
//                e.printStackTrace();
            }
        }
        return 0;
    }
}
