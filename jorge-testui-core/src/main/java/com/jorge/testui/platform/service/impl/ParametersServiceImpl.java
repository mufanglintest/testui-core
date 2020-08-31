/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-07-23
 */
package com.jorge.testui.platform.service.impl;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.platform.dao.ParametersDao;
import com.jorge.testui.platform.entity.Parameters;
import com.jorge.testui.platform.service.ParametersService;
import com.jorge.testui.system.dto.ParameterStatusDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用例入参表 Service实现
 *
 * Date: 2019-07-23 15:29:31
 *
 * @author mufanglin
 *
 */
@Service("parametersService")
public class ParametersServiceImpl extends EntityServiceImpl<Parameters, ParametersDao> implements ParametersService {

    @Override
    public Parameters findParametersByCaseNoAndParametersNo(String caseNo, String parametersNo) {
        return this.getEntityDao().findParametersByCaseNoAndParametersNo(caseNo,parametersNo);
    }

    @Override
    public List<Parameters> findListParametersByCaseNo(String caseNo) {
        return this.getEntityDao().findListParametersByCaseNo(caseNo);
    }

    @Override
    public int countListParametersByLastImplementResult(Boolean lastImplementResult) {
        return this.getEntityDao().countParametersByLastImplementResult(lastImplementResult);
    }

    @Override
    public List<ParameterStatusDto> countParameterStatus() {
        List<ParameterStatusDto> list  = this.getEntityDao().countParameterStatus();
        return list;
    }

    @Override
    public void deleteParametersByCaseNo(String caseNo) {
        this.getEntityDao().deleteParametersByCaseNo(caseNo);
    }
}
