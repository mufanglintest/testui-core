/*
* mufl.com Inc.
* Copyright (c) 2020 All Rights Reserved.
* create by mufanglin
* date:2020-06-09
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
 * 订单表 Entity
 *
 * @author mufanglin
 * @date 2020-06-09 15:46:22
 */
@Entity
@Table(name = "mock_order_info")
@Getter
@Setter
public class MockOrderInfo extends AbstractEntity {

    /**
     * mock业务流水号
     */
	@Size(max = 96)
    private String mockOrderNo;

    /**
     * 业务层通知mock订单号
     */
	@Size(max = 96)
    private String bizOrderNo;

    /**
     * 充值金额
     */
    private Long amount;

    /**
     * 订单号信息
     */
	@Size(max = 96)
    private String orderinfo;

}
