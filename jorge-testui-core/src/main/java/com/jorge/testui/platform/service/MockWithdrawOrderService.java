/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-30
 *
 */
package com.jorge.testui.platform.service;

import com.acooly.core.common.service.EntityService;
import com.jorge.testui.platform.entity.MockWithdrawOrder;

/**
 * 提现交易订单表 Service接口
 *
 * @author mufanglin
 * @date 2019-12-30 15:24:40
 */
public interface MockWithdrawOrderService extends EntityService<MockWithdrawOrder> {
	/**
	 * 根据提现流水号查找提现流水
	 *
	 */
	MockWithdrawOrder findEntityByBizOrderNo(String bizOrderNo);
	
	/**
	 * 根据提现流水号查找提现流水
	 *
	 */
	MockWithdrawOrder findEntityByBizOrderNoAndTypeSource(String bizOrderNo, String typeSource);
	
	/**
	 * 初始化mock订单数据
	 *
	 */
	void saveMockWithdrawOrder(String mockOrderNo, long amount, String recAccountNo, String recBankName, String recAccountName, String mockStatus, String bizOrderNo, String recBankLasalle,
	                           String recCity, String recProvince);
	
	
	/**
	 * 初始化mock订单数据
	 *
	 */
	void saveMockWithdrawOrder(MockWithdrawOrder mockWithdrawOrderDO);
	
	/**
	 * 更新mock订单数据
	 *
	 */
	void updateMockWithdrawOrderByBizOrderNo(String mockNotifyStatus, String bizOrderNo, Integer mockNotifyCount, String mockStatus, long sucAmount);
	
	/**
	 * 更新mock充值订单数据
	 */
	public void updateMockWithdrawOrder(MockWithdrawOrder mockWithdrawOrder);
	
	MockWithdrawOrder findEntityByBizOrderNoAndStatus(String bizOrderNo);

}
