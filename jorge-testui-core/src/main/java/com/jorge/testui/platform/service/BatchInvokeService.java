/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-07-02
 *
 */
package com.jorge.testui.platform.service;

import com.acooly.core.common.service.EntityService;
import com.jorge.testui.platform.entity.BatchInvoke;

/**
 * 用例执行批次表 Service接口
 *
 * @author mufanglin
 * @date 2020-07-02 17:05:42
 */
public interface BatchInvokeService extends EntityService<BatchInvoke> {

    void deleteBatchInvokeByCreateTime();
}
