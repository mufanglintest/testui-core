/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-07-16
*/
package com.jorge.testui.platform.entity;


import com.acooly.core.common.domain.AbstractEntity;
import com.jorge.testui.platform.enums.CaseTypeEnum;
import com.jorge.testui.platform.enums.ProtocolTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * test_case Entity
 *
 * @author mufanglin
 * Date: 2019-07-16 16:08:56
 */
@Entity
@Table(name = "test_case")
@Getter
@Setter
public class TestCase extends AbstractEntity {

    /**
     * 用例编号
     */
	@NotEmpty
	@Size(max = 64)
    private String caseNo;

    /**
     * 用例名称
     */
	@NotEmpty
	@Size(max = 32)
    private String caseName;

    /**
     * 用例类别
     */
    @Enumerated(EnumType.STRING)
	@NotNull
    private CaseTypeEnum caseType;

    /**
     * 请求地址
     */
	@Size(max = 128)
    private String url;

    /**
     * 请求参数
     */
	@Size(max = 1024)
    private String input;

    /**
     * 协议类型
     */
    @Enumerated(EnumType.STRING)
	@NotNull
    private ProtocolTypeEnum protocolType;


	@NotEmpty
    @Size(max = 64)
	private String projectNo;


	@NotEmpty
    @Size(max = 64)
	private String interfaceNo;

    @Size(max = 64)
    private String createUser;

	@Transient
	private String parametersNo;

}
