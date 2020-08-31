/*
* mufl.com Inc.
* Copyright (c) 2020 All Rights Reserved.
* create by mufanglin
* date:2020-07-03
*/
package com.jorge.testui.platform.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import com.acooly.core.common.domain.AbstractEntity;
import java.util.Date;

/**
 * 批次执行结果数据 Entity
 *
 * @author mufanglin
 * @date 2020-07-03 17:12:38
 */
@Entity
@Table(name = "batch_invoke_result")
@Getter
@Setter
public class BatchInvokeResult extends AbstractEntity {

    /**
     * 批次号
     */
	@NotBlank
	@Size(max = 20)
    private String batchNo;

    /**
     * 用例编号
     */
	@NotBlank
	@Size(max = 64)
    private String caseNo;

    /**
     * 参数编号
     */
	@NotBlank
	@Size(max = 32)
    private String parameterNo;

    /**
     * 用例执行结果
     */
	@NotNull
    private Integer invokeStatus;

    /**
     * 用例请求入参
     */
	@NotBlank
	@Size(max = 999999999)
    private String parameterRequest;

    /**
     * 用例执行返回结果
     */
	@NotBlank
	@Size(max = 999999999)
    private String parameterResponse;

}
