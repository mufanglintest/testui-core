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
 * @Filename MockStatusEnum.java
 *
 * @Description
 *
 * @Author ck.wu
 * @Email 506093826@qq.com
 * @Version 1.0
 * @History 2019年3月13日 下午3:55:58
 *
 */
public enum MockStatusEnum {

    /**
     * 初始化:INIT
     */
    INIT("INIT", "初始化"),

    /**
     * 处理中:PROCESSING
     */
    PROCESSING("PROCESSING", "处理中"),

    /**
     * 成功:SUCCESS
     */
    SUCCESS("SUCCESS", "成功"),

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
    private MockStatusEnum(String code, String message) {
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
    public static MockStatusEnum getByCode(String code) {
        for (MockStatusEnum _enum : values()) {
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
    public List<MockStatusEnum> getAllEnum() {
        List<MockStatusEnum> list = new ArrayList<MockStatusEnum>();
        for (MockStatusEnum _enum : values()) {
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
        for (MockStatusEnum _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    public boolean isInList(MockStatusEnum... enums) {
        for (MockStatusEnum _enum : enums) {
            if (this == _enum) {
                return true;
            }
        }
        return false;
    }

    public static Map<String, String> mapping() {
        Map<String, String> map = Maps.newLinkedHashMap();
        for (MockStatusEnum type : values()) {
            map.put(type.getCode(), type.getMessage());
        }
        return map;
    }
}
