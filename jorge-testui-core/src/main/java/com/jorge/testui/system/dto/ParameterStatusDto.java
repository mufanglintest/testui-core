package com.jorge.testui.system.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-04-07 22:37
 */
@Slf4j
@Getter
@Setter
public class ParameterStatusDto {
    /**
     * 项目编号
     */
    private String projectNo ;
    /**
     * 接口数量
     */
    private int interfaceCount;
    /**
     * 项目总用例数
     */
    private int totalTestCaseCount;
    /**
     * 项目执行成功用例数
     */
    private int successCount;
    /**
     * 项目执行失败用例数
     */
    private int failCount;

}
