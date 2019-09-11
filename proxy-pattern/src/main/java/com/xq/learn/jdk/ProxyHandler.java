package com.xq.learn.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用jdk的代理模式，实现方法增强的功能，比如事物的开启
 * 动态代理的好处是不用每个对象都去创建一个代理类，所有的对象都用同一个代理类
 * jdk代理时必须要有接口，如果需要代理一个没有实现接口的类，需要使用cglib
 * @author xiaoqiang
 * @date 2019/9/12 2:02
 */
public class ProxyHandler<T> implements InvocationHandler
{
    private T target;

    @SuppressWarnings("unchecked")
    public T getInstance(T t)
    {
        this.target = t;
        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), this);
    }

    /**
     * 所有代理对象方法的调用都会将方法信息封装之后传递到该方法上面来，需要注意的是，反射调用
     * 真实方法时，不能使用proxy对象，这样会造成方法循环调用，最后栈溢出。
     * spring中的拦截器，事物等都是使用动态代理实现
     * @param proxy 代理对象
     * @param method 调用的方法
     * @param args 方法参数
     * @return 方法的返回结果
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        // 通过反射调用真实方法，在调用方法前后可以做一些方法增强的操作
        System.out.println("调用方法之前");
        Object result = method.invoke(target, args);
        System.out.println("调用方法之后。");
        return result;
    }
}
