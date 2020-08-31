/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-07-31
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

/**
 * case_request_parameter Entity
 *
 * @author mufanglin
 * Date: 2019-07-31 18:31:50
 */
@Entity
@Table(name = "case_request_parameter")
@Getter
@Setter
public class CaseRequestParameter extends AbstractEntity {

    /**
     * 用例编码
     */
	@NotEmpty
	@Size(max = 64)
    private String caseNo;

    /**
     * 用例请求参数模板
     */
	@Size(max = 5120)
    private String requestDemo;

}
