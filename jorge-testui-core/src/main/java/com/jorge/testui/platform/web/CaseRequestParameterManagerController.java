/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-07-31
*/
package com.jorge.testui.platform.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acooly.core.common.web.AbstractJQueryEntityController;
import com.jorge.testui.platform.entity.CaseRequestParameter;
import com.jorge.testui.platform.service.CaseRequestParameterService;

import com.google.common.collect.Maps;

/**
 * case_request_parameter 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-07-31 18:31:50
 */
@Controller
@RequestMapping(value = "/manage/jorge/caseRequestParameter")
public class CaseRequestParameterManagerController extends AbstractJQueryEntityController<CaseRequestParameter, CaseRequestParameterService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private CaseRequestParameterService caseRequestParameterService;

	

}
