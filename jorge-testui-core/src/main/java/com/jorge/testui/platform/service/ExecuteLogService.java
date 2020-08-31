/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-11-29
 *
 */
package com.jorge.testui.platform.service;

import com.acooly.core.common.service.EntityService;
import com.jorge.testui.platform.entity.ExecuteLog;

/**
 * execute_log Service接口
 *
 * Date: 2019-11-29 18:06:13
 * @author mufanglin
 *
 */
public interface ExecuteLogService extends EntityService<ExecuteLog> {

    void deleteExecuteLogByCreateTime();
}
