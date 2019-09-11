package com.xq.learn.service.impl;

import com.xq.learn.service.IService;

/**
 * @author xiaoqiang
 * @date 2019/9/12 2:09
 */
public class ServiceImpl implements IService
{
    @Override
    public String getName()
    {
        return "xiaoqiang";
    }

    @Override
    public String getName(int id)
    {
        return "wenwen";
    }
}
