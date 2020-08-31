/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-07-03
 */
package com.jorge.testui.platform.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.platform.service.BatchInvokeResultService;
import com.jorge.testui.platform.dao.BatchInvokeResultDao;
import com.jorge.testui.platform.entity.BatchInvokeResult;

/**
 * 批次执行结果数据 Service实现
 *
 * @author mufanglin
 * @date 2020-07-03 17:12:38
 */
@Service("batchInvokeResultService")
public class BatchInvokeResultServiceImpl extends EntityServiceImpl<BatchInvokeResult, BatchInvokeResultDao> implements BatchInvokeResultService {

    @Override
    public void deleteBatchInvokeResultByCreateTime() {
        this.getEntityDao().deleteBatchInvokeResultByCreateTime();
    }
}
