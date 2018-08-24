package com.wingwang.framework.util;

import com.wingwang.framework.helper.*;

/**
 * 加载相应的 Helper 类
 *
 * ClassHelper，BeanHelper，IocHelper，ControllerHelper这四个Helper类的入口程序来加载它们，
 * 实际上是用来加载它们的静态块
 *
 * 实际上当我们第一次访问类时，就会加载其static块，这里只是为了让加载更加集中，所以才写了一个HelperLoader类
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                // 必须在 IocHelper 前加载，首先要通过 AopHelper 获取代理对象，然后才能通过 IocHelper进行依赖注入
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> clazz : classList) {
            ClassUtil.loadClass(clazz.getName(), true);
        }
    }

}
