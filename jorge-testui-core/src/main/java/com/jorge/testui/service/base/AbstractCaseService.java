/*
 * acooly.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */
package com.jorge.testui.service.base;
import com.jorge.testui.context.CaseContext;
import com.jorge.testui.message.CaseBaseRequest;
import com.jorge.testui.message.CaseBaseResponse;
import com.jorge.testui.platform.dao.ExecuteLogDao;
import com.jorge.testui.platform.entity.ExecuteLog;
import com.jorge.testui.platform.entity.LogInfo;
import com.jorge.testui.platform.entity.Parameters;
import com.jorge.testui.platform.service.LogInfoService;
import com.jorge.testui.platform.service.ParametersService;
import com.jorge.testui.utils.GenericsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Api Service 抽象模板实现
 *
 * <p>service处理模板，统一错误处理
 *
 * @author zhangpu
 * @author Bohr.Qiu <qiubo@qq.com>
 */
public abstract class AbstractCaseService<O extends CaseBaseRequest, R extends CaseBaseResponse>
											implements CaseService<O, R> {
	private static final Logger	log	= LoggerFactory.getLogger(AbstractCaseService.class);
	private Class<O>			requestClazz;
	private Class<R>			responseClazz;
	
	@Autowired
	private ParametersService	parametersService;
	
	@Autowired
	private ExecuteLogDao		executeLogDao;
	
	@Autowired
	private LogInfoService		logInfoService;
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final void caseService(CaseContext caseContext) {
		try {
			doInitRequest((O) caseContext.getRequest(), (R) caseContext.getResponse());

			doDelete((O) caseContext.getRequest(), (R) caseContext.getResponse());

			doInitData((O) caseContext.getRequest(), (R) caseContext.getResponse());

			doService((O) caseContext.getRequest(), (R) caseContext.getResponse());

			doCheckData((O) caseContext.getRequest(), (R) caseContext.getResponse());

			if (caseContext.getResponse().getIsEndDelete()){
				doDelete((O) caseContext.getRequest(), (R) caseContext.getResponse());
			}

			doSuccess(caseContext);
		} catch (Exception e) {
			throw e;
		}
	}

	protected void doDelete(O request, R response){
		System.out.println("todo...delete...");
	}
	protected void doInitRequest(O request, R response){
		System.out.println("todo...InitRequest...");
	}
	protected void doInitData(O request, R response){
		System.out.println("todo...InitData...");
	}
	protected void doCheckData(O request, R response){
		System.out.println("todo...CheckData...");
	}

	private void doSuccess(CaseContext caseContext){
		caseContext.getResponse().setCaseNo(caseContext.getCaseNo());
		caseContext.getResponse().setSuccess(true);
		caseContext.getResponse().setGatewayUrl(caseContext.getGatewayUrl());
	}
	
	@Override
	public void caseBefore(CaseContext caseContext) {
		//记录每次执行原请求数据，防止被其它人误删后可从日志表中找回
		ExecuteLog executeLog = new ExecuteLog();
		executeLog.setCaseNo(caseContext.getCaseNo());
		executeLog.setProjectNo(caseContext.getProjectNo());
		executeLog.setInterfaceNo(caseContext.getInterfaceNo());
		executeLog.setParameterNo(caseContext.getParametersNo());
		executeLog.setParameters(caseContext.getRequestBody());
		executeLogDao.insert(executeLog);
		log.info("request:{}",caseContext.getRequest());
		log.info("项目:{}，接口:{}，用例:{}，参数编号:{}开始执行。", caseContext.getProjectNo(),
			caseContext.getInterfaceNo(), caseContext.getCaseNo(), caseContext.getParametersNo());
	}
	
	@Override
	public void caseAfter(CaseContext caseContext) {
        LogInfo logInfo = new LogInfo();
        logInfo.setProjectNo(caseContext.getTestCase().getProjectNo());
        logInfo.setInterfaceNo(caseContext.getTestCase().getInterfaceNo());
        logInfo.setCaseNo(caseContext.getTestCase().getCaseNo());
        logInfo.setParametersNo(caseContext.getTestCase().getParametersNo());
        logInfo.setRequestInfo(caseContext.getResponse().getContext());
        logInfo.setResultInfo(caseContext.getResponse().getApiResponse());
        logInfo.setMemo(caseContext.getTestCase().getCaseName());
        logInfo.setExexuteStatus(caseContext.getResponse().getSuccess());
		logInfoService.save(logInfo);
		Parameters parameters = parametersService.findParametersByCaseNoAndParametersNo(
			caseContext.getCaseNo(), caseContext.getParametersNo());
		parameters.setCallCount(parameters.getCallCount() + 1);
		if (caseContext.getResponse().getSuccess()) {
			parameters.setCallSuccessCount(parameters.getCallSuccessCount() + 1);
		} else {
			parameters.setCallFailCount(parameters.getCallFailCount() + 1);
		}
		parameters.setLastImplementResult(caseContext.getResponse().getSuccess());
		parametersService.update(parameters);
		
	}
	
	/**
	 * 服务处理方法
	 *
	 * <p>如果抛出非ApiServiceException异常,对外响应内部错误
	 *
	 * <p>如果抛出ApiServiceException异常,会根据异常的信息返回给用户
	 *
	 * <p>
	 *
	 * @param request
	 * @param response
	 */
	protected abstract void doService(O request, R response);
	
	@Override
	public O getRequestBean() {
		if (requestClazz == null) {
			requestClazz = GenericsUtils.getSuperClassGenricType(getClass(), 0);
		}
		try {
			if (requestClazz.equals(Object.class)) {
				return (O) new CaseBaseRequest();
			} else {
				return BeanUtils.instantiate(requestClazz);
			}
		} catch (Exception e) {
			throw new RuntimeException("实例化Request对象失败:" + requestClazz.toString());
		}
	}
	
	@Override
	public R getResponseBean() {
		if (responseClazz == null) {
			responseClazz = GenericsUtils.getSuperClassGenricType(getClass(), 1);
		}
		try {
			if (responseClazz.equals(Object.class)) {
				return (R) new CaseBaseResponse();
			} else {
				return BeanUtils.instantiate(responseClazz);
			}
		} catch (Exception e) {
			throw new RuntimeException("实例化Response对象失败:" + responseClazz.toString());
		}
	}
}
