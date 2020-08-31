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
 * mock_sign_info Entity
 *
 * @author mufanglin
 * @date 2019-12-30 15:24:40
 */
@Entity
@Table(name = "mock_sign_info")
@Getter
@Setter
public class MockSignInfo extends AbstractEntity {
	
	/**
	 * serialVersionUID
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	 * mock业务流水号(业务层银行流水号)
	 */
	private String				mockOrderNo;
	
	/**
	 * 业务层通知mock订单号(如通知银行)-orderId
	 */
	private String				bizOrderNo;
	
	/**
	 * 手机号
	 */
	private String				mobileNo;
	
	/**
	 * 真实姓名
	 */
	private String				realName;
	
	/**
	 * 银行卡号
	 */
	private String				bankCardNo;
	
	/**
	 * 证件号
	 */
	private String				certNo;
	
	/**
	 * 证件类型
	 */
	private String				certType;
	
	/**
	 * 银行00,存折01,信用卡02
	 */
	private String				accountType;
	
	/**
	 * 备注(显示错误信息、备注等信息)
	 */
	private String				memo;
	
	/**
	 * 短信验证码
	 */
	private String				validateCode;
	
	/**
	 * 版本号
	 */
	private String				version;
	
	/**
	 * 业务流水状态 {INIT:初始化,PROCESSING:处理中,SUCCESS:成功,FAIL:失败}
	 */
	private String				mockStatus;
	
	private String				userId;
	
	private String				outUserId;
	
	private String				partnerId;
	
	private String				mockNotifyStatus;
	
	private int					mockNotifyCount;
	
	/**
	 * 创建时间
	 */
	private Date				createTime			= new Date();
	
	/**
	 * 修改时间
	 */
	private Date				updateTime			= new Date();
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
