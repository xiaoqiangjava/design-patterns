package com.xq.learn.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用jdk中的动态代理，代理无无实现类的接口
 * @author xiaoqiang
 * @date 2019/9/12 1:48
 */
public class ProxyFacade<T> implements InvocationHandler
{
    @SuppressWarnings("unchecked")
    public T getIntance(Class<T> clazz)
    {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
    }

    /**
     * 对代理对象上面的所有方法的调用，都会调用到该方法，并且将原方法作为参数传递过来
     * @param proxy 代理对象
     * @param method 实际调用的方法
     * @param args 实际调用方法参数
     * @return 方法调用的结果
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("没有实现类的动态代理。");
        System.out.println(method.getName());
        System.out.println("在这里可以做一些方法调用，比如MyBatis的Mapper接口，就是在这里做了相应的数据库操作");
        return null;
    }
}
