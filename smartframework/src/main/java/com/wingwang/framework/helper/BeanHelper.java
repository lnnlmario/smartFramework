package com.wingwang.framework.helper;

import com.wingwang.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean助手类
 *
 * 相当于一个Bean容器，因为在Bean Map中存放了Bean类与Bean实例的映射关系，只需要调用getBean方法传入一个Bean类，就能获取Bean实例
 */
public final class BeanHelper {

    /**
     * 定义Bean映射(用于存放Bean类与Bean实例的映射关系)
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }

    /**
     * 获取Bean映射
     * @return
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取Bean实例
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        if (!BEAN_MAP.containsKey(clazz)) {
            throw new RuntimeException("can not get bean by class: " + clazz);
        }
        return (T) BEAN_MAP.get(clazz);
    }
}
