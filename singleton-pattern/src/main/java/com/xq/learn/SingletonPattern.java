package com.xq.learn;

/**
 * 单例模式：使用静态内部类实现
 * 静态内部类不会再类加载的时候初始化，只有到使用的时候才会初始化，静态属性只会初始化一次，利用静态内部类
 * 的这个属性，可以实现线程安全的单例模式，还可以避免同步带来的性能消耗。是一种比较优雅的内部类实现
 * 这种实现可以通过反射来创建出类的实例。
 * @author xiaoqiang
 * @date 2019/9/12 1:06
 */
public class SingletonPattern
{
    private SingletonPattern()
    {
        System.out.println("私有构造方法，防止外部调用。");
    }

    /**
     * 静态内部类，持有外部类的静态属性，只有在使用时才会加载，而且只会加载一次
     */
    private static class SingletonHandler
    {
        private static final SingletonPattern INSTANCE = new SingletonPattern();
    }

    /**
     * 提供全局获取单例实例的方法
     * @return instance 单例实例
     */
    public static SingletonPattern getInstance()
    {
        return SingletonHandler.INSTANCE;
    }
}
