package com.wingwang.framework.proxy;

/**
 * 代理接口
 */
public interface Proxy {

    /**
     * 执行链式代理
     *
     * 所谓的链式代理，可将多个代理通过一条链子串起来，一个个地去执行，执行的顺序取决于添加到链上的先后顺序
     *
     * @param proxyChain
     * @return
     * @throws Throwable
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
