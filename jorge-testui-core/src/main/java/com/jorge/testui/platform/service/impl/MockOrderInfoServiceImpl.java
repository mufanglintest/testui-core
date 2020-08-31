/*
 * mufl.com Inc.
 * Copyright (c) 2020 All Rights Reserved.
 * create by mufanglin
 * date:2020-06-09
 */
package com.jorge.testui.platform.service.impl;

import org.springframework.stereotype.Service;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.platform.service.MockOrderInfoService;
import com.jorge.testui.platform.dao.MockOrderInfoDao;
import com.jorge.testui.platform.entity.MockOrderInfo;

/**
 * 订单表 Service实现
 *
 * @author mufanglin
 * @date 2020-06-09 15:46:22
 */
@Service("mockOrderInfoService")
public class MockOrderInfoServiceImpl extends EntityServiceImpl<MockOrderInfo, MockOrderInfoDao> implements MockOrderInfoService {

}
