package com.jorge.testui.enums;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ouwen@yiji.com} on 2017/3/24.
 */
public enum NotifyStatusEnum {

    /**
     * 未通知:N
     */
    NO("NO", "未通知"),

    /**
     * 通知中:D
     */
    DOING("DOING", "通知中"),

    /**
     * 已经通知:S
     */
    SUCCESS("SUCCESS", "已经通知"),

    /**
     * 通知失败，不重发:F
     */
    FAIL("FAIL", "通知失败"),

    /**
     * 通知失败，但是要重发:R
     */
    RETRY("RETRY", "重发通知失败");

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
    private NotifyStatusEnum(String code, String message) {
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
    public static NotifyStatusEnum getByCode(String code) {
        for (NotifyStatusEnum _enum : values()) {
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
    public List<NotifyStatusEnum> getAllEnum() {
        List<NotifyStatusEnum> list = new ArrayList<NotifyStatusEnum>();
        for (NotifyStatusEnum _enum : values()) {
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
        for (NotifyStatusEnum _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    public boolean isInList(NotifyStatusEnum... enums) {
        for (NotifyStatusEnum _enum : enums) {
            if (this == _enum) {
                return true;
            }
        }
        return false;
    }

    public static Map<String, String> mapping() {
        Map<String, String> map = Maps.newLinkedHashMap();
        for (NotifyStatusEnum type : values()) {
            map.put(type.getCode(), type.getMessage());
        }
        return map;
    }
}
