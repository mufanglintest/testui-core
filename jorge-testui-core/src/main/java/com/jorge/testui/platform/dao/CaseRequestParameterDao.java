/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-07-31
 */
 package com.jorge.testui.platform.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.platform.entity.CaseRequestParameter;
import org.apache.ibatis.annotations.Delete;

/**
 * case_request_parameter Mybatis Dao
 *
 * Date: 2019-07-31 18:31:50
 * @author mufanglin
 */
public interface CaseRequestParameterDao extends EntityMybatisDao<CaseRequestParameter> {

    @Delete("delete from case_request_parameter")
    void deleteCaseRequestParameterAll();
}
