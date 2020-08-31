/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-07-16
 */
package com.jorge.testui.platform.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.platform.entity.Interface;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * interface Mybatis Dao
 * <p>
 * Date: 2019-07-16 16:08:56
 *
 * @author mufanglin
 */
public interface InterfaceDao extends EntityMybatisDao<Interface> {

    @Select("select * from interface where project_no =#{projectNo}")
    List<Interface> findListInterfaceByProjectNo(@Param("projectNo") String projectNo);

}
