package com.jorge.testui.enums;


import com.google.common.collect.Maps;

import java.util.Map;

public enum TransStatusEnum {

    /**
     * 初始状态 (清算入库时的状态)
     */
    INITIAL("IT", "初始状态"),

    /**
     * 清算成功 (清算过程走完没出现任何问题，异步处理时网关返回接收成功)
     */
    SETTLE_SUCCESS("SS", "清算成功"),

    /**
     * 清算失败 (清算过程中出现错误，如无法发送网关，未找到渠道号等)
     */
    SETTLE_FAIL("SF", "清算失败"),

    /**
     * 异步清算 (异步清算)
     */
    ASYN_SETTLE("AS", "异步清算"),

    /**
     * 清算过程中 (清算过程中的状态，从发送网关开始，到网关返回结果之前的状态)
     */
    SETTLE_DOING("SD", "清算过程中"),

    /**
     * 银行成功 (将清算发送给网关，网关返回银行的处理结果为成功)
     */
    BANK_SUCCESS("BS", "银行成功"),

    /**
     * 银行失败 (将清算发送给网关，网关返回银行的处理结果为失败)
     */
    BANK_FAIL("BF", "银行失败"),

    /**
     * 网银表单申请成功  *
     */
    FORM_SUCCESS("FS", "网银表单申请成功"),

    /**
     * 银行处理中 (将清算发送给网关，网关返回银行的处理结果为处理中)
     */
    BANK_PROCESSING("BP", "银行处理中"),

    /**
     * 已报网关
     */
    GATEWAY_DOING("GD", "已报网关"),

    /**
     * 网关失败
     */
    GATEWAY_FAIL("GF", "网关失败"),

    /**
     * 调用网关异常
     */
    GATEWAY_EXCEPTION("GE", "调用网关异常"),

    /**
     * 异步验证 (异步验证)
     */
    ASYN_VERIFY("AV", "异步验证"),
    /**
     * 验证中 (验证中)
     */
    VERIFY_DOING("VD", "验证中"),
    /**
     * 验证成功 (验证通过)
     */
    VERIFY_SUCCESS("VS", "验证成功"),
    /**
     * 解约状态
     */
    UNSIGN_SUCCESS("US", "解约成功"),
    /**
     * 验证失败 (验证不通过)
     */
    VERIFY_FAIL("VF", "验证失败"),
    /***
     * 数据加锁状态
     */
    DATA_LOCK("DL","加锁状态");

    /**
     * 枚举值
     */
    private final String code;

    /**
     * 枚举描述
     */
    private final String message;

    /**
     * @param code    枚举值
     * @param message 枚举描述
     */
    private TransStatusEnum(String code, String message) {
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
     * @return TransStatusEnum
     */
    public static TransStatusEnum getByCode(String code) {
        for (TransStatusEnum _enum : values()) {
            if (_enum.getCode().equalsIgnoreCase(code)) {
                return _enum;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     *
     * @return List<TransStatusEnum>
     */
    public static java.util.List<TransStatusEnum> getAllEnum() {
        java.util.List<TransStatusEnum> list = new java.util.ArrayList<TransStatusEnum>(
                values().length);
        for (TransStatusEnum _enum : values()) {
            list.add(_enum);
        }
        return list;
    }

    /**
     * 获取全部枚举值
     *
     * @return List<String>
     */
    public static java.util.List<String> getAllEnumCode() {
        java.util.List<String> list = new java.util.ArrayList<String>(values().length);
        for (TransStatusEnum _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 通过code获取msg
     *
     * @param code 枚举值
     * @return
     */
    public static String getMsgByCode(String code) {
        if (code == null) {
            return null;
        }
        TransStatusEnum _enum = getByCode(code);
        if (_enum == null) {
            return null;
        }
        return _enum.getMessage();
    }

    /**
     * 获取枚举code
     *
     * @param _enum
     * @return
     */
    public static String getCode(TransStatusEnum _enum) {
        if (_enum == null) {
            return null;
        }
        return _enum.getCode();
    }

    public boolean isInList(TransStatusEnum... enums) {
        for (TransStatusEnum _enum : enums) {
            if (this == _enum) {
                return true;
            }
        }
        return false;
    }

    public static Map<String, String> mapping() {
        Map<String, String> map = Maps.newLinkedHashMap();
        for (TransStatusEnum type : values()) {
            map.put(type.getCode(), type.getMessage());
        }
        return map;
    }
}

