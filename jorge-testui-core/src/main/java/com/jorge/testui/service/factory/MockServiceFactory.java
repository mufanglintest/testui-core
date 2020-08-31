package com.jorge.testui.service.factory;

import com.jorge.testui.service.base.MockGatewayService;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-07-29 11:20
 */
public interface MockServiceFactory {
    MockGatewayService getMockGatewayService(String serviceName);
}
