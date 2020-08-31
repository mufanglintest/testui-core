package com.jorge.testui.annotation;

import com.jorge.testui.enums.GatewayChannelApiEnum;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-03-23 11:27
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface MockGatewayAnnotationService {

    /**
     * 服务码
     * @return
     */
    GatewayChannelApiEnum[] gatewayApi();

    /**
     * 用例描述
     * @return
     */
    String desc();

    /**
     * 用例的开发人员
     * @return
     */
    String owner() default "unknown";
}
