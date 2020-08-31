/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-04
 */
 package com.jorge.testui.platform.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.platform.entity.LogInfo;
import org.apache.ibatis.annotations.Delete;

/**
 * log_info Mybatis Dao
 *
 * Date: 2019-12-04 11:37:18
 * @author mufanglin
 */
public interface LogInfoDao extends EntityMybatisDao<LogInfo> {

    /**
     * 删除三十天内的执行日志
     */
    @Delete("delete from log_info where DATE_SUB(CURDATE(), INTERVAL 10 DAY) >= date(create_time)")
    void deleteLoginfoByCreateTime();
}
