/**
 * jorge-testui-parent
 * <p>
 * Copyright 2019 Acooly.cn, Inc. All rights reserved.
 *
 * @author zhike
 * @date 2019-07-19 10:15
 */
package com.jorge.testui.executer;

import com.acooly.core.common.exception.BusinessException;
import com.acooly.core.common.facade.ResultCode;
import com.acooly.core.utils.Servlets;
import com.acooly.core.utils.StringUtils;
import com.acooly.core.utils.validate.Validators;
import com.acooly.module.security.domain.User;
import com.jorge.testui.exception.CaseServiceRouteException;
import com.jorge.testui.message.ApiRequest;
import com.jorge.testui.message.CaseBaseRequest;
import com.jorge.testui.message.CaseBaseResponse;
import com.jorge.testui.context.CaseContext;
import com.jorge.testui.exception.CaseServiceException;
import com.jorge.testui.marshall.CaseApiRequestMarshall;
import com.jorge.testui.marshall.CaseApiResponseMarshall;
import com.jorge.testui.platform.entity.TestCase;
import com.jorge.testui.platform.service.TestCaseService;
import com.jorge.testui.service.factory.CaseServiceFactory;
import com.jorge.testui.utils.JorgeCommonProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhike
 * @date 2019-07-19 10:15
 */
@Slf4j
public abstract class HttpCaseServiceExecuter implements CaseServiceExecuter<HttpServletRequest, HttpServletResponse> {

    @Autowired
    protected CaseServiceFactory caseServiceFactory;

    @Autowired
    private CaseApiRequestMarshall caseApiRequestMarshall;

    @Autowired
    private CaseApiResponseMarshall caseApiResponseMarshall;

    @Autowired
    private TestCaseService testCaseService;

    @Autowired
    JorgeCommonProperties jorgeCommonProperties;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String caseNo = Servlets.getParameter("caseNo");
        String projectNo = Servlets.getParameter("projectNo");
        String interfaceNo = Servlets.getParameter("interfaceNo");
        String parametersNo = Servlets.getParameter("parametersNo");
        String requestType = Servlets.getParameter("requestType");
        List<TestCase> testCases = new ArrayList<>();
        switch (requestType) {
            case "project":
                log.info("请求用例类型为project，请求projectNo为{}", projectNo);
                testCases = testCaseService.findListbyProjectNo(projectNo);
                if (testCases != null && testCases.size() == 0 ) {
                    log.info("请求用例类型为project，请求projectNo为{}未查询到用例",projectNo);
//                    throw new BusinessException("请求用例类型为project，请求projectNo为{" + projectNo + "}未查询到用例");
                }
                break;
            case "interface":
                log.info("请求用例类型为interface，请求interfaceNo为{}", interfaceNo);
                testCases = testCaseService.findListbyInterfaceNo(interfaceNo);
                if (testCases != null && testCases.size() == 0) {
                    log.info("请求用例类型为interface，请求interfaceNo为{}未查询到用例", interfaceNo);
//                    throw new BusinessException("请求用例类型为interface，请求interfaceNo为{" + interfaceNo + "}未查询到用例");
                }
                break;
            case "case":
                if (StringUtils.isEmpty(caseNo)) {
                    log.info("请求用例类型为case，请求caseNo为{}", caseNo);
//                    throw new BusinessException("请求用例类型为case，请求caseNo为空");
                }
                testCases = testCaseService.findListByCaseNo(caseNo);
                if (testCases != null && testCases.size() == 0) {
                    log.info("请求用例类型为case，请求caseNo为{}未查询到用例", caseNo);
//                    throw new BusinessException("请求用例类型为case，请求caseNo为{" + caseNo + "}未查询到用例");
                }
                break;
            case "parameters":
                if (StringUtils.isEmpty(caseNo) && StringUtils.isEmpty(parametersNo)) {
                    log.info("请求用例类型为parameters，请求caseNo为{},parameterNo为{}", caseNo, parametersNo);
//                    throw new BusinessException("请求用例类型为parameters，请求caseNo或parameterNo为空");
                }
                testCases = testCaseService.findListByCaseNoAndParametersNo(caseNo, parametersNo);
                if (testCases != null && testCases.size() == 0) {
                    log.info("请求用例类型为parameters，请求caseNo为{},parametersNo为{}未查询到用例", caseNo,parametersNo);
//                    throw new BusinessException("请求用例类型为parameters，请求caseNo为{" + caseNo + "},parameterNo为{" + parametersNo + "}未查询到用例");
                }
                break;
            default:
                log.info("入参错误！");
                    break;

        }

