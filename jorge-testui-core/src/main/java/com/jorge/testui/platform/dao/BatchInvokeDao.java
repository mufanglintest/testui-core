/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-07-02
 */
 package com.jorge.testui.platform.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.platform.entity.BatchInvoke;
import org.apache.ibatis.annotations.Delete;

/**
 * 用例执行批次表 Mybatis Dao
 *
 * @author mufanglin
 * @date 2020-07-02 17:05:42
 */
public interface BatchInvokeDao extends EntityMybatisDao<BatchInvoke> {

    @Delete("delete from batch_invoke where DATE_SUB(CURDATE(), INTERVAL 5 DAY) >= date(create_time)")
    void deleteBatchInvokeByCreateTime();
}
