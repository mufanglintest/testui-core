
package com.jorge.testui.platform.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.platform.entity.Parameters;
import com.jorge.testui.system.dto.ParameterStatusDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用例入参表 Mybatis Dao
 * <p>
 * Date: 2019-07-23 15:29:31
 *
 * @author mufanglin
 */
public interface ParametersDao extends EntityMybatisDao<Parameters> {

    /**
     * 根据用例编号和参数编号查询参数
     * @param caseNo
     * @param parametersNo
     * @return
     */
    @Select("select * from parameters where case_no =#{caseNo} and parameters_no=#{parametersNo}")
    Parameters findParametersByCaseNoAndParametersNo(@Param("caseNo") String caseNo, @Param("parametersNo") String parametersNo);

    /**
     * 根据用例编号查询参数
     * @param caseNo
     * @return
     */
    @Select("select * from parameters where case_no =#{caseNo}")
    List<Parameters> findListParametersByCaseNo(@Param("caseNo")String caseNo);

    /**
     * 统计执行相应结果用例数量
     * @param lastImplementResult
     * @return
     */
    @Select("select count(id) from parameters p where p.last_implement_result = #{lastImplementResult}")
    int countParametersByLastImplementResult(@Param("lastImplementResult") Boolean lastImplementResult);

    @Select("SELECT\n" +
            "\tp1.project_no,\n" +
            "\tp1.successCount,\n" +
            "\tp1.failCount,\n" +
            "\tp3.totalTestCaseCount,\n" +
            "\ti1.interfaceCount \n" +
            "FROM\n" +
            "\t(\n" +
            "SELECT\n" +
            "\tt.project_no,\n" +
            "\tsum( CASE t.last_implement_result WHEN 0 THEN t.sum ELSE 0 END ) AS failCount,\n" +
            "\tsum( CASE t.last_implement_result WHEN 1 THEN t.sum ELSE 0 END ) AS successCount \n" +
            "FROM\n" +
            "\t( SELECT p.project_no, count( id ) AS sum, p.last_implement_result FROM parameters p GROUP BY project_no, last_implement_result ) AS t \n" +
            "GROUP BY\n" +
            "\tt.project_no \n" +
            "\t) p1,\n" +
            "\t( SELECT p2.project_no, count( p2.case_no ) AS totalTestCaseCount FROM parameters p2 GROUP BY p2.project_no ) p3,\n" +
            "\t( SELECT project_no, count( interface_no ) AS interfaceCount FROM interface i GROUP BY i.project_no ) i1 \n" +
            "WHERE\n" +
            "\tp1.project_no = p3.project_no \n" +
            "\tAND p1.project_no = i1.project_no")
    List<ParameterStatusDto> countParameterStatus();

    @Delete("delete from parameters where case_no=#{caseNo}")
    void deleteParametersByCaseNo(@Param("caseNo") String caseNo);
}
