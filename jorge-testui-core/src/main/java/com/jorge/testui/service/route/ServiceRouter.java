/*
 * acooly.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * qiubo@qq.com 2017-07-25 16:22 创建
 *
 */
package com.jorge.testui.service.route;

import com.jorge.testui.service.base.CaseService;

import java.util.Collection;

/**
 * 服务路由器
 *
 * @author qiubo@qq.com
 */
public interface ServiceRouter {
    CaseService route(String caseNo, Collection<CaseService> caseServices);
}
