/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-07-16
 */
package com.jorge.testui.platform.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.platform.entity.Project;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * project Mybatis Dao
 * <p>
 * Date: 2019-07-16 16:08:56
 *
 * @author mufanglin
 */
public interface ProjectDao extends EntityMybatisDao<Project> {

    @Select("select * from project where project_no=#{projectNo}")
    List<Project> findListProjectByProjectNo(@Param("projectNo") String projectNo);

}
