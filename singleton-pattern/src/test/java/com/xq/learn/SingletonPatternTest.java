package com.xq.learn;

import org.junit.Test;

/**
 * @author xiaoqiang
 * @date 2019/9/12 1:13
 */
public class SingletonPatternTest
{
    @Test
    public void testSingleton()
    {
        System.out.println("测试单例模式，这句话应该最先输出");
        for (int i = 0; i < 1000; i++)
        {
            new Thread(() -> System.out.println(SingletonPattern.getInstance())).start();
        }
    }
}
