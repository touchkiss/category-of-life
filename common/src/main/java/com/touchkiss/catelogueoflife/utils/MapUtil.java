package com.touchkiss.catelogueoflife.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on 2020/03/19 9:51
 *
 * @author Touchkiss
 */
public class MapUtil {
    public final static Map<String,String> EMPTY_MAP=new HashMap<>();
    public static Map<String, Object> toMap(final Object obj, final boolean keepNull) {
        return Arrays.stream(obj.getClass().getDeclaredFields()).filter(field -> {
            field.setAccessible(true);
            try {
                return keepNull || field.get(obj) != null;
            } catch (Exception e) {
//                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toMap(Field::getName, field -> {
            field.setAccessible(true);
            try {
                return field.get(obj) == null ? "" : field.get(obj);
            } catch (Exception e) {
//                e.printStackTrace();
            }
            return "";
        }));
    }

    public static <T> T mapToObject(Map<String, Object> map, Class<T> clazz) {
        try {
            Object obj = clazz.newInstance();
            Arrays.stream(clazz.getDeclaredFields())
                    .filter(field -> map.containsKey(field.getName()))
                    .forEach(field -> {
                        String fieldName = field.getName();
                        field.setAccessible(true);
                        try {
                            field.set(obj, field.getType().cast(map.get(fieldName)));
                        } catch (IllegalAccessException | ClassCastException e) {
//                            e.printStackTrace();
                        }
                    });
            return clazz.cast(obj);
        } catch (InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
        }
        return null;
    }
}
