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
import com.jorge.testui.platform.service.MockSignInfoService;
import com.jorge.testui.platform.dao.MockSignInfoDao;
import com.jorge.testui.platform.entity.MockSignInfo;

import java.util.List;

/**
 * mock_sign_info Service实现
 *
 * @author mufanglin
 * @date 2019-12-30 15:24:40
 */
@Service("mockSignInfoService")
public class MockSignInfoServiceImpl extends EntityServiceImpl<MockSignInfo, MockSignInfoDao> implements MockSignInfoService {
	
	@Autowired
	private MockSignInfoService mockSignInfoOrderService;
	
	/**
	 * 初始化mock签约订单数据
	 */
	@Override
	public void saveMockSignInfoOrder(MockSignInfo mockSignInfoOrderDO) {
		mockSignInfoOrderService.save(mockSignInfoOrderDO);
	}
	
	/**
	 * 更新mock签约订单数据
	 */
	@Override
	public void updateMockSignInfoOrder(MockSignInfo mockSignInfoOrderDO) {
		this.getEntityDao().updateMockSignInfoOrderMockStatusByBizOrderNo(
				mockSignInfoOrderDO.getBizOrderNo(), mockSignInfoOrderDO.getMockStatus());
	}
	
	/**
	 * 查询mock签约订单数据，并返回最后一条
	 */
	@Override
	public List<MockSignInfo> findEntityByMockSignInfoOrderSignAll() {
		return this.getEntityDao().findEntityByMockSignInfoOrderSignAll();
	}
	
	/**
	 * 更新mock签约订单数据
	 */
	@Override
	public void updateMockNotifyStatusBizStatusByMockOrderNo(MockSignInfo mockSignInfoOrderDO) {
		this.getEntityDao().updateMockNotifyStatusBizStatusByMockOrderNo(
				mockSignInfoOrderDO.getMockOrderNo(), mockSignInfoOrderDO.getMockNotifyStatus(),
				mockSignInfoOrderDO.getMockNotifyCount(), mockSignInfoOrderDO.getMockStatus());
	}
	
}
