package com.project.QuickProject.monitor.utils;

import java.lang.reflect.Field;

/**
 * EntryUtil
 *
 * @author Jimmey-Jiang
 * @date 2020/8/8
 */
public class EntryUtil {

    public static <T> T setValue(T t, String fieldName, Object value){
        try {
            Field field = t.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(t,value);
            return t;
        }catch (Exception e){
            return t;
        }
    }
}
