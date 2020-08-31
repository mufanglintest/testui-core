package com.jorge.testui.enums;

import com.acooly.core.utils.enums.Messageable;

/**
 * @Author ck.wu
 * @Email 506093826@qq.com
 * @History create 2020/05/07 13:57
 */
public enum ResultCodeEnum implements Messageable {
	
	BOSS_AUTH_REVIEW_ERROR("BOSS_AUTH_REVIEW_ERROR", "BOSS实名审核未通过"),
	INVAILD_PARAMETER("INVAILD_PARAMETER", "请求参数不完整"),
	PARAMETER_ERROR("PARAMETER_ERROR", "请求参数错误"),
	ORDERNO_ALREADY_EXISTS("ORDERNO_ALREADY_EXISTS", "已经存在的订单号"),
	ORDER_ALREADY_SUCCESS("ORDER_ALREADY_SUCCESS", "重复支付,此订单号已成功"),
	ORDER_ALREADY_FINISH("ORDER_ALREADY_FINISH", "不能支付,此订单已完结"),
	POS_STATUS_ERROR("POS_STATUS_ERROR", "pos非法状态"),
	ORDERNO_NOT_EXISTS("ORDERNO_NOT_EXISTS", "不存在的订单号"),
	ORDER_STATUS_ERROR("ORDER_STATUS_ERROR", "订单状态非法"),
	ORDER_STATUS_OVERDUE("ORDER_STATUS_OVERDUE", "订单已过期"),
	ORDERNO_NOT_SUPPORT_PROFIT("ORDERNO_NOT_SUPPORT_PROFIT", "订单清分类型为自动，不支持手动清分"),
	ORDERNO_NOT_RECON("ORDERNO_NOT_RECON", "订单没有对账,暂时无法清分"),
	FREEZE_BALANCE_NOT_ENOUGH("FREEZE_BALANCE_NOT_ENOUGH", "账户冻结余额不足"),
	BALANCE_NOT_ENOUGH("BALANCE_NOT_ENOUGH", "账户余额不足"),
	USER_NOT_BELONG_TO_OPERATOR("USER_NOT_BELONG_TO_OPERATOR", "用户不属于指定运营商"),
	USER_BANKCARD_STATUS_ERROR("USER_BANKCARD_STATUS_ERROR", "用户银行卡状态非法"),
	USER_STATUS_ERROR("USER_STATUS_ERROR", "用户状态非法"),
	USER_PAYMENT_STATUS_ERROR("USER_PAYMENT_STATUS_ERROR", "用户进件状态非法"),
	ACCOUNT_STATUS_ERROR("ACCOUNT_STATUS_ERROR", "账户状态非法"),
	ACCOUNT_NOT_EXIST("ACCOUNT_NOT_EXIST", "账户不存在"),
	ACCOUNT_TRANSFER_NOT_CROSS_OPERATOR("ACCOUNT_TRANSFER_NOT_CROSS_OPERATOR", "转账不能跨运营商"),
	GATEWAY_ERROR("GATEWAY_ERROR", "支付网关异常"),
	DB_EXCEPTION("DB_EXCEPTION", "数据库异常"),
	REMOTE_EXCEPTION("REMOTE_EXCEPTION", "远程系统异常"),
	EVENT_ALREADY_EXISTS("EVENT_ALREADY_EXISTS", "事件已存在"),
	MODEL_EVENT_NOEXISTS("MODEL_EVENT_NOEXISTS", "模型事件不存在"),
	MODEL_SECTION_NOEXISTS("MODEL_SECTION_NOEXISTS", "模型场景不存在"),
	PROFIT_TRADE_EXISTS("PROFIT_TRADE_EXISTS", "清分已存在"),
	PROFIT_TRADE_STATUS_UNSORPPORT("PROFIT_TRADE_STATUS_UNSORPPORT", "不支持的清分状态"),
	PROFIT_TRADE_RULE_NO_HAS_ACCOUNT("PROFIT_TRADE_RULE_NO_HAS_ACCOUNT", "角色未找到资金账户"),
	PROFIT_TRADE_ACCOUNT_EXCEPTION("PROFIT_TRADE_ACCOUNT_EXCEPTION", "账务异常"),
	UNKOWN_EXCEPTION("UNKOWN_EXCEPTION", "系统未知异常"),
	ALREADY_ROLLBACK("ALREADY_ROLLBACK", "订单已回滚"),
	DATA_DONOT_EXISTS("DATA_DONOT_EXISTS", "数据不存在"),
	DAILYTOTAL_ERROR("DAILYTOTAL_ERROR", "当日总笔数超过限制"),
	DAILYMONEY_ERROR("DAILYMONEY_ERROR", "当日总金额超过限制"),
	MONTHLYTOTAL_ERROR("MONTHLYTOTAL_ERROR", "当月总笔数超过限制"),
	MONTHLYMONEY_ERROR("MONTHLYMONEY_ERROR", "当月总金额超过限制"),
	SINGLEMONEYMIN_ERROR("SINGLEMONEYMIN_ERROR", "单笔金额低于最小限制"),
	SINGLEMONEYMAX_ERROR("SINGLEMONEYMAX_ERROR", "单笔金额超过最大限制"),
	BLACKLIST_USER("BLACKLIST_USER", "黑名单用户无法操作"),
	ROUTE_EXCEPTION("ROUTE_EXCEPTION", "路由异常"),
	ABORTBIZ_EXCEPTION("ABORTBIZ_EXCEPTION", "终止后面业务执行异常"),
	BACKMONEY_EXCEPTION("BACKMONEY_EXCEPTION", "备付金不足"),
	TRANSQUERY_EXCEPTION("TRANSQUERY_EXCEPTION", "交易查询成功"),
	TRANSQUERY_CORENO_EXCEPTION("TRANSQUERY_CORENO_EXCEPTION", "核心流水号为空"),
	TRANSQUERY_ISNULL_EXCEPTION("TRANSQUERY_ISNULL_EXCEPTION", "交易查询结果为空"),
	TIME_OUT("TIME_OUT", "通讯响应超时"),
	PARAMETER_EXCEPTION("PARAMETER_EXCEPTION", "业务参数异常"),
	ROUT_BIZ_SHUT("ROUT_BIZ_SHUT", "路由业务终于"),
	CHNELLNULL_EXCEPTION("CHNELLNULL_EXCEPTION", "无可用渠道异常"),
	EXECUTE_SUCCESS("EXECUTE_SUCCESS", "成功"),
	EXECUTE_PROCESSING("EXECUTE_PROCESSING", "处理中"),
	EXECUTE_FAIL("EXECUTE_FAIL", "失败");
	
	private String code;
	private String message;
	
	private ResultCodeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	
	
	
	public String getCode() {
		return this.code;
	}
	
	public String code() {
		return this.code;
	}
	
	public String message() {
		return this.message;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static ResultCodeEnum byCode(String code) {
		ResultCodeEnum[] var4;
		int var3 = (var4 = values()).length;
		
		for(int var2 = 0; var2 < var3; ++var2) {
			ResultCodeEnum enums = var4[var2];
			if(code.equalsIgnoreCase(enums.getCode())) {
				return enums;
			}
		}
		
		return null;
	}
}
