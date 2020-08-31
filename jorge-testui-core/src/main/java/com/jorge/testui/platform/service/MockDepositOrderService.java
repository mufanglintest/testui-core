/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-30
 *
 */
package com.jorge.testui.platform.service;

import com.acooly.core.common.service.EntityService;
import com.jorge.testui.platform.entity.MockDepositOrder;

import java.util.List;

/**
 * 充值交易订单表 Service接口
 *
 * @author mufanglin
 * @date 2019-12-30 15:24:40
 */
public interface MockDepositOrderService extends EntityService<MockDepositOrder> {
	/**
	 * 根据提现流水号查找提现流水
	 *
	 */
	MockDepositOrder findEntityByBizOrderNo(String bizOrderNo);
	
	/**
	 * 根据提现流水号查找提现流水
	 *
	 */
	List<MockDepositOrder> findEntityByBizOrderNoAndNotifyStatus(String bizOrderNo);
	
	/**
	 * 查询当前所有充值流水
	 *
	 */
	List<MockDepositOrder> findEntityByMockDepositOrderAll();
	
	/**
	 * 根据来源查询当前最近半小时充值流水
	 *
	 */
	List<MockDepositOrder> findEntityByMockDepositOrderByTypeSource(String typeSource);
	
	/**
	 * 查询当前所有小程序未通知流水
	 *
	 */
	List<MockDepositOrder> findEntityByMockDepositOrderWechatWebPayAll();
	
	/**
	 * 初始化mock订单数据
	 *
	 */
	void saveMockDepositOrder(MockDepositOrder mockDepositOrderDO);
	
	/**
	 * 更新mock充值订单数据
	 *
	 */
	void updateMockDepositOrderByBizOrderNo(MockDepositOrder mockDepositOrderDO);
	
	/**
	 * 更新mock充值订单数据
	 *
	 */
	void updateMockDepositOrderByBizOrderNo(String bizOrderNo, String mockNotifyStatus, Integer mockNotifyCount, String mockStatus);
	
	public void updateMockDepositOrder(MockDepositOrder mockDepositOrderDO) ;
	
	/**
	 * 根据提现流水号查找提现流水
	 *
	 */
	MockDepositOrder findEntityByBizOrderNoAndMockStatus(String bizOrderNo);

}
