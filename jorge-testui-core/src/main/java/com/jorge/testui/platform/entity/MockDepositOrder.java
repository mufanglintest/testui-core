/*
* mufl.com Inc.
* Copyright (c) 2019 All Rights Reserved.
* create by mufanglin
* date:2019-12-30
*/
package com.jorge.testui.platform.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.JSON;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import com.acooly.core.common.domain.AbstractEntity;
import java.util.Date;

/**
 * 充值交易订单表 Entity
 *
 * @author mufanglin
 * @date 2019-12-30 15:24:40
 */
@Entity
@Table(name = "mock_deposit_order")
@Getter
@Setter
public class MockDepositOrder extends AbstractEntity {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * mock业务流水号(业务层银行流水号)
	 */
	private String mockOrderNo;
	
	/**
	 * 业务层通知mock订单号(如通知银行)-orderId
	 */
	private String bizOrderNo;
	
	/**
	 * 充值金额
	 */
	private Long amount = 0l;
	
	/**
	 * 充值成功金额
	 */
	private Long sucAmount = 0l;
	
	/**
	 * 门店号
	 */
	private String mchId;
	
	/**
	 * 门店key
	 */
	private String mchKey;
	
	/**
	 * 商品描述
	 */
	private String goodsMemo;
	
	/**
	 * 分期期数
	 */
	private String instalments;
	
	/**
	 * 跳转地址（通知业务层）
	 */
	private String jumpUrl;
	
	/**
	 * 异步通知回来地址(如商户通知网关地址)
	 */
	private String notifyUrl;
	
	/**
	 * 返回地址(商户返回网关地址)
	 */
	private String returnUrl;
	
	/**
	 * 业务订单发生日期 YYYY-MM-DD(如业务发送银行日期)
	 */
	private String trade_date;
	
	/**
	 * 业务订单发生时间 HH:mm:ss(如银行返回清算时日期)
	 */
	private String trade_time;
	
	/**
	 * 用户ID
	 */
	private String userId;
	
	/**
	 * 用户端IP
	 */
	private String userEndIp;
	
	/**
	 * 付款用户所在银行ID
	 */
	private String payBankId;
	
	/**
	 * 付款用户的银行卡号
	 */
	private String payBankAccount;
	
	/**
	 * 付款用户姓名
	 */
	private String payAccountName;
	
	/**
	 * 客户对公账户客户号
	 */
	private String payAccountCustNo;
	
	/**
	 * 用户证件类型
	 */
	private String payUserCertType;
	
	/**
	 * 用户证件号码
	 */
	private String payUserCertNo;
	
	/**
	 * 支付用户手机号
	 */
	private String payUserMobile;
	
	/**
	 * 收款方的账户卡号
	 */
	private String recBankAccount;
	
	/**
	 * 收款方所在银行的英文简称
	 */
	private String recBankId;
	
	/**
	 * 收款方的账户名
	 */
	private String recBankAccountName;
	
	/**
	 * 收款方所在银行的中文全称
	 */
	private String recBankName;
	
	/**
	 * 订单流水查询通知状态
	 */
	private String mockNotifyStatus;
	
	/**
	 * 订单流水处理通知次数
	 */
	private Integer mockNotifyCount = 0;
	
	/**
	 * 交易代码
	 */
	private String trxCode;
	
	/**
	 * 用户密码
	 */
	private String userPass;
	
	/**
	 * 处理级别
	 */
	private int level;
	
	/**
	 * 数据格式
	 */
	private String dataType;
	
	/**
	 * 版本号
	 */
	private String version;
	
	/**
	 * 商户号
	 */
	private String merchantId;
	
	/**
	 * 业务代码
	 */
	private String businessCode;
	
	/**
	 * 自定义用户号
	 */
	private String custUserid;
	
	/**
	 * 业务发生时间 YYYY-MM-DD HH:mm:ss
	 */
	private String businessTime;
	
	/**
	 * 账户属性(对公1、对私0)
	 */
	private String payBankType;
	
	/**
	 * 付款人用户名
	 */
	private String payUserName;
	
	/**
	 * 付款人银行编码
	 */
	private String payBankCode;
	
	/**
	 * 付款人币种
	 */
	private String payBankCurrency;
	
	/**
	 * 业务处理状态
	 */
	private String mockStatus;
	
	/**
	 * 付款方终端IP
	 */
	private String payEndIp;
	
	/**
	 * 付款方id
	 */
	private String payUserId;
	
	/**
	 * 应用ID
	 */
	private String appId;
	
	private String openId;
	
	/**
	 * 随机字符串
	 */
	private String randomStr;
	
	/**
	 * 交易方式
	 */
	private String payType;
	
	/**
	 * 签名
	 */
	private String sign;
	
	/**
	 * 交易来源
	 */
	private String typeSource;
	
	/**
	 * 退款原因
	 */
	private String refundReason;
	
	/**
	 * 退款流水号
	 */
	private String refundSerialNumber;
	
	/**
	 * 冲退类型
	 */
	private String refundType;
	
	/**
	 * 冲退状态
	 */
	private String refundStatus;
	
	/**
	 * 渠道方-业务ID
	 */
	private String keyServerId;
	
	/**
	 * 渠道方-秘钥
	 */
	private String secretKey;
	
	/**
	 * 确认状态(扩展)
	 */
	private String confirmStatus;
	
	/**
	 * 创建时间
	 */
	private Date createTime = new Date();
	
	/**
	 * 修改时间
	 */
	private Date updateTime = new Date();
	
	private String bankSerialNo;
	private String partnerId;
	private String gid;
	private String merchOrderNo;
	
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
