/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-07-16
 */
package com.jorge.testui.platform.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.platform.entity.TestCase;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * test_case Mybatis Dao
 * <p>
 * Date: 2019-07-16 16:08:56
 *
 * @author mufanglin
 */
public interface TestCaseDao extends EntityMybatisDao<TestCase> {

    /**
     * 根据项目编码和用例编码获取用例
     * @param caseNo
     * @param projectNo
     * @return
     */
    @Select("select * from test_case where case_no =#{caseNo} and project_no=#{projectNo}")
    TestCase findByCaseNoAndProjectNo(@Param("caseNo")String caseNo, @Param("projectNo")String projectNo);

    @Select("select * from test_case where case_no =#{caseNo}")
    TestCase findByCaseNo(@Param("caseNo")String caseNo);

    /**
     * 根据用例编码查询出所有的入参列表
     * @param caseNo
     * @return
     */
    @Select("select t.id,t.case_no,t.case_type,t.case_name,t.url,t.project_no,t.interface_no,t.protocol_type,t.call_count,t.create_time,t.update_time ,p.parameters_no as parametersNo,p.parameters as input\n" +
            "from test_case t left join parameters p on t.case_no = p.case_no where t.case_no = #{caseNo}")
    List<TestCase> findListByCaseNo(@Param("caseNo")String caseNo);

    /**
     * 根据用例编码和入参编码查询出入参列表
     * @param caseNo
     * @param parametersNo
     * @return
     */
    @Select("select t.id, t.case_no,t.case_type,t.case_name,t.url,t.project_no,t.interface_no,t.protocol_type,t.call_count,t.create_time,t.update_time ,p.parameters_no as parametersNo,p.parameters as input\n" +
            "from test_case t left join parameters p on t.case_no = p.case_no where t.case_no = #{caseNo} and p.parameters_no =#{parametersNo}")
    List<TestCase> findListByCaseNoAndParametersNo(@Param("caseNo")String caseNo,@Param("parametersNo")String parametersNo);

    @Select("select t.id, t.case_no,t.case_type,t.case_name,t.url,t.project_no,t.interface_no,t.protocol_type,t.call_count,t.create_time,t.update_time ,p.parameters_no as parametersNo,p.parameters as input\n" +
            "from test_case t left join parameters p on t.case_no = p.case_no where t.project_no = #{projectNo}")
    List<TestCase> findListByProjectNo(@Param("projectNo")String projectNo);

    @Select("select t.id, t.case_no,t.case_type,t.case_name,t.url,t.project_no,t.interface_no,t.protocol_type,t.call_count,t.create_time,t.update_time ,p.parameters_no as parametersNo,p.parameters as input\n" +
            "from test_case t left join parameters p on t.case_no = p.case_no where t.interface_no = #{interfaceNo}")
    List<TestCase> findListByInterfaceNo(@Param("interfaceNo")String interfaceNo);
}
