/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-07-23
 *
 */
package com.jorge.testui.platform.service;

import com.acooly.core.common.service.EntityService;
import com.jorge.testui.platform.entity.Parameters;
import com.jorge.testui.system.dto.ParameterStatusDto;

import java.util.List;

/**
 * 用例入参表 Service接口
 *
 * Date: 2019-07-23 15:29:31
 * @author mufanglin
 *
 */
public interface ParametersService extends EntityService<Parameters> {

    Parameters findParametersByCaseNoAndParametersNo(String caseNo,String parametersNo);

    List<Parameters> findListParametersByCaseNo(String caseNo);

    int countListParametersByLastImplementResult(Boolean lastImplementResult);

    List<ParameterStatusDto> countParameterStatus();
    void deleteParametersByCaseNo(String caseNo);
}
