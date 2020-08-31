/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-07-16
 */
package com.jorge.testui.platform.service.impl;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.platform.dao.TestCaseDao;
import com.jorge.testui.platform.entity.TestCase;
import com.jorge.testui.platform.service.TestCaseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * test_case Service实现
 * <p>
 * Date: 2019-07-16 16:08:56
 *
 * @author mufanglin
 */
@Service("testCaseService")
public class TestCaseServiceImpl extends EntityServiceImpl<TestCase, TestCaseDao> implements TestCaseService {

    @Override
    public TestCase findByCaseNo(String caseNo) {
        return this.getEntityDao().findByCaseNo(caseNo);
    }

    @Override
    public TestCase findTestCase(String key, Object value) {
        Map<String, Object> map=new HashMap<>();
        map.put(key,value);
        Map<String, Boolean> sortMap = new HashMap<>();

        this.query(map,sortMap);
        this.getEntityDao().find("key",value);
        return null;
    }

    @Override
    public TestCase findByCaseNoAndProjectNo(String caseNo, String projectNo) {
        return this.getEntityDao().findByCaseNoAndProjectNo(caseNo, projectNo);
    }

    @Override
    public List<TestCase> findListByCaseNo(String caseNo) {
        return this.getEntityDao().findListByCaseNo(caseNo);
    }

    @Override
    public List<TestCase> findListByCaseNoAndParametersNo(String caseNo, String parametersNo) {
        return this.getEntityDao().findListByCaseNoAndParametersNo(caseNo, parametersNo);
    }

    @Override
    public List<TestCase> findListbyProjectNo(String projectNo) {
        return this.getEntityDao().findListByProjectNo(projectNo);
    }

    @Override
    public List<TestCase> findListbyInterfaceNo(String interfaceNo) {
        return this.getEntityDao().findListByInterfaceNo(interfaceNo);
    }
}
