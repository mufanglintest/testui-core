/**
 * jorge-testui-parent
 * <p>
 * Copyright 2019 Acooly.cn, Inc. All rights reserved.
 *
 * @author zhike
 * @date 2019-07-19 09:57
 */
package com.jorge.testui.service.base;

import com.jorge.testui.message.CaseBaseRequest;
import com.jorge.testui.message.CaseBaseResponse;
import com.jorge.testui.context.CaseContext;

/**
 *
 * @author zhike
 * @date 2019-07-19 09:57
 */
public interface CaseService<O extends CaseBaseRequest,R extends CaseBaseResponse> {

    void caseBefore(CaseContext caseContext);

    void caseService(CaseContext caseContext);

    void caseAfter(CaseContext caseContext);

    O getRequestBean();

    R getResponseBean();
}
