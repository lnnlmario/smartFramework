package com.wingwang.framework.bean;

import com.wingwang.framework.util.CastUtil;
import com.wingwang.framework.util.CollectionUtil;

import java.util.Map;

/**
 * 请求参数对象
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取 long 型参数值
     * @param name
     * @return
     */
    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * 获取所有字段信息
     * @return
     */
    public Map<String, Object> getMap() {
        return paramMap;
    }

    /**
     * 验证参数是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return CollectionUtil.isEmpty(paramMap);
    }
}
