package com.jorge.testui.selenium.enums;
/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2019-12-11 11:20
 */

import com.acooly.core.utils.enums.Messageable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum SelectorEnum implements Messageable {
    id("id","id"),
    name("name","name"),
    xpath("xpath","xpath"),
    linkText("linkText","linkText"),
    className("className","className"),
    tagName("tagName","tagName"),
    partialLinkText("partialLinkText","partialLinkText")
    ;
    private final String code;
    private final String message;

    SelectorEnum(String code, String message) {
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
        for (SelectorEnum type : values()) {
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
    public static SelectorEnum find(String code) {
        for (SelectorEnum status : values()) {
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
    public static List<SelectorEnum> getAll() {
        List<SelectorEnum> list = new ArrayList<SelectorEnum>();
        for (SelectorEnum status : values()) {
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
        for (SelectorEnum status : values()) {
            list.add(status.code());
        }
        return list;
    }

}
