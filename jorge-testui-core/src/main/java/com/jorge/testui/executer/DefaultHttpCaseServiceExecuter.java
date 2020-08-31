/**
 * jorge-testui-parent
 * <p>
 * Copyright 2019 Acooly.cn, Inc. All rights reserved.
 *
 * @author zhike
 * @date 2019-07-19 11:10
 */
package com.jorge.testui.executer;

import com.jorge.testui.exception.CaseServiceException;
import com.jorge.testui.message.CaseBaseRequest;
import com.jorge.testui.message.CaseBaseResponse;
import com.jorge.testui.context.CaseContext;
import com.jorge.testui.platform.service.TestCaseService;
import com.jorge.testui.service.base.CaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author zhike
 * @date 2019-07-19 11:10
 */
@Slf4j
@Component
public class DefaultHttpCaseServiceExecuter extends HttpCaseServiceExecuter {

    @Autowired
    private TestCaseService testCaseService;

    @Override
    protected void doInitCaseContext(CaseContext caseContext, HttpServletRequest orignalRequest, HttpServletResponse orignalResponse) {
        caseContext.init();
        caseContext.setOrignalRequest(orignalRequest);
        caseContext.setOrignalResponse(orignalResponse);

        CaseService caseService = caseServiceFactory.getCaseService(caseContext.getCaseNo());
        caseContext.setCaseService(caseService);
//        //获取请求报文
//        TestCase testCase = testCaseService.findByCaseNoAndProjectNo(caseNo, projectNo);
//        if (testCase == null) {
//            log.info("请求用例caseNo={}没有录入数据库", caseNo);
//            throw new BusinessException("请求用例没有录入数据库");
//        }
        caseContext.setGatewayUrl(caseContext.getTestCase().getUrl());
        caseContext.setRequestBody(caseContext.getTestCase().getInput());
        CaseBaseRequest apiRequest = caseService.getRequestBean();
        CaseBaseResponse apiResponse = caseService.getResponseBean();
        caseContext.setRequest(apiRequest);
        caseContext.setResponse(apiResponse);
    }



    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    protected void doExceute(CaseContext caseContext) {
        CaseService caseService = caseContext.getCaseService();
        CaseBaseRequest caseApiRequest = caseContext.getRequest();
        CaseBaseResponse caseApiResponse = caseContext.getResponse();
//        try {
//            caseService.caseBefore(caseContext);
//            caseService.caseService(caseContext);
//        } catch (Throwable ex) {
//            throw ex;
//        } finally {
//            caseService.caseAfter(caseContext);
//        }
        caseServiceExceute(caseService,caseContext);
    }


    protected void caseServiceExceute(CaseService caseService , CaseContext caseContext){
        Date fromDate3 = new Date();
        log.info("开始时间:{}",fromDate3);
        try {
            caseService.caseBefore(caseContext);
            caseService.caseService(caseContext);
        }catch (CaseServiceException exception){
            log.info("用例执行失败，请重试！");
            throw exception;
        }catch (Throwable ex) {
            throw ex;
        } finally {
            Date toDate3 = new Date();
            long from3 = fromDate3.getTime();
            long to3 = toDate3.getTime();
            log.info("结束时间:{}",toDate3);
            int minutes = (int) ((to3 - from3) / 1000 );
            log.info("单条用例执行时间:{}秒。",minutes);
            caseService.caseAfter(caseContext);
        }
    }
}
