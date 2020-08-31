/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-30
 */
package com.jorge.testui.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.platform.service.MockWithdrawOrderService;
import com.jorge.testui.platform.dao.MockWithdrawOrderDao;
import com.jorge.testui.platform.entity.MockWithdrawOrder;

/**
 * 提现交易订单表 Service实现
 *
 * @author mufanglin
 * @date 2019-12-30 15:24:40
 */
@Service("mockWithdrawOrderService")
public class MockWithdrawOrderServiceImpl extends EntityServiceImpl<MockWithdrawOrder, MockWithdrawOrderDao> implements MockWithdrawOrderService {
	
	@Autowired
	private MockWithdrawOrderService mockWithdrawOrderService;
	
	/**
	 * 根据订单号查询mock提现订单流水
	 */
	@Override
	public MockWithdrawOrder findEntityByBizOrderNo(String bizOrderNo) {
		return this.getEntityDao().findEntityByBizOrderNo(bizOrderNo);
	}
	
	@Override
	public MockWithdrawOrder findEntityByBizOrderNoAndTypeSource(String bizOrderNo, String typeSource) {
		return this.getEntityDao().findEntityByBizOrderNoAndTypeSource(bizOrderNo, typeSource);
	}
	
	/**
	 * 初始化mock订单数据
	 */
	@Override
	public void saveMockWithdrawOrder(String mockOrderNo,long amount,String recAccountNo,String recBankName,String recAccountName,String mockStatus,String bizOrderNo,
	                                  String recBankLasalle,String recCity,String recProvince) {
		this.getEntityDao().saveMockWithdrawOrder(mockOrderNo,amount,recAccountNo,recBankName,recAccountName,mockStatus,bizOrderNo,recBankLasalle,recCity, recProvince);
	}
	
	/**
	 * 初始化mock订单数据
	 */
	@Override
	public void saveMockWithdrawOrder(MockWithdrawOrder mockWithdrawOrderDO) {
		mockWithdrawOrderService.save(mockWithdrawOrderDO);
	}
	
	/**
	 * 更新mock订单数据
	 */
	@Override
	public void updateMockWithdrawOrderByBizOrderNo(String bizOrderNo,String mockNotifyStatus,Integer mockNotifyCount,String mockStatus,long sucAmount) {
		this.getEntityDao().updateMockNotifyStatusByBizOrderNo(bizOrderNo,mockNotifyStatus,mockNotifyCount,mockStatus,sucAmount);
	}
	
	/**
	 * 更新mock充值订单数据
	 */
	@Override
	public void updateMockWithdrawOrder(MockWithdrawOrder mockWithdrawOrder) {
		mockWithdrawOrderService.update(mockWithdrawOrder);
	}
	
	@Override
	public MockWithdrawOrder findEntityByBizOrderNoAndStatus(String bizOrderNo) {
		return this.getEntityDao().findEntityByBizOrderNo(bizOrderNo);
	}
	
}
