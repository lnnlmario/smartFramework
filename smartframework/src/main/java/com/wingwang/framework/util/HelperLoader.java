package com.wingwang.framework.util;

import com.wingwang.framework.helper.BeanHelper;
import com.wingwang.framework.helper.ClassHelper;
import com.wingwang.framework.helper.ControllerHelper;
import com.wingwang.framework.helper.IocHelper;

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
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> clazz : classList) {
            ClassUtil.loadClass(clazz.getName(), true);
        }
    }

}
