/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-29
 */
package com.jorge.testui.platform.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.platform.service.ExecuteLogService;
import com.jorge.testui.platform.dao.ExecuteLogDao;
import com.jorge.testui.platform.entity.ExecuteLog;

/**
 * execute_log Service实现
 *
 * Date: 2019-11-29 18:06:13
 *
 * @author mufanglin
 *
 */
@Service("executeLogService")
public class ExecuteLogServiceImpl extends EntityServiceImpl<ExecuteLog, ExecuteLogDao> implements ExecuteLogService {

    @Override
    public void deleteExecuteLogByCreateTime() {
        this.getEntityDao().deleteExecuteLogByCreateTime();
    }
}
