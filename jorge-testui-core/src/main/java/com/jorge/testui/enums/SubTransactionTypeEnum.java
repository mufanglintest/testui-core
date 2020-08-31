package com.jorge.testui.enums;

/*
 *
 * 修订记录：
 * zeyong 2014-3-27 下午6:31:36 创建
 */

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import com.qzt.notifymock.musfinance.base.enums.TransactionTypeEnum;

/**
 * 资金渠道业务类型枚举值：<br>
 * 0.<code>DEFAULT</code>:默认.<br>
 * 1.<code>ONLINEBANK</code>:网银.<br>
 * 2.<code>DEDUCT</code>:代扣.<br>
 *
 * @author zeyong
 */
public enum SubTransactionTypeEnum {

    /**
     * 默认，没有子交易类型的，默认为此值
     */
    DEFAULT("00", "DEFAULT", "默认"),


    /**
     * 网银
     */
    ONLINEBANK("03", "ONLINEBANK", "网银"),
    /**
     * 网银 form表单
     */
    ONLINEBANK_FROM("04", "ONLINEBANK_FROM", "网银表单"),

    /**
     * 代扣
     */
    DEDUCT("05", "DEDUCT", "代扣"),

    /**
     * 提现
     */
    WITHDRAW("06", "WITHDRAW", "提现"),

    /**
     * 余额查询
     */
    QUERYBALANCE("07","QUERYBALANCE","余额查询"),

    /**
     * 网银 微信公众号支付
     */
    WX_PUBLIC_PAY("08" , "WX_PUBLIC_PAY" , "微信公众号支付"),

    /**
     * 网银 微信app支付
     */
    WX_APP_PAY("09","WX_APP_PAY","微信app支付"),

    /**
     * 网银 微信H5支付
     */
    WX_H5_PAY("18","WX_H5_PAY","微信H5支付"),

    /**
     * 网银 支付宝APP支付
     */
    ALIPAY_APP_PAY("10","ALIPAY_APP_PAY","支付宝APP支付"),

    /**
     * 网银 支付宝网页支付
     */
    ALIPAY_WEB_PAY("11","ALIPAY_WEB_PAY","支付宝网页支付"),

    /**
     * 网银 支付宝PC支付
     */
    ALIPAY_PC_PAY("12","ALIPAY_PC_PAY","支付宝PC支付"),
    /**
     * 网银 微信扫描支付
     */
    SCANCODE_WXPAY("13","SCANCODE_WXPAY","微信扫描支付"),
    /**
     * 网银 微信反扫支付
     */
    SCANCODEED_WXPAY("14","SCANCODEED_WXPAY","微信反扫支付"),
    /**
     * 网银 支付宝扫描支付
     */
    SCANCODE_ALPPAY("15","SCANCODE_ALPPAY","支付宝扫描支付"),
    /**
     * 网银 支付宝反扫支付
     */
    SCANCODEED_ALPPAY("16","SCANCODEED_ALPPAY","支付宝反扫支付"),
    /**
     * 网银 线下打款
     */
    OFFLINE_PAY("17","OFFLINE_PAY","线下打款");
    /**
     * 编号
     */
    private final String number;

    /**
     * 名称
     */
    private final String code;

    /**
     * 枚举描述
     */
    private final String message;

    /**
     * 构造一个<code>SubTransactionTypeEnum</code>枚举对象
     *
     * @param number  : 数字编号
     * @param code    : 英文编码
     * @param message : 中文描述
     */
    private SubTransactionTypeEnum(String number, String code, String message) {
        this.number = number;
        this.code = code;
        this.message = message;
    }

    /**
     * @return Returns the 英文编码.
     */
    public String getCode() {
        return code;
    }

    /**
     * @return Returns the 英文编码.
     */
    public String code() {
        return code;
    }

    /**
     * @return Returns the 中文描述.
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return Returns the 中文描述.
     */
    public String message() {
        return message;
    }

    /**
     * @return Returns the 数字编号.
     */
    public String getNumber() {
        return number;
    }

    /**
     * @return Returns the 数字编号.
     */
    public String number() {
        return number;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     *
     * @param code
     * @return SubTransactionTypeEnum
     */
    public static SubTransactionTypeEnum getByCode(String code) {
        for (SubTransactionTypeEnum _enum : values()) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

    /**
     *
     * @param msg
     * @return SwichStatusEnum
     */
    public static SubTransactionTypeEnum getByMsg(String msg) throws Exception{
        SubTransactionTypeEnum subTransactionTypeEnum = null;
        for (SubTransactionTypeEnum _enum : values()) {
            if (_enum.getMessage().equals(msg)) {
                subTransactionTypeEnum =  _enum;
                break;
            }
        }
        if(subTransactionTypeEnum == null){

            throw new Exception("子交易类型不能为空");
        }
        return subTransactionTypeEnum;
    }

    /**
     * 通过枚举<code>number</code>获得枚举
     *
     * @param number
     * @return SubTransactionTypeEnum
     */
    public static SubTransactionTypeEnum getByNumber(String number) {
        for (SubTransactionTypeEnum _enum : values()) {
            if (_enum.getNumber().equals(number)) {
                return _enum;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     *
     * @return List<SubTransactionTypeEnum>
     */
    public static List<SubTransactionTypeEnum> getAllEnum() {
        List<SubTransactionTypeEnum> list = new ArrayList<SubTransactionTypeEnum>();
        for (SubTransactionTypeEnum _enum : values()) {
            list.add(_enum);
        }
        return list;
    }

    /**
     * 获取全部枚举值
     *
     * @return List<String>
     */
    public static List<String> getAllEnumCode() {
        List<String> list = new ArrayList<String>();
        for (SubTransactionTypeEnum _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

//    public static List<SubTransactionTypeEnum> getByTransactionType(TransactionTypeEnum transactionType) {
//        List<SubTransactionTypeEnum> list = new ArrayList<SubTransactionTypeEnum>();
//        for (SubTransactionTypeEnum _enum : values()) {
//            if (_enum.getNumber().startsWith(transactionType.getNumber()) || _enum.getNumber().startsWith("0")) {
//                list.add(_enum);
//            }
//        }
//        return list;
//    }

    public static Map<String, String> mapping() {
        Map<String, String> map = Maps.newLinkedHashMap();
        for (SubTransactionTypeEnum type : values()) {
            map.put(type.getCode(), type.getMessage());
        }
        return map;
    }
}
