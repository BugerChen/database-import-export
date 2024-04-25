package com.database.mysql.utils;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.*;

/**
 * Bean工具
 * 
 * @author guo.jun
 */
@Slf4j
public class BeanUtil {
    
    /**
     * 简单Bean属性拷贝
     * 
     * @param source 源
     * @param target 目标
     */
    public static void copy(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }





    /**
     * 简单Bean属性拷贝
     *
     * @param source 源
     * @param target 目标
     */
    public static void copy(Object source, Object target, String... ignoreFields) {
        BeanUtils.copyProperties(source, target,ignoreFields);
    }
    
    /**
     * 简单Bean属性拷贝，返回目标对象实例
     *
     * @param source 源
     * @param targetClass 目标类
     * @return 目标
     */
    public static <T> T copy(Object source, Class<T> targetClass) {
        try {
            T target = targetClass.newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        }
        catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 简单Bean属性拷贝，返回目标对象实例
     *
     * @param source 源
     * @param targetClass 目标类
     * @return 目标
     */
    public static <T> T copy(Object source, Class<T> targetClass, String... ignoreFields) {
        try {
            T target = targetClass.newInstance();
            BeanUtils.copyProperties(source, target,ignoreFields);
            return target;
        }
        catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * List对象拷贝
     * 
     * @param sourceList 源列表
     * @param targetClass 目标类
     * @return 目标列表
     */
    public static <T> List<T> copyList(List<?> sourceList, Class<T> targetClass, String... ignoreFields) {
        try {
            if (null == sourceList || sourceList.isEmpty()){
                return Collections.EMPTY_LIST;
            }
            List<T> targetList = new ArrayList<T>();
            for (Object source : sourceList) {
                T target = targetClass.newInstance();
                BeanUtils.copyProperties(source,target,ignoreFields);
                targetList.add(target);
            }
            return targetList;
        }
        catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }


}
