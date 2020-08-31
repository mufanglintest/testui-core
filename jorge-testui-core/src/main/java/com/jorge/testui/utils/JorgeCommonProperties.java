package com.jorge.testui.utils;

import com.acooly.core.utils.Ids;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2019-12-25 11:11
 */
@Slf4j
@Configuration
@ConfigurationProperties(
        prefix = JorgeCommonProperties.PREFIX
)
@Data
public class JorgeCommonProperties {
    public static final String PREFIX = "jorge.common";


    /**
     * 是否启用默认配置
     */
    private Configuration configuration ;


    /**
     * 请求openapi地址
     */
    private String gatewayurl;

    /**
     * 商户accessKey
     */
    private String accessKey;
    /**
     * 商户密钥
     */
    private String secretKey;
    /**
     * 商户号
     */
    private String partnerId;
    /**
     * 异常通知地址
     */
    private String notifyUrl="";
    /**
     * 跳转地址
     */
    private String returnUrl="";

    /**
     * 请求服务名
     */
    private String service;
    /**
     * 加密类型
     */
    private String singType ="MD5";
    /**
     * 请求备注
     */
    private String context = "test";
    /**
     * 服务版本号
     */
    private String version = "1.0";
    /**
     * 请求流水号
     */
    private String requestNo = Ids.getDid("test");
    /**
     * 业务订单号
     */
    private String merchOrderNo = Ids.getDid("test");

    @Data
    public static class Configuration {
        private Boolean enable;

    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl+"/openapi/testApiNotify";
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl+"/openapi/testApiNotify";
    }
}
