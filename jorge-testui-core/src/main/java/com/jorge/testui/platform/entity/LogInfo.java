/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-12-04
*/
package com.jorge.testui.platform.entity;


import com.acooly.core.common.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * log_info Entity
 *
 * @author mufanglin
 * Date: 2019-12-04 11:37:18
 */
@Entity
@Table(name = "log_info")
@Getter
@Setter
public class LogInfo extends AbstractEntity {

    /**
     * 项目名
     */
	@Size(max = 64)
    private String projectNo;

    /**
     * 接口名
     */
	@Size(max = 64)
    private String interfaceNo;

    /**
     * 用例编号
     */
	@Size(max = 64)
    private String caseNo;

    /**
     * 用例执行参数编号
     */
	@Size(max = 64)
    private String parametersNo;

    /**
     * 请求接口参数
     */
	@Size(max = 1024)
    private String requestInfo;

    /**
     * 接口返回参数
     */
	@Size(max = 100000)
    private String resultInfo;

    /**
     * 用例说明
     */
	@Size(max = 64)
    private String memo;


	private Boolean exexuteStatus;

}
