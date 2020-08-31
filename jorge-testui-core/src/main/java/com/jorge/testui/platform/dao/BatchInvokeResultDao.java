/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-07-03
 */
 package com.jorge.testui.platform.dao;

import org.apache.ibatis.annotations.Delete;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.platform.entity.BatchInvokeResult;

/**
 * 批次执行结果数据 Mybatis Dao
 *
 * @author mufanglin
 * @date 2020-07-03 17:12:38
 */
public interface BatchInvokeResultDao extends EntityMybatisDao<BatchInvokeResult> {
   @Delete("delete from batch_invoke_result where DATE_SUB(CURDATE(), INTERVAL 5 DAY) >= date(create_time)")
   void deleteBatchInvokeResultByCreateTime();
}
