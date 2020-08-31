package com.jorge.testui.service.base;

import com.acooly.core.common.facade.ResultBase;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-03-23 11:12
 */
public interface MockGatewayService<O , R extends ResultBase> {
    void executeGateway(O order, R result) throws Exception;

    O getGatewayOrderBean();
    R getResponseBean();
}
