package com.jorge.testui.enums;

import com.acooly.core.utils.enums.Messageable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum MusGwStatusEnum implements Messageable {
	
	/** 初始状态 */
	IT("IT", "初始状态"),
	
	/** 发送失败*/
	UF("UF", "发送银行失败"),

	/** 发送银行中 */
	UD("UD", "发送银行中"),
	
	/** 已发送银行*/
	US("US", "已发送银行"),
	
	/** 银行成功*/
	BS("BS", "银行成功"),
	
	/** 银行最终失败 */
	OF("OF", "银行最终失败"),
	
	/** 银行失败 */
	BF("BF", "银行失败"),
	
	/** 银行处理中*/
	BP("BP", "银行处理中"),
	
	/** 银行可疑，须人工介入*/
	BE("BE", "银行可疑，须人工介入"),

	/**	银行返回信息为空 */
	BANK_RTN_NULL("BANK_RTN_NULL", "银行返回信息为空"),

	/**	异常 */
	EXCEPTION("EXCEPTION", "异常");

	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>CungwStatusEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private MusGwStatusEnum(String code, String message) {
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
	 * @return CungwStatusEnum
	 */
	public static MusGwStatusEnum getByCode(String code) {
		for (MusGwStatusEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}

	public static Map<String, String> mapping() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (MusGwStatusEnum type : values()) {
			map.put(type.getCode(), type.getMessage());
		}
		return map;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<CungwStatusEnum>
	 */
	public List<MusGwStatusEnum> getAllEnum() {
		List<MusGwStatusEnum> list = new ArrayList<MusGwStatusEnum>();
		for (MusGwStatusEnum _enum : values()) {
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
		for (MusGwStatusEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	/**
	 * 判断给定的枚举，是否在列表中
	 *
	 * @param value 检查的值
	 * @param values 列表
	 * @return
	 */
	public boolean isInList(MusGwStatusEnum value, MusGwStatusEnum... values) {
		for (MusGwStatusEnum e : values) {
			if (value == e) {
				return true;
			}
		}
		return false;
	}
}
