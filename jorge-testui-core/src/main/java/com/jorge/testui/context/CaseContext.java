/**
 * jorge-testui-parent
 * <p>
 * Copyright 2019 Acooly.cn, Inc. All rights reserved.
 *
 * @author zhike
 * @date 2019-07-19 10:05
 */
package com.jorge.testui.context;

import com.acooly.core.common.facade.InfoBase;
import com.acooly.core.utils.Ids;
import com.jorge.testui.CaseConstants;
import com.jorge.testui.message.CaseBaseRequest;
import com.jorge.testui.message.CaseBaseResponse;
import com.jorge.testui.annotation.CaseApiService;
import com.jorge.testui.platform.entity.TestCase;
import com.jorge.testui.service.base.CaseService;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.MDC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhike
 * @date 2019-07-19 10:05
 */
@Getter
@Setter
public class CaseContext extends InfoBase {

    private HttpServletRequest orignalRequest;
    private HttpServletResponse orignalResponse;

    private String gid;

    private CaseApiService caseApiService;

    @SuppressWarnings("rawtypes")
    private CaseService caseService;

    private TestCase testCase;

    /**
     * 用例编码
     */
    private String caseNo;

    /**
     * 项目编码
     */
    private String projectNo;

    /**
     * 接口编码
     */
    private String interfaceNo;

    /**
     * 参数编码
     */
    private String parametersNo;

    private CaseBaseRequest request;

    private CaseBaseResponse response;

    private String requestBody;

    private String responseBody;

    private String gatewayUrl;

    public CaseApiService getCaseApiService() {
        return caseApiService;
    }

    public void setCaseApiService(CaseApiService caseApiService) {
        this.caseApiService = caseApiService;
        setCaseNo(caseApiService.caseNo());
    }

    public void init() {
        this.gid = Ids.gid();
        MDC.put(CaseConstants.GID, gid);
        MDC.put("caseNo", caseNo);
    }

    public void setCaseService(CaseService caseService) {
        this.setCaseApiService(caseService.getClass().getAnnotation(CaseApiService.class));
        this.caseService = caseService;
    }

    public void destory() {

    }
}
