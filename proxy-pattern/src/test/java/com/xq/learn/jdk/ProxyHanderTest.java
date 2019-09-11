package com.xq.learn.jdk;

import com.xq.learn.service.IService;
import com.xq.learn.service.impl.ServiceImpl;
import org.junit.Test;

/**
 * @author xiaoqiang
 * @date 2019/9/12 2:11
 */
public class ProxyHanderTest
{
    @Test
    public void testProxy()
    {
        ProxyHandler<IService> proxy = new ProxyHandler<>();
        IService instance = proxy.getInstance(new ServiceImpl());
        System.out.println(instance.getName());
        System.out.println(instance.getName(1));
    }
}
