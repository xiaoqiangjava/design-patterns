package com.xq.learn.service;

/**
 * 业务接口，用于动态代理创建代理对象
 * @author xiaoqiang
 * @date 2019/9/12 1:57
 */
public interface IService
{
    String getName();

    String getName(int id);
}
