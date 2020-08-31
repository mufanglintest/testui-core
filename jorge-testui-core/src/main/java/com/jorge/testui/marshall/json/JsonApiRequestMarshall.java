/*
 * acooly.cn Inc.
 * Copyright (c) 2016 All Rights Reserved.
 * create by zhangpu
 * date:2016年3月17日
 *
 */
package com.jorge.testui.marshall.json;


import com.jorge.testui.message.CaseBaseRequest;
import com.jorge.testui.context.CaseContext;
import com.jorge.testui.enums.CaseApiProtocol;
import com.jorge.testui.marshall.CaseApiRequestMarshall;
import com.jorge.testui.utils.JsonMarshallor;
import org.springframework.stereotype.Component;

/**
 * @author Bohr.Qiu <qiubo@qq.com>
 * @author zhangpu： 增加对部分隐私加密信息解密功能
 * @author zhangpu 重构接口抽象框架
 */
@Component
public class JsonApiRequestMarshall implements CaseApiRequestMarshall<CaseBaseRequest, CaseContext> {

    private static JsonMarshallor jsonMarshallor = JsonMarshallor.INSTANCE;


    @Override
    public CaseBaseRequest marshall(CaseContext caseContext) {
        String requestBody = caseContext.getRequestBody();
        CaseBaseRequest parsed = jsonMarshallor.parse(requestBody, caseContext.getRequest().getClass());
        return parsed;
    }

    @Override
    public CaseApiProtocol getProtocol() {
        return CaseApiProtocol.JSON;
    }
}
