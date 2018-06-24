package com.wingwang.framework.util;


/**
 * 转型操作工具类
 */
public final class CastUtil {

    /**
     * 转型为String
     */
    public static String castString(Object obj){
        return castString(obj, "");
    }

    /**
     * 转为String类（提供默认值）
     */
    public static String castString(Object obj, String defaultVal){
        return null != obj ? String.valueOf(obj) : defaultVal;
    }

    /**
     * 转为double型
     */
    public static double castDouble(Object obj){
        return castDouble(obj, 0);
    }

    /**
     * 转为double型（提供默认值）
     */
    public static double castDouble(Object obj, double defaultVal){
        double retVal = defaultVal;

        if (null != obj){
            String doubleStr = castString(obj);
            if (StringUtil.isNotEmpty(doubleStr)){
                try {
                    retVal = Double.parseDouble(doubleStr);
                } catch (NumberFormatException e){
                    retVal = defaultVal;
                }
            }
        }

        return retVal;
    }

    /**
     * 转为long型
     */
    public static long castLong(Object obj){
        return castLong(obj, 0L);
    }

    /**
     * 转为long型（提供默认值）
     */
    public static long castLong(Object obj, long defaultVal){
        long retVal = defaultVal;

        if (null != obj){
            String longStr = castString(obj);
            if (StringUtil.isNotEmpty(longStr)) {
                try {
                    retVal = Long.parseLong(longStr);
                } catch (NumberFormatException e){
                    retVal = defaultVal;
                }
            }
        }

        return retVal;
    }

    /**
     * 转为int型
     */
    public static int castInt(Object obj){
        return castInt(obj, 0);
    }

    /**
     * 转为int型（提供默认值）
     */
    public static int castInt(Object obj, int defaultVal){
        int retVal = defaultVal;

        if (null != obj){
            String intStr = castString(obj);
            if (StringUtil.isNotEmpty(intStr)){
                try {
                    retVal = Integer.parseInt(intStr);
                } catch (NumberFormatException e){
                    retVal = defaultVal;
                }
            }
        }

        return retVal;
    }

    /**
     * 转为boolean型
     */
    public static boolean castBoolean(Object obj){
        return castBoolean(obj, false);
    }

    /**
     * 转为boolean型（提供默认值）
     */
    public static boolean castBoolean(Object obj, boolean defaultVal){
        boolean retVal = defaultVal;

        if (null != obj){
            String booleanStr = castString(obj);
            if (StringUtil.isNotEmpty(booleanStr)){
                try {
                    retVal = Boolean.parseBoolean(booleanStr);
                } catch (NumberFormatException e){
                    retVal = defaultVal;
                }
            }
        }

        return retVal;
    }
}
