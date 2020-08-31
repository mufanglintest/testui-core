package com.jorge.testui.service.factory.impl;

import com.acooly.core.common.exception.BusinessException;
import com.google.common.collect.Maps;
import com.jorge.testui.annotation.MockGatewayAnnotationService;
import com.jorge.testui.enums.GatewayChannelApiEnum;
import com.jorge.testui.service.base.MockGatewayService;
import com.jorge.testui.service.factory.MockServiceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-07-29 11:21
 */
@Slf4j
@Component
public class MockServiceFactoryImpl implements MockServiceFactory, ApplicationContextAware, InitializingBean {
    private Map<String , MockGatewayService> mockGatewayServiceMap = null;
    private ApplicationContext applicationContext;
    @Override
    public MockGatewayService getMockGatewayService(String serviceName) {
        MockGatewayService mockGatewayServices = mockGatewayServiceMap.get(serviceName);
        if (mockGatewayServices == null) {
            throw new BusinessException("mock不支持serviceName[" + serviceName + "]");
        }
        return mockGatewayServices;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        mockGatewayServiceMap = Maps.newHashMap();
        Map<String, MockGatewayService> mockGatewayServiceBeansMap =
                applicationContext.getBeansOfType(MockGatewayService.class);
        if (mockGatewayServiceBeansMap.isEmpty()){
            log.warn("测试工程没有对外提供Mock服务");
        }
        for (MockGatewayService mockGatewayService : mockGatewayServiceBeansMap.values()) {
            registerMockService(mockGatewayService, mockGatewayServiceMap);
        }
    }

    /**
     * 注册Mock网关相关服务
     * @param mockGatewayService
     * @param mockGatewayServiceMap
     */
    private void registerMockService(MockGatewayService mockGatewayService ,Map<String, MockGatewayService> mockGatewayServiceMap){
        MockGatewayAnnotationService mockGatewayAnnotationService = getMockServiceAnnotation(mockGatewayService);
        if (mockGatewayAnnotationService == null){
            throw new RuntimeException(
                    "测试用例"
                            + mockGatewayService.getClass()
                            + "必须要标记com.jorge.testui.annotation.MockGatewayService注解");
        }

        GatewayChannelApiEnum[] channelApiEnums = mockGatewayAnnotationService.gatewayApi();
        for (GatewayChannelApiEnum channelApiEnum : channelApiEnums) {
            if (mockGatewayServiceMap.containsKey(channelApiEnum.getCode())) {
                throw new RuntimeException("网关服务Api冲突:" + mockGatewayService.getClass() + "和" + mockGatewayAnnotationService.getClass());
            }
            mockGatewayServiceMap.put(channelApiEnum.getCode(), mockGatewayService);
            log.info("加载网关Mock服务[{}] {}: {} {}", mockGatewayAnnotationService.desc(), channelApiEnum, mockGatewayService.getClass().getName());
        }

    }

    private MockGatewayAnnotationService getMockServiceAnnotation(MockGatewayService gatewayService) {
        return gatewayService.getClass().getAnnotation(MockGatewayAnnotationService.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
