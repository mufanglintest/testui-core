/*
 * acooly.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * qiubo@qq.com 2017-07-25 16:29 创建
 * zhangpu 2016-03-15 增加suid
 *
 */
package com.jorge.testui.exception;

/**
 * 服务路由异常
 *
 * @author qiubo@qq.com
 * @author zhangpu
 */
public class CaseServiceRouteException extends CaseServiceException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3385225632927612343L;

    public CaseServiceRouteException(String caseNo) {
        super("请求用例[" + caseNo + "]不存在");
    }
}
