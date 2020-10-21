/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-07-23
*/
package com.jorge.testui.platform.web;

import com.acooly.core.common.boot.Apps;
import com.acooly.core.common.web.AbstractJQueryEntityController;
import com.acooly.core.common.web.support.JsonResult;
import com.acooly.core.utils.Ids;
import com.acooly.core.utils.Servlets;
import com.acooly.core.utils.StringUtils;
import com.acooly.module.event.EventBus;
import com.acooly.module.security.domain.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.esotericsoftware.minlog.Log;
import com.jorge.testui.event.BatchInvokeTestCaseEvent;
import com.jorge.testui.platform.entity.Interface;
import com.jorge.testui.platform.entity.Parameters;
import com.jorge.testui.platform.entity.Project;
import com.jorge.testui.platform.entity.TestCase;
import com.jorge.testui.platform.service.InterfaceService;
import com.jorge.testui.platform.service.ParametersService;
import com.jorge.testui.platform.service.ProjectService;
import com.jorge.testui.platform.service.TestCaseService;
import com.jorge.testui.utils.ClassUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 用例入参表 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-07-23 15:29:31
 */
@Slf4j
@Controller
@RequestMapping(value = "/manage/jorge/parameters")
public class ParametersManagerController extends AbstractJQueryEntityController<Parameters, ParametersService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private ParametersService parametersService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private InterfaceService interfaceService;

	@Autowired
	private TestCaseService testCaseService;
	@Autowired
	EventBus eventBus;

    @Override
    protected void onCreate(HttpServletRequest request, HttpServletResponse response, Model model) {
        super.onCreate(request, response, model);

    }

    @Override
	protected void referenceData(HttpServletRequest request, Map<String, Object> model) {
    	Map<String,String> implementResult = new HashMap<>();
    	implementResult.put("true","通过");
    	implementResult.put("false","未通过");
    	model.put("implementResult",implementResult);

		List<Project> projects = projectService.getAll();
		Map<String, String> allProjects = projects.stream().collect(Collectors.toMap(Project::getProjectNo, Project::getProjectName));
		model.put("allProjectNos", allProjects);
		List<Interface> interfaces = interfaceService.getAll();
		Map<String, String> allInterfaces = interfaces.stream().collect(Collectors.toMap(Interface::getInterfaceNo, Interface::getInterfaceName));
		model.put("allInterfaceNos", allInterfaces);
		List<TestCase> testCases =testCaseService.getAll();
		Map<String, String> allTestCases = testCases.stream().collect(Collectors.toMap(TestCase::getCaseNo, TestCase::getCaseName));
		model.put("allTestCaseNos", allTestCases);
		model.put("projectNo", Servlets.getParameter("projectNo"));
		model.put("interfaceNo",Servlets.getParameter("interfaceNo"));
		model.put("caseNo",Servlets.getParameter("caseNo"));
		model.put("lastImplementResultKey",Servlets.getParameter("lastImplementResultKey"));
		model.put("lastImplementResultValue",Servlets.getParameter("lastImplementResultValue"));
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		model.put("createUser",user.getRealName());

	}

	@RequestMapping(value = {"copy"})
	@ResponseBody
	protected JsonResult copy(HttpServletRequest request, Map<String, Object> model){
		JsonResult result = new JsonResult();
		User user = getSessionUser();
		String caseNo = Servlets.getParameter("caseNo");
		String parametersNo = Servlets.getParameter("parametersNo");
		String copyType = Servlets.getParameter("copyType");
		Map<Object, Object> datas = new HashMap<>();
		try {
			switch (copyType){
				case "parameter":
					Parameters parameter= parametersService.findParametersByCaseNoAndParametersNo(caseNo,parametersNo);
					parameter.setId(null);
					parameter.setCallCount(0);
					parameter.setCallFailCount(0);
					parameter.setCallSuccessCount(0);
					parameter.setLastImplementResult(false);
					parameter.setParametersNo(Ids.Did.getInstance().getId(20));
					parameter.setCreateUser(getSessionUser().getRealName());
					parametersService.save(parameter);
					log.info("复制用例成功！");
					break;
				case "testcase" :
					TestCase testCase = testCaseService.findByCaseNo(caseNo);
					testCase.setId(null);
					testCase.setCaseNo(Ids.oid());
					testCaseService.save(testCase);

					List<Parameters> parameters = parametersService.findListParametersByCaseNo(caseNo);
					for (Parameters p : parameters){
						p.setId(null);
						p.setCaseNo(testCase.getCaseNo());
						p.setCallCount(0);
						p.setCallFailCount(0);
						p.setCallSuccessCount(0);
						p.setLastImplementResult(false);
						p.setCreateUser(getSessionUser().getRealName());
						parametersService.save(p);
					}

					break;
					default:
						log.info("入参错误！");
						break;
			}
		} catch ( Exception e) {
			Log.error("", e);
			result.setSuccess(false);
			result.setMessage("复制失败");
			return result;
		}
		datas.put("caseNo",caseNo);
		result.setData(datas);
		result.setSuccess(true);
		result.setMessage("成功");
		return result;
	}

	/**
	 * 获取当前登录会员
	 */
	private User getSessionUser() {
		return (User) SecurityUtils.getSubject().getPrincipal();
	}


	@RequestMapping({"addOrDeleteMessage"})
	public String addMessage(HttpServletRequest request, HttpServletResponse response, Model model) {

		String actionName = Servlets.getParameter("actionName");
		try {
			model.addAllAttributes(this.referenceData(request));
			this.onCreate(request, response, model);
			model.addAttribute("action", actionName);
		} catch (Exception var5) {
			log.warn(this.getExceptionMessage(actionName, var5), var5);
			this.handleException("新增", var5, request);
		}

		return "/manage/jorge/parametersAddMessage";
	}

	/**
	 * 批量增加请求参数
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"addRequestParameters"})
	@ResponseBody
	protected JsonResult addRequestParameters(HttpServletRequest request, Map<String, Object> model){
		JsonResult result = new JsonResult();
		Map<String ,String> requestMap = Servlets.getParameters(request);
		String caseNo = requestMap.get("caseNo");
		log.info("批量添加{}参数！",caseNo);
		String[] parentJsaonName = request.getParameterValues("parentJsonName");
		String[] sonJsonName = request.getParameterValues("sonJsonName");
		String[] sonJsonValue = request.getParameterValues("sonJsonValue");
		Map<Object, Object> datas = new HashMap<>();
		try {
			List<Parameters> parameters = parametersService.findListParametersByCaseNo(caseNo);
			for (Parameters parameter: parameters) {
				String requestParameter = parameter.getParameters();
				if (StringUtils.isEmpty(requestParameter)){
					log.info("请求参数为空");
					return null;
				}
				JSONObject object = JSONObject.parseObject(requestParameter);
				for (int i = 0;i<parentJsaonName.length;i++){
					if ("/".equals(parentJsaonName[i])){
						if (!StringUtils.isEmpty(sonJsonValue[i]) && ClassUtil.isjson(sonJsonValue[i])) {
							object.put(sonJsonName[i],JSONObject.parseObject(sonJsonValue[i]));
						} else {
							object.put(sonJsonName[i],sonJsonValue[i]);
						}
					}else {
						String sonObjectString = object.get(parentJsaonName[i]).toString();
						JSONObject sonObject = JSONObject.parseObject(sonObjectString);
						if (!StringUtils.isEmpty(sonJsonValue[i]) && ClassUtil.isjson(sonJsonValue[i])) {
							sonObject.put(sonJsonName[i],JSONObject.parseObject(sonJsonValue[i]));
						} else {
							sonObject.put(sonJsonName[i],sonJsonValue[i]);
						}

						object.put(parentJsaonName[i],sonObject);
					}
				}
				parameter.setParameters(JSON.toJSONString(object, SerializerFeature.PrettyFormat,SerializerFeature.PrettyFormat));
				parametersService.update(parameter);
			}

		} catch (Exception e) {
			log.error("修改失败", e);
			result.setSuccess(false);
			result.setMessage("修改失败");
			return result;
		}
		datas.put("caseNo",caseNo);
		result.setData(datas);
		result.setSuccess(true);
		result.setMessage("成功");
		return result;
	}

	/**
	 * 批量删除请求参数中指定key值
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"deleteRequestParameters"})
	@ResponseBody
	protected JsonResult deleteRequestParameters(HttpServletRequest request, Map<String, Object> model){
		JsonResult result = new JsonResult();
		Map<String ,String> requestMap = Servlets.getParameters(request);
		String caseNo = requestMap.get("caseNo");

		String[] parentJsaonName = request.getParameterValues("parentJsonName");
		String[] sonJsonName = request.getParameterValues("sonJsonName");
		Map<Object, Object> datas = new HashMap<>();
		try {
			List<Parameters> parameters = parametersService.findListParametersByCaseNo(caseNo);
			for (Parameters parameter: parameters) {
				String requestParameter = parameter.getParameters();
				if (StringUtils.isEmpty(requestParameter)){
					log.info("请求参数为空");
					return null;
				}
				JSONObject object = JSONObject.parseObject(requestParameter);
				for (int i = 0;i<parentJsaonName.length;i++) {
					if ("/".equals(parentJsaonName[i])){
						object.remove(sonJsonName[i]);
					}else {
						String sonObjectString = object.get(parentJsaonName[i]).toString();
						JSONObject sonObject = JSONObject.parseObject(sonObjectString);
						sonObject.remove(sonJsonName[i]);

						object.put(parentJsaonName[i],sonObject);
					}
				}
				parameter.setParameters(JSON.toJSONString(object, SerializerFeature.PrettyFormat,SerializerFeature.PrettyFormat));
				parametersService.update(parameter);
			}

		} catch (Exception e) {
			Log.error("删除节点失败", e);
			result.setSuccess(false);
			result.setMessage("删除节点失败");
			return result;
		}
		datas.put("caseNo",caseNo);
		result.setData(datas);
		result.setSuccess(true);
		result.setMessage("成功");
		return result;
	}

	/**
	 * 批量执行测试用例
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "batchExecuteTestcase")
	@ResponseBody
	protected JsonResult batchExecuteTestcases(HttpServletRequest request, Map<String, Object> model){
		JsonResult result = new JsonResult();
		Map<Object, Object> datas = new HashMap<>();
		String batchType = Servlets.getParameter("batchType");
		System.out.println(batchType);
		String[] caseData = request.getParameterValues("caseData[]");
		String[] parameterNo = request.getParameterValues("parameterNo[]");
		Map<String, Object> map = new HashMap<>();
		map.put("IN_"+batchType ,caseData);
		if (parameterNo!=null && parameterNo.length!=0){
			map.put("IN_parametersNo" ,parameterNo);
		}
		Map<String, Boolean> sortMap = new HashMap<>();
		sortMap.put("caseNo",true);
		List<Parameters> parametersList = parametersService.query(map,sortMap);
		log.info("本次批量执行用例数量：{}",parametersList.size());
		StringBuffer url  = new StringBuffer();
		if (Apps.getEnvironment().acceptsProfiles("test")){
			url.append("http://jorge-testui.cartechfin-test:8999");
		}else {
			url.append(request.getScheme()).append("://").append(request.getServerName()).append(":").append(request.getServerPort());
		}
		log.info("url:{}",url);
		BatchInvokeTestCaseEvent event = new BatchInvokeTestCaseEvent();
		event.setParametersList(parametersList);
		event.setUrl(url.toString());
		eventBus.publish(event);

		result.setData(datas);
		result.setSuccess(true);
		result.setMessage("成功");
		return result;
	}

}
