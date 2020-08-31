/*
 * acooly.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * qiubo@qq.com 2017-07-25 16:25 创建
 *
 */
package com.jorge.testui.service.route;

import com.acooly.core.utils.Collections3;
import com.jorge.testui.annotation.CaseApiService;
import com.jorge.testui.exception.CaseServiceRouteException;
import com.jorge.testui.service.base.CaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * 默认服务路由实现
 *
 * <p>支持服务版本路由: 1.用户请求没有版本,选择最高的版本 2.用户请求有版本,完全匹配
 *
 * @author qiubo@qq.com
 */
@Component("serviceRouter")
@Slf4j
public class DefaultServiceRouterImpl implements ServiceRouter {

    @Override
    public CaseService route(String caseNo, Collection<CaseService> caseServices) {
        if (caseServices == null || Collections3.isEmpty(caseServices)) {
            return serverNotFound(caseNo);
        }
        Iterator<CaseService> iterator = caseServices.iterator();
        if (caseServices.size() == 1) {
            return iterator.next();
        } else {
            log.error("用例caseNo={}发现多个");
            return null;
        }
    }

    private CaseService serverNotFound(String caseNo) {
        log.warn("请求用例[" + caseNo + "]不存在");
        throw new CaseServiceRouteException(caseNo);
    }

    private CaseApiService getOpenApiServiceAnnotation(CaseService caseService) {
        return caseService.getClass().getAnnotation(CaseApiService.class);
    }
}
