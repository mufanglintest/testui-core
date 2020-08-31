/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-07-16
*/
package com.jorge.testui.platform.web;

import com.acooly.core.common.web.AbstractJQueryEntityController;
import com.jorge.testui.platform.entity.Project;
import com.jorge.testui.platform.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * project 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-07-16 16:08:56
 */
@Controller
@RequestMapping(value = "/manage/jorge/project")
public class ProjectManagerController extends AbstractJQueryEntityController<Project, ProjectService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private ProjectService projectService;

	

}
