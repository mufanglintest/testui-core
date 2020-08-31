/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-07-23
*/
package com.jorge.testui.platform.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import com.acooly.core.common.domain.AbstractEntity;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * 用例入参表 Entity
 *
 * @author mufanglin
 * Date: 2019-07-23 15:29:31
 */
@Entity
@Table(name = "parameters")
@Getter
@Setter
public class Parameters extends AbstractEntity {

    /**
     * 系统编号
     */
	@NotEmpty
	@Size(max = 64)
    private String projectNo;

    /**
     * 接口编号
     */
	@NotEmpty
	@Size(max = 64)
    private String interfaceNo;

    /**
     * 测试用例编号
     */
	@NotEmpty
	@Size(max = 64)
    private String caseNo;

    /**
     * 请求入参编号
     */
	@NotEmpty
	@Size(max = 20)
    private String parametersNo;

    /**
     * 请求入参
     */
	@NotEmpty
    private String parameters;

    /**
     * 用例执行次数
     */
    @Max(999999999)
    private Integer callCount = 0;

    /**
     * 用例执行成功次数
     */
    @Max(999999999)
    private Integer callSuccessCount = 0;

    /**
     * 用例执行失败次数
     */
    @Max(999999999)
    private Integer callFailCount = 0;

    /**
     * 最后一次执行结果，0为失败，1为成功
     */
    private Boolean lastImplementResult = false;

    /**
     * 用例说明
     */
    private String description;


    /**
     * 用例创建者
     */
    private String createUser ;

}
