package com.jorge.testui.message;

import com.acooly.core.utils.Ids;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2019-11-01 14:12
 */
@Slf4j
@Getter
@Setter
public class ApiRequest extends CaseBaseRequest {

    /**
     * 服务名
     */
    private String service;

    /**
     * 密钥
     */
    private String securityKey = "06f7aab08aa2431e6dae6a156fc9e0b4";

    /**
     * 商户号
     */
    private String partnerId = "test";

    private String accessKey = "test";

    private String notifyUrl ="http://127.0.0.1:8999/openapi/testApiNotify";
    private String version = "1.0";
    private String returnUrl = "http://127.0.0.1:8999/openapi/testApiNotify";
    private String requestNo = Ids.getDid();
    /**
     * 请求类型
     */
    private String singType = "MD5";
    private String merchOrderNo = Ids.getDid();

    /**
     * 响应结果
     */
    private String resultCode = "SUCCESS";

    /**
     *
     */
    private String message ="成功";

    private String detail = "成功";



}
