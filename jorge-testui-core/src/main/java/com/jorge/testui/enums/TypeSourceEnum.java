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
 * @Filename TypeSourceEnum.java
 *
 * @Description
 *
 * @Author ck.wu
 * @Email 506093826@qq.com
 * @Version 1.0
 * @History 2019年3月8日 下午3:45:32
 *
 */
public enum TypeSourceEnum {

    CHI_WECHAT_WEB_PAY("CHI_WECHAT_WEB_PAY", "银联微信小程序支付"),
    CHI_WECHAT_WEB_PAY_REFUND("CHI_WECHAT_WEB_PAY_REFUND", "银联微信小程序退款"),
    FM_TRADE_REFUND("FM_TRADE_REFUND", "富民交易退款"),

    BALANCE_PAY("BALANCE_PAY", "余额支付"),
    BALANCE_PAY_REFUND("BALANCE_PAY_REFUND", "余额支付退款"),

    Sign("Sign", "签约"),

    CREDIT_INSTALMENT_PAY("CREDIT_INSTALMENT_PAY", "信用卡支付"),
    CREDIT_INSTALMENT_PAY_CANCEL_BACK("CREDIT_INSTALMENT_PAY_CANCEL_BACK", "信用卡支付撤销退货"),

    BAI_TIAO_PAY("BAI_TIAO_PAY", "白条支付"),
    BAI_TIAO_PAY_CONFIRM("BAI_TIAO_PAY_CONFIRM", "白条支付确认"),
    BAI_TIAO_PAY_INDEXPAGE("BAI_TIAO_PAY_INDEXPAGE", "白条URL查询"),
    BAI_TIAO_PAY_QUOTA("BAI_TIAO_PAY_QUOTA", "白条额度查询"),
    BAI_TIAO_PAY_OVERDUE("BAI_TIAO_PAY_OVERDUE", "白条逾期查询"),

    BLING_BAI_TIAO_PAY("BLING_BAI_TIAO_PAY", "白凌白条支付"),
    BLING_BAI_TIAO_BACK("BLING_BAI_TIAO_BACK", "白凌白条退款"),
    
    FM_WITHDRAW_CAR("FM_WITHDRAW_CAR", "抢车代付"),
    
    FM_II_WITHDRAW("FM_II_WITHDRAW", "富民II户代付"),
    
    
    ;


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
    private TypeSourceEnum(String code, String message) {
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
    public static TypeSourceEnum getByCode(String code) {
        for (TypeSourceEnum _enum : values()) {
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
    public List<TypeSourceEnum> getAllEnum() {
        List<TypeSourceEnum> list = new ArrayList<TypeSourceEnum>();
        for (TypeSourceEnum _enum : values()) {
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
        for (TypeSourceEnum _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    public boolean isInList(TypeSourceEnum... enums) {
        for (TypeSourceEnum _enum : enums) {
            if (this == _enum) {
                return true;
            }
        }
        return false;
    }

    public static Map<String, String> mapping() {
        Map<String, String> map = Maps.newLinkedHashMap();
        for (TypeSourceEnum type : values()) {
            map.put(type.getCode(), type.getMessage());
        }
        return map;
    }
}
