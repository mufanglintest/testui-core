/*
* mufl.com Inc.
* Copyright (c) 2020 All Rights Reserved.
* create by mufanglin
* date:2020-07-02
*/
package com.jorge.testui.platform.entity;


import com.acooly.core.common.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 用例执行批次表 Entity
 *
 * @author mufanglin
 * @date 2020-07-02 17:05:42
 */
@Entity
@Table(name = "batch_invoke")
@Getter
@Setter
public class BatchInvoke extends AbstractEntity {

    /**
     * 批次号
     */
	@NotNull
    private String batchNo;

    /**
     * 总执行用例数
     */
	@NotNull
    private Integer totalCase;

    /**
     * 成功用例数
     */
	@NotNull
    private Integer successCase;

    /**
     * 失败用例数
     */
	@NotNull
    private Integer failCase;

    /**
     * 总执行时间
     */
	@NotNull
    private Integer totalTime;

}
