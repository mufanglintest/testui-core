/*
 * acooly.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */
package com.jorge.testui.service.base;

import com.jorge.testui.message.CaseBaseRequest;
import com.jorge.testui.message.CaseBaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Api服务基类
 *
 * <p>提供转换工具和帮助支持
 *
 * @author zhangpu
 * @date 2014年5月16日
 */
public abstract class BaseCaseService<O extends CaseBaseRequest, R extends CaseBaseResponse>
    extends AbstractCaseService<O, R> {
    protected static Logger log = LoggerFactory.getLogger(BaseCaseService.class);

    public BaseCaseService() {
    }
}
