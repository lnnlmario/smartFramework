package com.wingwang.framework.helper;


import com.wingwang.framework.annotation.Inject;
import com.wingwang.framework.util.ReflectionUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手类
 *
 * 一个简单的Ioc框架，此时Ioc框架中所管理的对象都是单例的，因为是从BeanHelper类中获取Bean Map的，
 * 而Bean Map中的对象都是事先创建好并放入到这个Bean容器的，所有的对象都是单例的
 */
public class IocHelper {

    /**
     * 这个类被加载的时候，就会加载静态代码块，完成Ioc容器的初始化工作，
     * 在框架中会有一个统一的地方来加载这个IocHelper
     */
    static {
        // 获取所有的Bean类与Bean实例之间的映射关系（简称Bean Map）
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (MapUtils.isNotEmpty(beanMap)) {
            // 遍历 Bean Map
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                // 从 BeanMap 中获取Bean类与Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                // 获取Bean类定义的所有成员变量（简称 Bean field）
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtils.isNotEmpty(beanFields)) {
                    // 遍历Bean Field
                    for (Field beanField : beanFields) {
                        // 判断当前 Bean Field 是否带有Inject注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            // 在 Bean Map中获取Bean Field对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (null != beanFieldInstance) {
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
