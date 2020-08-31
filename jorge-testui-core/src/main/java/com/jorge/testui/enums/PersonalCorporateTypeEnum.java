package com.jorge.testui.enums;

/*
 *
 * 修订记录：
 * zeyong 2014-3-27 下午6:20:48 创建
 */

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 账号类型枚举值 <br>
 * 1.<code>CORPORATE</code>:对公. <br>
 * 2.<code>PERSONAL</code>:对私.
 *
 * @author zeyong
 */
public enum PersonalCorporateTypeEnum {

    /**
     * 对私
     */
    PERSONAL("PERSONAL", "对私"),

    /**
     * 对公
     */
    CORPORATE("CORPORATE", "对公"),

    /**
     * 对公对私
     */
    ALL("ALL", "对公对私");


    /**
     * 枚举值
     */
    private final String code;

    /**
     * 枚举描述
     */
    private final String message;

    /**
     * 构造一个<code>InstAccountTypeEnum</code>枚举对象
     *
     * @param code
     * @param message
     */
    private PersonalCorporateTypeEnum(String code, String message) {
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
     * @return InstAccountTypeEnum
     */
    public static PersonalCorporateTypeEnum getByCode(String code) {
        for (PersonalCorporateTypeEnum _enum : values()) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     *
     * @return List<InstAccountTypeEnum>
     */
    public static List<PersonalCorporateTypeEnum> getAllEnum() {
        List<PersonalCorporateTypeEnum> list = new ArrayList<PersonalCorporateTypeEnum>();
        for (PersonalCorporateTypeEnum _enum : values()) {
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
        for (PersonalCorporateTypeEnum _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    public static Map<String, String> mapping() {
        Map<String, String> map = Maps.newLinkedHashMap();
        for (PersonalCorporateTypeEnum type : values()) {
            map.put(type.getCode(), type.getMessage());
        }
        return map;
    }

    /**
     *
     * @param msg
     * @return SwichStatusEnum
     */
    public static PersonalCorporateTypeEnum getByMsg(String msg)throws Exception{
        PersonalCorporateTypeEnum personalCorporateTypeEnum = null;

        for (PersonalCorporateTypeEnum _enum : values()) {
            if (_enum.getMessage().equals(msg)) {
                personalCorporateTypeEnum =  _enum;
                break;
            }
        }
        if(personalCorporateTypeEnum == null){
            throw  new Exception("账户类型不能为空");
        }
        return personalCorporateTypeEnum;
    }
}