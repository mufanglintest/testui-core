/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-07-16
 *
 */
package com.jorge.testui.platform.service;

import com.acooly.core.common.service.EntityService;
import com.jorge.testui.platform.entity.TestCase;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Test;

import java.util.List;

/**
 * test_case Service接口
 *
 * Date: 2019-07-16 16:08:56
 * @author mufanglin
 *
 */
public interface TestCaseService extends EntityService<TestCase> {

    TestCase findByCaseNo(String caseNo);
    TestCase findTestCase(String key,Object value);

    TestCase findByCaseNoAndProjectNo(String caseNo,String projectNo);

    List<TestCase> findListByCaseNo(String caseNo);

    List<TestCase> findListByCaseNoAndParametersNo(String caseNo,String parametersNo);

    List<TestCase> findListbyProjectNo(String projectNo);

    List<TestCase> findListbyInterfaceNo(String interfaceNo);
}
