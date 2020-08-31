/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-07-31
 *
 */
package com.jorge.testui.platform.service;

import com.acooly.core.common.service.EntityService;
import com.jorge.testui.platform.entity.CaseRequestParameter;

/**
 * case_request_parameter Service接口
 *
 * Date: 2019-07-31 18:31:50
 * @author mufanglin
 *
 */
public interface CaseRequestParameterService extends EntityService<CaseRequestParameter> {

    void deleteCaseRequestParameterAll();

}
