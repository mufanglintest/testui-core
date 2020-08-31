/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-30
 *
 */
package com.jorge.testui.platform.service;

import com.acooly.core.common.service.EntityService;
import com.jorge.testui.platform.entity.MockSignInfo;

import java.util.List;

/**
 * mock_sign_info Service接口
 *
 * @author mufanglin
 * @date 2019-12-30 15:24:40
 */
public interface MockSignInfoService extends EntityService<MockSignInfo> {
	
	/**
	 * 初始化mock签约订单数据
	 *
	 */
	void saveMockSignInfoOrder(MockSignInfo mockSignInfoOrderDO);
	
	/**
	 * 更新mock签约订单数据
	 *
	 */
	void updateMockSignInfoOrder(MockSignInfo mockSignInfoOrderDO);
	
	/**
	 * 更新mock签约订单数据
	 * @return
	 *
	 */
	List<MockSignInfo> findEntityByMockSignInfoOrderSignAll();
	
	/**
	 * 更新mock签约订单数据
	 *
	 */
	void updateMockNotifyStatusBizStatusByMockOrderNo(MockSignInfo mockSignInfoOrderDO);
	
	
}
