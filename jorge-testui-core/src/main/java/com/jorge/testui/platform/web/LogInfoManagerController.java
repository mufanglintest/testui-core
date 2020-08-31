/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-12-04
*/
package com.jorge.testui.platform.web;

import com.acooly.core.common.web.AbstractJQueryEntityController;
import com.acooly.core.common.web.support.JsonResult;
import com.acooly.core.utils.Ids;
import com.alibaba.fastjson.JSONObject;
import com.jorge.testui.platform.entity.LogInfo;
import com.jorge.testui.platform.service.LogInfoService;
import com.jorge.testui.utils.AssertsUtil;
import com.jorge.testui.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * log_info 管理控制器
 * 
 * @author mufanglin
 * Date: 2019-12-04 11:37:17
 */
@Slf4j
@Controller
@RequestMapping(value = "/manage/jorge/logInfo")
public class LogInfoManagerController extends AbstractJQueryEntityController<LogInfo, LogInfoService> {
	

	{
		allowMapping = "*";
	}

	@SuppressWarnings("unused")
	@Autowired
	private LogInfoService logInfoService;

	@RequestMapping({"returnAddDatas"})
	public String addMessage(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("merchOderNo",Ids.getDid());
		return "/manage/jorge/testDatasAdd";
	}

	@RequestMapping(value = {"testDatasAdd"})
	@ResponseBody
	private JsonResult testDatasAdd(HttpServletRequest request, Map<String, Object> model){
		JsonResult result = new JsonResult();
		Map<Object, Object> datas = new HashMap<>();

		String requestNo = Ids.getDid(20);
		String merchOrderNo = Ids.getDid(20);
		try {
			Map<String, Object> dataMap = new HashMap<>();
			dataMap.clear();
			dataMap.put("service", request.getParameter("service"));
			dataMap.put("version", request.getParameter("version"));
			dataMap.put("partnerId", request.getParameter("partnerId"));
			dataMap.put("signType", request.getParameter("signType"));
			dataMap.put("requestNo", requestNo);
			if(StringUtils.isEmpty(request.getParameter("merchOrderNo")) ){
				dataMap.put("merchOrderNo", merchOrderNo);
			}else {
				dataMap.put("merchOrderNo", request.getParameter("merchOrderNo"));
			}
			dataMap.put("notifyUrl", request.getParameter("notifyUrl"));
			dataMap.put("returnUrl", request.getParameter("returnUrl"));

			dataMap.putAll(HttpUtil.parseJsonBody(request.getParameter("values")));

			JSONObject responseEntity = HttpUtil.httpRequest1(request.getParameter("gatewayUrl"), dataMap, request.getParameter("securityCheckKey"), request.getParameter("accessKey"));
			AssertsUtil.assertThan(responseEntity.get("code"),request.getParameter("resultCode"));
		} catch (Exception e) {
			log.error("添加失败", e);
			result.setSuccess(false);
			result.setMessage("添加失败");
			return result;
		}
		result.setData(datas);
		result.setSuccess(true);
		result.setMessage("成功");
		return result;
	}
	

}
