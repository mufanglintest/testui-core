/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-12-30
*/
package com.jorge.testui.platform.entity;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.alibaba.fastjson.JSON;
import com.jorge.testui.enums.PublicTag;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import com.acooly.core.common.domain.AbstractEntity;
import java.util.Date;

/**
 * 提现交易订单表 Entity
 *
 * @author mufanglin
 * @date 2019-12-30 15:24:40
 */
@Entity
@Table(name = "mock_withdraw_order")
@Getter
@Setter
public class MockWithdrawOrder extends AbstractEntity {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 业务通知mock订单号(如通知银行)
	 */
	private String bizOrderNo;
	
	/**
	 * mock流水号(如银行流水号)
	 */
	private String mockOrderNo;
	
	/**
	 * 提现金额
	 */
	private Long amount = 0l;
	
	/**
	 * 成功提现金额
	 */
	private Long sucAmount = 0l;
	
	/**
	 * 批次号
	 */
	private String batchNo;
	
	/**
	 * 用户ID
	 */
	private String userId;
	
	/**
	 * 收款银行ID
	 */
	private String recBankId;
	
	/**
	 * 收款行名称
	 */
	private String recBankName;
	
	/**
	 * 收款账号
	 */
	private String recAccountNo;
	
	/**
	 * 收款户名
	 */
	private String recAccountName;
	
	/**
	 * 收款行联行号
	 */
	private String recBankLasalle;
	
	/**
	 * 收款账号所在省份
	 */
	private String recProvince;
	
	/**
	 * 收款账号所在城市
	 */
	private String recCity;
	
	/**
	 * 付款用户所在银行的ID
	 */
	private String payBankId;
	
	/**
	 * 付款用户的银行卡号
	 */
	private String payAccountNo;
	
	/**
	 * 付款用户姓名
	 */
	private String payAccountName;
	
	/**
	 * 付款行名称
	 */
	private String payBankName;
	
	/**
	 * 对公对私标志
	 */
	@Enumerated(EnumType.STRING)
	private PublicTag publicTag;
	
	/**
	 * 银行卡类型 如：DEBIT_CARD借记卡, CREDIT_CARD 贷记卡
	 */
	private String bankCardType;
	
	/**
	 * 创建时间
	 */
	private Date createTime = new Date();
	
	/**
	 * 修改时间
	 */
	private Date updateTime = new Date();
	
	/**
	 * 备注(显示错误信息、备注等信息)
	 */
	@Size(max=2000)
	private String memo;
	
	/**
	 * 订单流水查询通知状态
	 */
	private String mockNotifyStatus;
	
	/**
	 * 订单流水处理通知次数
	 */
	private Integer mockNotifyCount = 0;
	
	/**
	 * 订单流水处理状态
	 */
	private String mockStatus;
	
	/**
	 * 交易来源
	 */
	private String typeSource;
	
	private String partnerId;
	private String payUserName;
	private String payBankCurrency;
	private String custUserid;
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
