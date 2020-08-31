/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-04
 *
 */
package com.jorge.testui.platform.service;

import com.acooly.core.common.service.EntityService;
import com.jorge.testui.platform.entity.LogInfo;

/**
 * log_info Service接口
 *
 * Date: 2019-12-04 11:37:17
 * @author mufanglin
 *
 */
public interface LogInfoService extends EntityService<LogInfo> {

    void deleteLogInfoByCreateTime();
}
