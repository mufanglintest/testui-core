/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-07-03
 *
 */
package com.jorge.testui.platform.service;

import com.acooly.core.common.service.EntityService;
import com.jorge.testui.platform.entity.BatchInvokeResult;

/**
 * 批次执行结果数据 Service接口
 *
 * @author mufanglin
 * @date 2020-07-03 17:12:38
 */
public interface BatchInvokeResultService extends EntityService<BatchInvokeResult> {

    void deleteBatchInvokeResultByCreateTime();
}
