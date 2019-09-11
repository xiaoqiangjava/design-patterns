package com.xq.learn.lazy;

import org.junit.Test;

/**
 * @author xiaoqiang
 * @date 2019/9/12 1:29
 */
public class SingletonPatternTest
{
    @Test
    public void testGetInstance()
    {
        for (int i = 0; i < 1000; i++)
        {
            new Thread(() -> System.out.println(SingletonPattern.getInstance())).start();
        }
    }
}
