package com.jorge.testui.enums;

import com.acooly.core.utils.enums.Messageable;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 核心支持报文协议
 *
 * <p>直接确定组装/反组装的实现
 *
 * @author zhangpu
 */
public enum CaseApiProtocol implements Messageable {
  /**
   * JSON报文
   */
  JSON("JSON", "JSON报文"),

  XML("XML", "XML报文");

  private final String code;
  private final String message;

  CaseApiProtocol(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public static Map<String, String> mapping() {
    Map<String, String> map = Maps.newLinkedHashMap();
    for (CaseApiProtocol type : values()) {
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
  public static CaseApiProtocol find(String code) {
    for (CaseApiProtocol status : values()) {
      if (status.getCode().equals(code)) {
        return status;
      }
    }
    throw new IllegalArgumentException("协议不合法:" + code);
  }

  /**
   * 获取全部枚举值。
   *
   * @return 全部枚举值。
   */
  public static List<CaseApiProtocol> getAll() {
    List<CaseApiProtocol> list = new ArrayList<CaseApiProtocol>();
    for (CaseApiProtocol status : values()) {
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
    for (CaseApiProtocol status : values()) {
      list.add(status.code());
    }
    return list;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public String code() {
    return code;
  }

  public String message() {
    return message;
  }
}
