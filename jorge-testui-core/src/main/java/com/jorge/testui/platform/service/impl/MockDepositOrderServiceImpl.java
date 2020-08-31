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
import com.jorge.testui.platform.service.MockDepositOrderService;
import com.jorge.testui.platform.dao.MockDepositOrderDao;
import com.jorge.testui.platform.entity.MockDepositOrder;

import java.util.List;

/**
 * 充值交易订单表 Service实现
 *
 * @author mufanglin
 * @date 2019-12-30 15:24:40
 */
@Service("mockDepositOrderService")
public class MockDepositOrderServiceImpl extends EntityServiceImpl<MockDepositOrder, MockDepositOrderDao> implements MockDepositOrderService {
	
	@Autowired
	private MockDepositOrderService mockDepositOrderService;
	
	/**
	 * 根据订单号查询mock充值订单流水
	 */
	@Override
	public MockDepositOrder findEntityByBizOrderNo(String bizOrderNo) {
		return this.getEntityDao().findEntityByBizOrderNo(bizOrderNo);
	}
	@Override
	public List<MockDepositOrder> findEntityByBizOrderNoAndNotifyStatus(String bizOrderNo) {
		return this.getEntityDao().findEntityByBizOrderNoAndNotifyStatus(bizOrderNo);
	}
	
	/**
	 * 查询mock充值订单流水
	 */
	@Override
	public List<MockDepositOrder> findEntityByMockDepositOrderAll() {
		return this.getEntityDao().findEntityByMockDepositOrderAll();
	}
	
	/**
	 * 根据来源查询当前最近半小时充值流水
	 *
	 */
	@Override
	public List<MockDepositOrder> findEntityByMockDepositOrderByTypeSource(String typeSource) {
		return this.getEntityDao().findEntityByMockDepositOrderByTypeSource(typeSource);
	}
	
	
	/**
	 * 查询mock 小程序订单流水
	 */
	@Override
	public List<MockDepositOrder> findEntityByMockDepositOrderWechatWebPayAll() {
		return this.getEntityDao().findEntityByMockDepositOrderWechatWebPayAll();
	}
	
	/**
	 * 初始化mock充值订单数据
	 */
	@Override
	public void saveMockDepositOrder(MockDepositOrder mockDepositOrderDO) {
//		this.getEntityDao().saveMockDepositOrder(Ids.oid(new Date().toString()),mockDepositOrderDO.getMockStatus(),mockDepositOrderDO.getBizOrderNo(),mockDepositOrderDO.getAmount(),mockDepositOrderDO.getMchId(),
//				mockDepositOrderDO.getTrade_date(),mockDepositOrderDO.getTrade_time(),mockDepositOrderDO.getInstalments(),mockDepositOrderDO.getGoodsMemo(),mockDepositOrderDO.getJumpUrl(),
//				mockDepositOrderDO.getNotifyUrl(),mockDepositOrderDO.getTrxCode(),mockDepositOrderDO.getPayAccountName(),mockDepositOrderDO.getUserPass(),mockDepositOrderDO.getLevel(),
//				mockDepositOrderDO.getDataType(),mockDepositOrderDO.getVersion(),mockDepositOrderDO.getMerchantId(),mockDepositOrderDO.getBusinessCode(),mockDepositOrderDO.getBusinessTime(),
//				mockDepositOrderDO.getPayUserName(),mockDepositOrderDO.getPayBankAccount(),mockDepositOrderDO.getPayBankType(),mockDepositOrderDO.getPayBankCode(),mockDepositOrderDO.getPayBankCurrency(),
//				mockDepositOrderDO.getPayUserMobile(),mockDepositOrderDO.getCustUserid(),mockDepositOrderDO.getMockNotifyStatus(),mockDepositOrderDO.getAppId(),mockDepositOrderDO.getRandomStr(),
//				mockDepositOrderDO.getPayEndIp(),mockDepositOrderDO.getPayType(),mockDepositOrderDO.getPayUserId(),mockDepositOrderDO.getSign(),mockDepositOrderDO.getTypeSource());
		mockDepositOrderService.save(mockDepositOrderDO);
	}
	
	/**
	 * 更新mock充值订单数据
	 */
	@Override
	public void updateMockDepositOrderByBizOrderNo(MockDepositOrder mockDepositOrderDO) {
		this.getEntityDao().updateMockNotifyStatusByBizOrderNo(mockDepositOrderDO.getBizOrderNo(), mockDepositOrderDO.getMockNotifyStatus(), mockDepositOrderDO.getMockNotifyCount(),
				mockDepositOrderDO.getSucAmount(), mockDepositOrderDO.getMockStatus());
	}
	
	/**
	 * 更新mock充值订单数据
	 */
	@Override
	public void updateMockDepositOrderByBizOrderNo(String bizOrderNo,String mockNotifyStatus,Integer mockNotifyCount,String mockStatus) {
		this.getEntityDao().updateMockNotifyStatusBizStatusByBizOrderNo(bizOrderNo, mockNotifyStatus, mockNotifyCount, mockStatus);
	}
	
	/**
	 * 更新mock充值订单数据
	 */
	@Override
	public void updateMockDepositOrder(MockDepositOrder mockDepositOrderDO) {
		mockDepositOrderService.update(mockDepositOrderDO);
	}
	
	@Override
	public MockDepositOrder findEntityByBizOrderNoAndMockStatus(String bizOrderNo) {
		return this.getEntityDao().findEntityByBizOrderNoAndMockStatus(bizOrderNo);
	}
	
	
}
