package com.wingwang.chapter2.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性文件工具类
 */
public final class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     */
    public static Properties loadProps(String filename){

        Properties props = null;
        InputStream is = null;

        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
            if (null == is){
                throw new FileNotFoundException(filename + " file is not found");
            }

            props = new Properties();
            props.load(is);
        } catch (IOException e){
            LOGGER.error("load properties file failure", e);
        } finally {
            if ( null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("close input stream failure", e);
                }
            }
        }

        return props;
    }

    /**
     * 获取字符型属性（默认值为空字符串）
     */
    public static String getString(Properties props, String key){
        return getString(props, key, "");
    }

    /**
     * 获取字符型属性（可指定默认值）
     */
    public static String getString(Properties props, String key, String defaultValue){

        String retValue = defaultValue;

        if (props.containsKey(key)){
            retValue = props.getProperty(key);
        }

        return retValue;
    }

    /**
     * 获取数值型属性（默认值0）
     */
    public static int getInt(Properties props, String key){
        return getInt(props, key, 0);
    }

    /**
     * 获取数值型属性（可指定默认值）
     */
    public static int getInt(Properties props, String key, int defaulValue) {

        int retValue = defaulValue;

        if (props.containsKey(key)){
            retValue = CastUtil.castInt(props.getProperty(key));
        }

        return retValue;
    }

    /**
     * 获取布尔型属性（默认值是false)
     */
    public static boolean getBoolean(Properties props, String key){
        return getBoolean(props, key, false);
    }

    /**
     * 获取布尔型属性（可指定默认值)
     */
    public static boolean getBoolean(Properties props, String key, boolean defaultValue){
        boolean retValue = defaultValue;

        if (props.containsKey(key)){
           retValue = CastUtil.castBoolean(props.getProperty(key));
        }

        return retValue;
    }
}
