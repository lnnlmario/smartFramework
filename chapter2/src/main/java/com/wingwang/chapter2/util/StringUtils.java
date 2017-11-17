package com.wingwang.chapter2.util;

/**
 * 字符串工具类
 */
public final class StringUtils {

    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str){
        if (null != str){
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     *  判断字符串是否非空
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}

