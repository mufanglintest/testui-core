/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-07-31
 */
package com.jorge.testui.platform.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.platform.service.CaseRequestParameterService;
import com.jorge.testui.platform.dao.CaseRequestParameterDao;
import com.jorge.testui.platform.entity.CaseRequestParameter;

/**
 * case_request_parameter Service实现
 *
 * Date: 2019-07-31 18:31:50
 *
 * @author mufanglin
 *
 */
@Service("caseRequestParameterService")
public class CaseRequestParameterServiceImpl extends EntityServiceImpl<CaseRequestParameter, CaseRequestParameterDao> implements CaseRequestParameterService {

    @Override
    public void deleteCaseRequestParameterAll() {
        this.getEntityDao().deleteCaseRequestParameterAll();
    }
}
