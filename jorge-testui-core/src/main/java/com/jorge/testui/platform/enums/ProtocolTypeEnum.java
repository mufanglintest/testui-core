/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-07-16
 *
 */
package com.jorge.testui.platform.enums;

import com.acooly.core.utils.enums.Messageable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * test_case ProtocolTypeEnum 枚举定义
 * 
 * @author mufanglin
 * Date: 2019-07-16 16:08:56
 */
public enum ProtocolTypeEnum implements Messageable {

	HTTP("HTTP", "HTTP"),
	HTTPS("HTTPS", "HTTPS"),
	 SOCKET("SOCKET", "SOCKET"),
	;

	private final String code;
	private final String message;

	private ProtocolTypeEnum(String code, String message) {
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
		for (ProtocolTypeEnum type : values()) {
			map.put(type.getCode(), type.getMessage());
		}
		return map;
	}

	/**
	 * 通过枚举值码查找枚举值。
	 * 
	 * @param code
	 *            查找枚举值的枚举值码。
	 * @return 枚举值码对应的枚举值。
	 * @throws IllegalArgumentException
	 *             如果 code 没有对应的 Status 。
	 */
	public static ProtocolTypeEnum find(String code) {
		for (ProtocolTypeEnum status : values()) {
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
	public static List<ProtocolTypeEnum> getAll() {
		List<ProtocolTypeEnum> list = new ArrayList<ProtocolTypeEnum>();
		for (ProtocolTypeEnum status : values()) {
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
		for (ProtocolTypeEnum status : values()) {
			list.add(status.code());
		}
		return list;
	}

}
