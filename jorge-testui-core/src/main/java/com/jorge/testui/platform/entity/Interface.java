/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-07-16
*/
package com.jorge.testui.platform.entity;


import com.acooly.core.common.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * interface Entity
 *
 * @author mufanglin
 * Date: 2019-07-16 16:08:56
 */
@Entity
@Table(name = "interface")
@Getter
@Setter
public class Interface extends AbstractEntity {

    /**
     * 接口编号
     */
	@NotEmpty
	@Size(max = 64)
    private String interfaceNo;

    /**
     * 接口名称
     */
	@NotEmpty
	@Size(max = 32)
    private String interfaceName;

    /**
     * 所属项目编号
     */
	@NotEmpty
	@Size(max = 64)
    private String projectNo;

}
