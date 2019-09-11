package com.xq.learn.lazy;

/**
 * 使用双重判断加锁锁实现懒汉式单例
 * @author xiaoqiang
 * @date 2019/9/12 1:20
 */
public class SingletonPattern
{
    private static SingletonPattern instance;

    /**
     * 私有构造器，防止外部直接调用，但是可以通过反射来获取实例
     */
    private SingletonPattern()
    {
    }

    /**
     * 双重判断，保证单例以及线程安全，并且尽可能小的减小锁的范围
     * @return instance
     */
    public static SingletonPattern getInstance()
    {
        // 当实例未创建时，加锁创建，否则直接返回，减小锁的粒度，外层判断提高性能，当实例已经存在时，不
        // 用每次排队等候获取实例，提高并发量，内层判断防止并发时，创建出多个实例
        if (null == instance)
        {
            synchronized (SingletonPattern.class)
            {
                if (null == instance)
                {
                    instance = new SingletonPattern();
                }
            }
        }

        return instance;
    }

}
