package com.xq.learn.jdk.cglib;

import com.xq.learn.cglib.ProxyHandler;
import com.xq.learn.service.impl.ServiceImpl;
import org.junit.Test;

/**
 * @author xiaoqiang
 * @date 2019/9/12 2:31
 */
public class ProxyHandlerTest
{
    @Test
    public void testProxy()
    {
        ProxyHandler<ServiceImpl> proxy = new ProxyHandler<>();
        // 获取代理对象
        ServiceImpl instance = proxy.getInstance(new ServiceImpl());
        System.out.println(instance.getName());
        System.out.println(instance.getName(1));
    }
}
