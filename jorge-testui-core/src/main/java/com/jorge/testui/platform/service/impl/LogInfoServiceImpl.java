/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-04
 */
package com.jorge.testui.platform.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.platform.service.LogInfoService;
import com.jorge.testui.platform.dao.LogInfoDao;
import com.jorge.testui.platform.entity.LogInfo;

/**
 * log_info Service实现
 *
 * Date: 2019-12-04 11:37:18
 *
 * @author mufanglin
 *
 */
@Service("logInfoService")
public class LogInfoServiceImpl extends EntityServiceImpl<LogInfo, LogInfoDao> implements LogInfoService {

    @Override
    public void deleteLogInfoByCreateTime() {
        this.getEntityDao().deleteLoginfoByCreateTime();
    }
}
