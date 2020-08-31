/*
 * ouwen@yiji.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 * create by ouwen
 * date:2017-03-30
 *
 */
package com.jorge.testui.enums;

import com.acooly.core.utils.enums.Messageable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * transaction_withdraw ReviewStatus 枚举定义
 * 
 * @author ouwen
 * Date: 2017-03-30 23:04:59
 */
public enum ReviewStatus implements Messageable {

		UNREVIEW("UNREVIEW", "未审核"),
		REVIEW_SUCCESS("REVIEW_SUCCESS", "审核通过"),
		REVIEW_FAIL("REVIEW_FAIL", "审核不通过"),
		REVIEWING("REVIEWING", "审核中"),
	;

	private final String code;
	private final String message;

	private ReviewStatus(String code, String message) {
		this.code = code;
		this.message = message;
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

	public static Map<String, String> mapping() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (ReviewStatus type : values()) {
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
	public static ReviewStatus find(String code) {
		for (ReviewStatus status : values()) {
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
	public static List<ReviewStatus> getAll() {
		List<ReviewStatus> list = new ArrayList<ReviewStatus>();
		for (ReviewStatus status : values()) {
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
		for (ReviewStatus status : values()) {
			list.add(status.code());
		}
		return list;
	}

}
