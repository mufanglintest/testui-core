/*
 * www.cnvex.cn

 Inc.
 * Copyright (c) 2018 All Rights Reserved.
 *                    _ooOoo_
 *                   o8888888o
 *                   88" . "88
 *                   (| -_- |)
 *                   O\  =  /O
 *                ____/`---'\____
 *              .'  \\|     |//  `.
 *             /  \\|||  :  |||//  \
 *            /  _||||| -:- |||||-  \
 *            |   | \\\  -  /// |   |
 *            | \_|  ''\---/''  |   |
 *            \  .-\__  `-`  ___/-. /
 *          ___`. .'  /--.--\  `. . __
 *       ."" '<  `.___\_<|>_/___.'  >'"".
 *      | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *      \  \ `-.   \_ __\ /__ _/   .-` /  /
 *  ======`-.____`-.___\_____/___.-`____.-'======
 *                     `=---='
 *  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *           佛祖保佑       永无测试遗漏
 */

package com.jorge.testui.enums;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @Author ck.wu
 * @Email 506093826@qq.com
 * @Version 1.0
 * @History 2019年12月13日 下午11:55:58
 *
 */
public enum RequestServiceEnum {

    FMPayWeixinJsService("FMPayWeixinJsService", "富民微信公众号(线下)"),

    ChinaumsWeixinAppService("ChinaumsWeixinAppService", "银联商务微信APP服务"),
    ChinaumsQueryService("ChinaumsQueryService", "银联商务微信APP服务"),
    ChinaumsRefundService("ChinaumsRefundService", "银商交易退款"),
    ChinaumsRefundQueryService("ChinaumsRefundQueryService", "银商交易退款查询"),

    CpcnQuickPaymentService("CpcnQuickPaymentService", "银商交易退款查询"),
    
    QuickPaymentConsumeSms("QuickPaymentConsumeSms", "富民快捷支付短信申请"),
    TradeQuickPaymentConsume("TradeQuickPaymentConsume", "富民快捷支付确认"),
    
    FmAccountIIRechargeService("FmAccountIIRechargeService", "富民II类户资金转入"),
    FmAccountIIWithdrawService("FmAccountIIWithdrawService", "富民II类账户资金转出"),
    
    
    /**
     * 失败:FAIL
     */
    FAIL("FAIL", "失败");

    /**
     * 枚举值
     */
    private final String code;

    /**
     * 枚举描述
     */
    private final String message;

    /**
     * 构造一个<code>CertTypeEnum</code>枚举对象
     *
     * @param code
     * @param message
     */
    private RequestServiceEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @return Returns the code.
     */
    public String getCode() {
        return code;
    }

    /**
     * @return Returns the message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return Returns the code.
     */
    public String code() {
        return code;
    }

    /**
     * @return Returns the message.
     */
    public String message() {
        return message;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     *
     * @param code
     * @return CertTypeEnum
     */
    public static RequestServiceEnum getByCode(String code) {
        for (RequestServiceEnum _enum : values()) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     *
     * @return List<CertTypeEnum>
     */
    public List<RequestServiceEnum> getAllEnum() {
        List<RequestServiceEnum> list = new ArrayList<RequestServiceEnum>();
        for (RequestServiceEnum _enum : values()) {
            list.add(_enum);
        }
        return list;
    }

    /**
     * 获取全部枚举值
     *
     * @return List<String>
     */
    public List<String> getAllEnumCode() {
        List<String> list = new ArrayList<String>();
        for (RequestServiceEnum _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    public boolean isInList(RequestServiceEnum... enums) {
        for (RequestServiceEnum _enum : enums) {
            if (this == _enum) {
                return true;
            }
        }
        return false;
    }

    public static Map<String, String> mapping() {
        Map<String, String> map = Maps.newLinkedHashMap();
        for (RequestServiceEnum type : values()) {
            map.put(type.getCode(), type.getMessage());
        }
        return map;
    }
}
