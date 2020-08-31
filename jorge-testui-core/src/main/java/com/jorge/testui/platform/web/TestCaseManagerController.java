/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-07-16
*/
package com.jorge.testui.platform.web;

import com.acooly.core.common.web.AbstractJQueryEntityController;
import com.acooly.core.common.web.support.JsonResult;
import com.acooly.core.utils.Servlets;
import com.acooly.module.security.domain.User;
import com.acooly.module.security.service.UserService;
import com.jorge.testui.platform.entity.Interface;
import com.jorge.testui.platform.entity.Parameters;
import com.jorge.testui.platform.entity.Project;
import com.jorge.testui.platform.entity.TestCase;
import com.jorge.testui.platform.enums.CaseTypeEnum;
import com.jorge.testui.platform.enums.ProtocolTypeEnum;
import com.jorge.testui.platform.service.InterfaceService;
import com.jorge.testui.platform.service.ParametersService;
import com.jorge.testui.platform.service.ProjectService;
import com.jorge.testui.platform.service.TestCaseService;
import com.jorge.testui.shop.dao.ShopDao;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * test_case 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-07-16 16:08:56
 */
@Controller
@RequestMapping(value = "/manage/jorge/testCase")
public class TestCaseManagerController extends AbstractJQueryEntityController<TestCase, TestCaseService> {
	

	{
		allowMapping = "*";
	}
	@Autowired
	private ProjectService projectService;

	@Autowired
	private InterfaceService interfaceService;

	@SuppressWarnings("unused")
	@Autowired
	private TestCaseService testCaseService;

	@Autowired
	private UserService userService;
	@Autowired
	private ParametersService parametersService;

//	@Autowired
//	private ShopDao shopDao;

	
	@Override
	protected void referenceData(HttpServletRequest request, Map<String, Object> model) {
		List<Project> projects = projectService.getAll();
		Map<String, String> allProjects = projects.stream().collect(Collectors.toMap(Project::getProjectNo, Project::getProjectName));
		model.put("allProjectNos", allProjects);
		List<Interface> interfaces = interfaceService.getAll();
		Map<String, String> allInterfaces = interfaces.stream().collect(Collectors.toMap(Interface::getInterfaceNo, Interface::getInterfaceName));
		model.put("allInterfaceNos", allInterfaces);
		model.put("allCaseTypes", CaseTypeEnum.mapping());
		model.put("allProtocolTypes", ProtocolTypeEnum.mapping());
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		model.put("createUser",user.getRealName());
		List<User> ceateUsers= userService.getAll();
		model.put("allCreateUsers", ceateUsers);
//		shopDao.querySql("SELECT * FROM shop_cus_receiver");
	}

	@RequestMapping(value = {"relaodInterfaceNos"})
	@ResponseBody
	protected JsonResult relaodInterfaceNos(HttpServletRequest request, Map<String, Object> model){
		JsonResult result = new JsonResult();
		String projectNo = Servlets.getParameter("projectNo");
		List<Interface> interfaces = interfaceService.findListInterfaceByProjectNo(projectNo);
		Map<Object, Object> allInterfaces = interfaces.stream().collect(Collectors.toMap(Interface::getInterfaceNo, Interface::getInterfaceName));
		result.setData(allInterfaces);
		result.setSuccess(true);
		result.setMessage("成功");
		result.setCode("success");
		return result;
	}

	@Override
	protected void onRemove(HttpServletRequest request, HttpServletResponse response, Model model, Serializable... ids) throws Exception {
		if (ids == null || ids.length == 0) {
			throw new IllegalArgumentException("请求参数中没有指定需要删除的实体Id");
		}
		for (Serializable id:ids) {
			TestCase testCase = getEntityService().get(id);
			parametersService.deleteParametersByCaseNo(testCase.getCaseNo());
		}
	}
}
