/*
* mufl.com Inc.
* Copyright (c) 2020 All Rights Reserved.
* create by mufanglin
* date:2020-07-02
*/
package com.jorge.testui.platform.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acooly.core.common.web.AbstractJsonEntityController;
import com.jorge.testui.platform.entity.BatchInvoke;
import com.jorge.testui.platform.service.BatchInvokeService;

import com.google.common.collect.Maps;

/**
 * 用例执行批次表 管理控制器
 * 
 * @author mufanglin
 * @date 2020-07-02 17:05:42
 */
@Controller
@RequestMapping(value = "/manage/jorge/batchInvoke")
public class BatchInvokeManagerController extends AbstractJsonEntityController<BatchInvoke, BatchInvokeService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private BatchInvokeService batchInvokeService;

	

}
