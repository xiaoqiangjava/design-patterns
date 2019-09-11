package com.xq.learn.cglib;

import java.lang.reflect.Method;
import java.util.Arrays;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib动态代理也可以叫做子类动态代理，可以代理没有接口的类，需要实现MethodInterceptor这个接口
 * 所有在代理对象上面的方法调用最后都会调用intercept方法。
 * @author xiaoqiang
 * @date 2019/9/12 2:18
 */
public class ProxyHandler<T> implements MethodInterceptor
{
    @SuppressWarnings("unchecked")
    public T getInstance(T t)
    {
        // 通过enhancer对象，创建代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(t.getClass());
        // 设置回调类
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }
    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable
    {
        System.out.println("方法调用之前。。");
        Object result = methodProxy.invokeSuper(target, args);
        System.out.println("方法调用之后。。");
        return result;
    }
}
