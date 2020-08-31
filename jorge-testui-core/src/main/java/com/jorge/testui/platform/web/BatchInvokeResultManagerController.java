/*
* mufl.com Inc.
* Copyright (c) 2020 All Rights Reserved.
* create by mufanglin
* date:2020-07-03
*/
package com.jorge.testui.platform.web;

import com.acooly.core.common.web.AbstractJsonEntityController;
import com.jorge.testui.platform.entity.BatchInvokeResult;
import com.jorge.testui.platform.service.BatchInvokeResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 批次执行结果数据 管理控制器
 * 
 * @author mufanglin
 * @date 2020-07-03 17:12:38
 */
@Controller
@RequestMapping(value = "/manage/jorge/batchInvokeResult")
public class BatchInvokeResultManagerController extends AbstractJsonEntityController<BatchInvokeResult, BatchInvokeResultService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private BatchInvokeResultService batchInvokeResultService;

	@Override
	protected void referenceData(HttpServletRequest request, Map<String, Object> model) {
		Map<String,String> invokeStatusList = new HashMap<>();
		invokeStatusList.put("1","通过");
		invokeStatusList.put("0","未通过");
		model.put("invokeStatusList",invokeStatusList);
	}
}
