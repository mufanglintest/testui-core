/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-29
*/
package com.jorge.testui.platform.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import com.acooly.core.common.domain.AbstractEntity;

/**
 * execute_log Entity
 *
 * @author mufanglin
 * Date: 2019-11-29 18:06:13
 */
@Entity
@Table(name = "execute_log")
@Getter
@Setter
public class ExecuteLog extends AbstractEntity {

    /**
     * project_no
     */
	@Size(max = 64)
    private String projectNo;

    /**
     * interface_no
     */
	@Size(max = 64)
    private String interfaceNo;

    /**
     * case_no
     */
	@Size(max = 64)
    private String caseNo;

    /**
     * parameter_no
     */
	@Size(max = 64)
    private String parameterNo;

    /**
     * parameters
     */
	@Size(max = 100000)
    private String parameters;

}
