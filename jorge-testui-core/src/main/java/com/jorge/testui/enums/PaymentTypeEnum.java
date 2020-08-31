/**
 *重庆气摩交易所有限公司版权所有  
 *cheyunpay-member-openapi-message_com.cartechfin.cheyunpay.openapi.member.enums_PaymentTypeEnum.java
 *@author zouwenyan
 *2019年12月18日 下午5:43:20
 */
package com.jorge.testui.enums;

import com.acooly.core.utils.enums.Messageable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 * @category 功能描述
 * @createTime: 2019年12月18日 下午5:43:20
 * @author: <a href="mailto:653257103@qq.com">zouwenyan</a>
 * @version: 3.0
 * @updateTime: 2019年12月18日 下午5:43:20
 * @updateAuthor: <a href="mailto:653257103@qq.com">zouwenyan</a>
 * @changesSum: 
 */
public enum PaymentTypeEnum  implements Messageable {
    POS_PAY("POS_PAY", "POS支付"),
    CARD_PAY("CARD_PAY", "摆牌支付"),
    ONE_CODE_PAY("ONE_CODE_PAY","一码付支付"),
    WECHAT_SCAN_CODE_PAY("WECHAT_SCAN_CODE_PAY","微信扫码支付（主扫）"),
    WECHAT_BAR_CODE_PAY("WECHAT_BAR_CODE_PAY","微信条码支付（被扫）"),
    WECHAT_PUBLIC_PAY("WECHAT_PUBLIC_PAY", "微信公众号支付"),
    WECHAT_WEB_PAY("WECHAT_WEB_PAY", "微信小程序支付"),
    WECHAT_APP_PAY("WECHAT_APP_PAY", "微信APP支付"),
    ALI_APP_PAY("ALI_APP_PAY", "支付宝APP支付"),
    ALI_LIFE_PAY("ALI_LIFE_PAY","支付宝服务窗支付"),
    ALI_SCAN_CODE_PAY("ALI_SCAN_CODE_PAY","支付宝扫码支付（主扫）"),
    ALI_BAR_CODE_PAY("ALI_BAR_CODE_PAY","支付宝条码支付（被扫）"),
    QUICK_PAY("QUICK_PAY","快捷支付"),
    OFFLINE_PAY("OFFLINE_PAY","线下支付"),
    GATEWAY_PAY("GATEWAY_PAY","网关支付"),;

    private final String code;
    private final String message;

    private PaymentTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    public static Map<String, String> mapping() {
        Map<String, String> map = new LinkedHashMap<String, String>();
        for (PaymentTypeEnum type : values()) {
            map.put(type.getCode(), type.getMessage());
        }
        return map;
    }

    /**
     * 通过枚举值码查找枚举值。
     *
     * @param code 查找枚举值的枚举值码。
     * @return 枚举值码对应的枚举值。
     * @throws IllegalArgumentException 如果 code 没有对应的 Status 。
     */
    public static PaymentTypeEnum find(String code) {
        for (PaymentTypeEnum status : values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举值。
     *
     * @return 全部枚举值。
     */
    public static List<PaymentTypeEnum> getAll() {
        List<PaymentTypeEnum> list = new ArrayList<PaymentTypeEnum>();
        for (PaymentTypeEnum status : values()) {
            list.add(status);
        }
        return list;
    }

    /**
     * 获取全部枚举值码。
     *
     * @return 全部枚举值码。
     */
    public static List<String> getAllCode() {
        List<String> list = new ArrayList<String>();
        for (PaymentTypeEnum status : values()) {
            list.add(status.code());
        }
        return list;
    }

}

