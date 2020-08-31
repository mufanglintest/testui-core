/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-07-02
 */
package com.jorge.testui.platform.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.platform.service.BatchInvokeService;
import com.jorge.testui.platform.dao.BatchInvokeDao;
import com.jorge.testui.platform.entity.BatchInvoke;

/**
 * 用例执行批次表 Service实现
 *
 * @author mufanglin
 * @date 2020-07-02 17:05:42
 */
@Service("batchInvokeService")
public class BatchInvokeServiceImpl extends EntityServiceImpl<BatchInvoke, BatchInvokeDao> implements BatchInvokeService {

    @Override
    public void deleteBatchInvokeByCreateTime() {
        this.getEntityDao().deleteBatchInvokeByCreateTime();
    }
}