        for (TestCase testcase : testCases) {
            CaseContext caseContext = new CaseContext();
            caseContext.setCaseNo(testcase.getCaseNo());
            caseContext.setParametersNo(testcase.getParametersNo());
            caseContext.setTestCase(testcase);
            caseContext.setInterfaceNo(testcase.getInterfaceNo());
            caseContext.setProjectNo(testcase.getProjectNo());
            try {
                //初始化context
                doInitCaseContext(caseContext, request, response);
                //校验参数
                doVerify(caseContext);
                //执行用例
                doExceute(caseContext);
            } catch (BusinessException e) {
                e.printStackTrace();
                log.error("用例【{}】执行失败！{}", caseContext.getCaseNo(),e.getMessage());
                caseContext.getResponse().setSuccess(false);
            } catch (CaseServiceRouteException e) {
                e.printStackTrace();
                log.error("用例【{}】执行失败！{}",caseContext.getCaseNo(), e.getMessage());
                CaseBaseResponse caseApiResponse = new CaseBaseResponse();
                caseApiResponse.setSuccess(false);
                caseContext.setResponse(caseApiResponse);
            } catch (CaseServiceException e) {
                e.printStackTrace();
                log.error("用例【{}】执行失败！{}",caseContext.getCaseNo(), e.getMessage());
                caseContext.getResponse().setSuccess(false);
            } catch (Throwable ex) {
                ex.printStackTrace();
                log.error("用例【{}】处理异常：{}", caseContext.getCaseNo(), ex.getMessage());
                caseContext.getResponse().setSuccess(false);
//                throw new CaseServiceException("用例处理异常");
            } finally {
                doFinally(caseContext);
            }
        }


    }

    /**
     * 获取当前登录会员
     */
    private User getSessionUser() {
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    protected abstract void doInitCaseContext(CaseContext caseContext, HttpServletRequest orignalRequest, HttpServletResponse orignalResponse);


    protected void doVerify(CaseContext caseContext) {
        // 请求参数解码
        doUnmarshal(caseContext);
        // 参数校验
        doValidateParameter(caseContext);
    }


    /**
     * 公共Api参数合法性检查
     */
    protected void doValidateParameter(CaseContext caseContext) {
        try {
            Validators.assertJSR303(caseContext.getRequest());
            caseContext.getRequest().check();
        } catch (IllegalArgumentException iae) {
            throw new CaseServiceException(ResultCode.PARAMETER_ERROR.getCode() + iae.getMessage());
        } catch (CaseServiceException ae) {
            throw ae;
        } catch (Exception e) {
            throw new CaseServiceException(
                    ResultCode.PARAMETER_ERROR + "参数合法性检查未通过:" + e.getMessage());
        }
    }

    protected abstract void doExceute(CaseContext caseContext);

    /**
     * 解报
     *
     * @param apiContext
     * @return
     */
    protected void doUnmarshal(CaseContext apiContext) {
        CaseBaseRequest apiRequest = caseApiRequestMarshall.marshall(apiContext);
        //判断是否是API接口，并且是否使用配置文件中参数配置
        if (jorgeCommonProperties.getConfiguration().getEnable() && "ApiRequest".equals(apiRequest.getClass().getSuperclass().getSimpleName())){
            apiContext.setGatewayUrl(jorgeCommonProperties.getGatewayurl());
            ((ApiRequest)apiRequest).setPartnerId(jorgeCommonProperties.getPartnerId());
            ((ApiRequest)apiRequest).setAccessKey(jorgeCommonProperties.getAccessKey());
            ((ApiRequest)apiRequest).setSecurityKey(jorgeCommonProperties.getSecretKey());
        }
        apiRequest.setGatewayUrl(apiContext.getGatewayUrl());
        apiRequest.setCaseNo(apiContext.getCaseNo());
        apiRequest.setParameterNo(apiContext.getParametersNo());
        apiContext.setRequest(apiRequest);
    }

    protected void doFinally(CaseContext caseContext) {
        try {
            log.info("项目:{}，接口:{}，用例:{}，参数编号:{}执行结束,执行结果:{}。", caseContext.getProjectNo(),
                    caseContext.getInterfaceNo(), caseContext.getCaseNo(), caseContext.getParametersNo(),caseContext.getResponse().getSuccess());
            doResponse(caseContext);
        } catch (Exception e) {
            log.warn("响应处理失败:", e);
        } finally {
            MDC.clear();
            destoryApiContext(caseContext);
        }
    }


    protected void doResponse(CaseContext apiContext) {
        CaseBaseResponse apiResponse = apiContext.getResponse();
        HttpServletResponse response = apiContext.getOrignalResponse();
        String marshallStr = doResponseMarshal(apiResponse);
        Servlets.writeResponse(response, marshallStr);
    }

    /**
     * 组报
     *
     * @return
     */
    protected String doResponseMarshal(CaseBaseResponse apiResponse) {
        return (String) caseApiResponseMarshall.marshall(apiResponse);
    }

    /**
     * 销毁释放线程绑定ApiContext
     *
     * @param caseContext
     */
    protected void destoryApiContext(CaseContext caseContext) {
        caseContext.destory();
    }

    protected void prepareResponse(CaseContext caseContext) {
        CaseBaseResponse caseApiResponse = caseContext.getResponse();
        if (caseContext.getResponse() == null) {
            return;
        }
        CaseBaseRequest caseApiRequest = caseContext.getRequest();
        if (caseApiRequest == null) {
            return;
        }
        caseApiResponse.setCaseNo(caseApiRequest.getCaseNo());
        caseApiResponse.setGatewayUrl(caseApiRequest.getGatewayUrl());
        caseApiResponse.setContext(caseApiRequest.getContext());
    }
}
