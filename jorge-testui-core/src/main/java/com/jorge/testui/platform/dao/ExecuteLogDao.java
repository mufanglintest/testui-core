/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-29
 */
 package com.jorge.testui.platform.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.platform.entity.ExecuteLog;
import org.apache.ibatis.annotations.Delete;

/**
 * execute_log Mybatis Dao
 *
 * Date: 2019-11-29 18:06:13
 * @author mufanglin
 */
public interface ExecuteLogDao extends EntityMybatisDao<ExecuteLog> {

    /**
     * 删除三十天内的执行日志
     */
    @Delete("delete from execute_log where DATE_SUB(CURDATE(), INTERVAL 10 DAY) >= date(create_time)")
    void deleteExecuteLogByCreateTime();
}
