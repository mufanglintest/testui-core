/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-11-29
*/
package com.jorge.testui.platform.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acooly.core.common.web.AbstractJQueryEntityController;
import com.jorge.testui.platform.entity.ExecuteLog;
import com.jorge.testui.platform.service.ExecuteLogService;

import com.google.common.collect.Maps;

/**
 * execute_log 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-11-29 18:06:13
 */
@Controller
@RequestMapping(value = "/manage/jorge/executeLog")
public class ExecuteLogManagerController extends AbstractJQueryEntityController<ExecuteLog, ExecuteLogService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private ExecuteLogService executeLogService;

	

}
