package com.xq.learn.jdk;

import com.xq.learn.service.IService;
import org.junit.Test;

/**
 * @author xiaoqiang
 * @date 2019/9/12 1:58
 */
public class ProxyFacadeTest
{
    @Test
    public void testProxy()
    {
        ProxyFacade<IService> proxy = new ProxyFacade<>();
        IService instance = proxy.getIntance(IService.class);
        instance.getName();
        instance.getName(1);
    }
}
