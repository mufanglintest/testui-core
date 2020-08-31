/*
 * www.cnvex.cn

 Inc.
 * Copyright (c) 2018 All Rights Reserved.
 *                    _ooOoo_
 *                   o8888888o
 *                   88" . "88
 *                   (| -_- |)
 *                   O\  =  /O
 *                ____/`---'\____
 *              .'  \\|     |//  `.
 *             /  \\|||  :  |||//  \
 *            /  _||||| -:- |||||-  \
 *            |   | \\\  -  /// |   |
 *            | \_|  ''\---/''  |   |
 *            \  .-\__  `-`  ___/-. /
 *          ___`. .'  /--.--\  `. . __
 *       ."" '<  `.___\_<|>_/___.'  >'"".
 *      | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *      \  \ `-.   \_ __\ /__ _/   .-` /  /
 *  ======`-.____`-.___\_____/___.-`____.-'======
 *                     `=---='
 *  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *           佛祖保佑       永无测试遗漏
 */

package com.jorge.testui.mock.web.common.base;

import com.alibaba.fastjson.JSON;
import com.jorge.testui.platform.entity.MockDepositOrder;
import com.jorge.testui.platform.entity.MockSignInfo;
import com.jorge.testui.platform.entity.MockWithdrawOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @Filename MockOrderBase.java
 *
 * @Description
 *
 * @Author ck.wu
 * @Email 506093826@qq.com
 * @Version 1.0
 * @History 2019年4月1日 上午9:56:55
 *
 */
@Slf4j
@Service
public class MockRequestOrderBase extends MockBase {

	public void initFMFMPayWeixinJSOrder(String resString,
												MockDepositOrder mockDepositOrder) {
		if (resString != null) {
			resString = JSON.parseObject(resString).get("data").toString();
			String amount = JSON.parseObject(resString).get("amount") != null ?
					JSON.parseObject( JSON.parseObject(resString).get("amount").toString()).get("cent").toString() : "";
			String bizOrderNo = JSON.parseObject(resString).get("bizOrderNo") != null ? JSON.parseObject(resString).get("bizOrderNo").toString() : "";

			String goodsMemo = JSON.parseObject(resString).get("goodsMemo") != null ? JSON.parseObject(resString).get("goodsMemo").toString() : "";
			String mchCreateIp = JSON.parseObject(resString).get("mchCreateIp") != null ? JSON.parseObject(resString).get("mchCreateIp").toString() : "";
			String merchOrderNo = JSON.parseObject(resString).get("merchOrderNo") != null ? JSON.parseObject(resString).get("merchOrderNo").toString() : "";
			String partnerId = JSON.parseObject(resString).get("partnerId") != null ? JSON.parseObject(resString).get("partnerId").toString() : "";
			String gid = JSON.parseObject(resString).get("gid") != null ? JSON.parseObject(resString).get("gid").toString() : "";
			String recAccountNo = JSON.parseObject(resString).get("recAccountNo") != null ? JSON.parseObject(resString).get("recAccountNo").toString() : "";
			String subOpenid = JSON.parseObject(resString).get("subOpenid") != null ? JSON.parseObject(resString).get("subOpenid").toString() : "";

			mockDepositOrder.setAmount( amount == "" ? 0l: Long.valueOf(amount));
			mockDepositOrder.setBizOrderNo(bizOrderNo);
			mockDepositOrder.setGoodsMemo(goodsMemo);
			mockDepositOrder.setPartnerId(partnerId);
			mockDepositOrder.setMerchantId(merchOrderNo);
			mockDepositOrder.setAppId(subOpenid);
			mockDepositOrder.setGid(gid);
		}
	}

	public void initChinaumsWeixinAppServiceOrder(String request,
											MockDepositOrder mockDepositOrder) {
		String sortedMaps = request;
		if (sortedMaps != null) {
			String Str = sortedMaps.toString().substring(1);
			Str = Str.substring(0,Str.length()-2);
			com.alibaba.fastjson.JSONObject resString = JSON.parseObject(sortedMaps);
			resString = JSON.parseObject(resString.get("data").toString()) ;
			log.info(JSON.toJSONString(resString).toString());
			log.info(resString.toString());

			String instMid = resString.get("instMid")  != null ? resString.get("instMid") .toString() : "";
			String merOrderId = resString.get("merOrderId")  != null ? resString.get("merOrderId") .toString() : "";
			merOrderId = merOrderId.replace("3194","");
			String mid = resString.get("mid")  != null ? resString.get("mid") .toString() : "";
			String msgSrc = resString.get("msgSrc")  != null ? resString.get("msgSrc") .toString() : "";
			String msgType = resString.get("msgType")  != null ? resString.get("msgType") .toString() : "";
			String notifyUrl = resString.get("notifyUrl")  != null ? resString.get("notifyUrl") .toString() : "";
			String orderDesc = resString.get("orderDesc")  != null ? resString.get("orderDesc") .toString() : "";
			String requestTimestamp = resString.get("requestTimestamp")  != null ? resString.get("requestTimestamp") .toString() : "";
			String sign = resString.get("sign")  != null ? resString.get("sign") .toString() : "";
			String subAppId = resString.get("subAppId")  != null ? resString.get("subAppId") .toString() : "";
			String tid = resString.get("tid")  != null ? resString.get("tid") .toString() : "";
			String totalAmount = resString.get("totalAmount")  != null ? resString.get("totalAmount") .toString() : "";
			String tradeType = resString.get("tradeType")  != null ? resString.get("tradeType") .toString() : "";

			mockDepositOrder.setAmount( totalAmount == "" ? 0l: Long.valueOf(totalAmount));
			mockDepositOrder.setBizOrderNo(merOrderId);
			mockDepositOrder.setAppId(subAppId);
			mockDepositOrder.setMchId(mid);
			mockDepositOrder.setNotifyUrl(notifyUrl);
		}
	}

	public void initCpcnQuickPaymentServiceOrder(String request,
													 MockDepositOrder mockDepositOrder) {
		String sortedMaps = request;
		if (sortedMaps != null) {
			String Str = sortedMaps.toString().substring(1);
			Str = Str.substring(0,Str.length()-2);
			com.alibaba.fastjson.JSONObject resString = JSON.parseObject(sortedMaps);
			resString = JSON.parseObject(resString.get("data").toString()) ;
			log.info(JSON.toJSONString(resString).toString());
			log.info(resString.toString());

			String merOrderId = resString.get("paymentNo")  != null ? resString.get("paymentNo") .toString() : "";
			String mid = resString.get("merchantNo")  != null ? resString.get("merchantNo") .toString() : "";
			String notifyUrl = resString.get("notifyUrl")  != null ? resString.get("notifyUrl") .toString() : "";
			String subAppId = resString.get("subAppId")  != null ? resString.get("subAppId") .toString() : "";
			String totalAmount = resString.get("amount")  != null ? resString.get("amount") .toString() : "";

			mockDepositOrder.setAmount( totalAmount == "" ? 0l: Long.valueOf(totalAmount));
			mockDepositOrder.setBizOrderNo(merOrderId);
			mockDepositOrder.setAppId(subAppId);
			mockDepositOrder.setMchId(mid);
			mockDepositOrder.setNotifyUrl(notifyUrl);
		}
	}

	public void initChinaumsRefundServiceOrder(String request,
													 MockDepositOrder mockDepositOrder) {
		String sortedMaps = request;
		if (sortedMaps != null) {
			String Str = sortedMaps.toString().substring(1);
			Str = Str.substring(0,Str.length()-2);
			com.alibaba.fastjson.JSONObject resString = JSON.parseObject(sortedMaps);
			resString = JSON.parseObject(resString.get("data").toString()) ;
			log.info(JSON.toJSONString(resString).toString());
			log.info(resString.toString());

			String instMid = resString.get("instMid")  != null ? resString.get("instMid") .toString() : "";
			String merOrderId = resString.get("merOrderId")  != null ? resString.get("merOrderId") .toString() : "";
			merOrderId = merOrderId.replace("3194","");

			String msgSrc = resString.get("msgSrc")  != null ? resString.get("msgSrc") .toString() : "";
			String msgType = resString.get("msgType")  != null ? resString.get("msgType") .toString() : "";
			String notifyUrl = resString.get("notifyUrl")  != null ? resString.get("notifyUrl") .toString() : "";
			String orderDesc = resString.get("orderDesc")  != null ? resString.get("orderDesc") .toString() : "";
			String requestTimestamp = resString.get("requestTimestamp")  != null ? resString.get("requestTimestamp") .toString() : "";
			String sign = resString.get("sign")  != null ? resString.get("sign") .toString() : "";
			String subAppId = resString.get("subAppId")  != null ? resString.get("subAppId") .toString() : "";
			String tid = resString.get("tid")  != null ? resString.get("tid") .toString() : "";
			String totalAmount = resString.get("refundAmount")  != null ? resString.get("refundAmount") .toString() : "";
			String tradeType = resString.get("tradeType")  != null ? resString.get("tradeType") .toString() : "";


			String mid = resString.get("mid")  != null ? resString.get("mid") .toString() : "";
			String partner = resString.get("partner")  != null ? resString.get("partner") .toString() : "";
			String refundDesc = resString.get("refundDesc")  != null ? resString.get("refundDesc") .toString() : "";
			String refundOrderId = resString.get("refundOrderId")  != null ? resString.get("refundOrderId") .toString() : "";
			refundOrderId = refundOrderId.replace("3194","");


			if(JSON.parseObject(sortedMaps).get("service").toString().equals("ChinaumsRefundQueryService")){
				refundOrderId = resString.get("merOrderId")  != null ? resString.get("merOrderId") .toString() : "";
				refundOrderId = refundOrderId.replace("3194","");
			}

			mockDepositOrder.setAmount( totalAmount == "" ? 0l: Long.valueOf(totalAmount));
			mockDepositOrder.setBizOrderNo(refundOrderId);
			mockDepositOrder.setAppId(subAppId);
			mockDepositOrder.setMchId(mid);
			mockDepositOrder.setNotifyUrl(notifyUrl);
			mockDepositOrder.setMerchOrderNo(merOrderId);
			mockDepositOrder.setMchId(mid);
			mockDepositOrder.setPartnerId(partner);
			mockDepositOrder.setRefundReason(refundDesc);
		}
	}

	public void initFMTradeRefundServiceOrder(String request,
											   MockDepositOrder mockDepositOrder) {
		String sortedMaps = request;
		if (sortedMaps != null) {
			String Str = sortedMaps.toString().substring(1);
			Str = Str.substring(0,Str.length()-2);
			com.alibaba.fastjson.JSONObject resString = JSON.parseObject(sortedMaps);
			resString = JSON.parseObject(resString.get("data").toString()) ;
			log.info(JSON.toJSONString(resString).toString());
			log.info(resString.toString());

			String instMid = resString.get("instMid")  != null ? resString.get("instMid") .toString() : "";
			String merOrderId = resString.get("mchntOrderNo")  != null ? resString.get("mchntOrderNo") .toString() : "";

			String msgSrc = resString.get("msgSrc")  != null ? resString.get("msgSrc") .toString() : "";
			String msgType = resString.get("msgType")  != null ? resString.get("msgType") .toString() : "";
			String notifyUrl = resString.get("refundNotifyUrl")  != null ? resString.get("refundNotifyUrl") .toString() : "";
			String orderDesc = resString.get("orderDesc")  != null ? resString.get("orderDesc") .toString() : "";
			String requestTimestamp = resString.get("requestTimestamp")  != null ? resString.get("requestTimestamp") .toString() : "";
			String sign = resString.get("sign")  != null ? resString.get("sign") .toString() : "";
			String subAppId = resString.get("subAppId")  != null ? resString.get("subAppId") .toString() : "";
			String tid = resString.get("tid")  != null ? resString.get("tid") .toString() : "";
			String totalAmount = resString.get("refundFee")  != null ? resString.get("refundFee") .toString() : "";
			String tradeType = resString.get("tradeType")  != null ? resString.get("tradeType") .toString() : "";


			String mid = resString.get("mid")  != null ? resString.get("mid") .toString() : "";
			String partner = resString.get("mchntId")  != null ? resString.get("mchntId") .toString() : "";
			String refundDesc = resString.get("reason")  != null ? resString.get("reason") .toString() : "";
			String refundOrderId = resString.get("refMchntOrderNO")  != null ? resString.get("refMchntOrderNO") .toString() : "";

			mockDepositOrder.setAmount( totalAmount == "" ? 0l: Long.valueOf(totalAmount));
			mockDepositOrder.setBizOrderNo(refundOrderId);
			mockDepositOrder.setAppId(subAppId);
			mockDepositOrder.setMchId(mid);
			mockDepositOrder.setNotifyUrl(notifyUrl);
			mockDepositOrder.setMerchOrderNo(merOrderId);
			mockDepositOrder.setMchId(mid);
			mockDepositOrder.setPartnerId(partner);
			mockDepositOrder.setRefundReason(refundDesc);
		}
	}

	public void initFMQuickPaymentConsumeSmsServiceOrder(String request,
	                                                MockDepositOrder mockDepositOrder) {
		String sortedMaps = request;
		if (sortedMaps != null) {
			String Str = sortedMaps.toString().substring(1);
			Str = Str.substring(0,Str.length()-2);
			com.alibaba.fastjson.JSONObject resString = JSON.parseObject(sortedMaps);
			resString = JSON.parseObject(resString.get("data").toString()) ;
			log.info(JSON.toJSONString(resString).toString());
			log.info(resString.toString());
			
			String merOrderId = resString.get("bizChannelOrderid")  != null ? resString.get("bizChannelOrderid") .toString() : "";
			String accNo = resString.get("accNo")  != null ? resString.get("accNo") .toString() : "";
			String clientSerialNo = resString.get("clientSerialNo")  != null ? resString.get("clientSerialNo") .toString() : "";
			String phoneNo = resString.get("phoneNo")  != null ? resString.get("phoneNo") .toString() : "";
			String txnAmt = resString.get("txnAmt")  != null ? JSON.parseObject(resString.get("txnAmt").toString()).get("cent").toString() : "";
			
			mockDepositOrder.setAmount( txnAmt == "" ? 0l: Long.valueOf(txnAmt));
			mockDepositOrder.setBizOrderNo(merOrderId);
			mockDepositOrder.setMerchOrderNo(clientSerialNo);
			mockDepositOrder.setPayAccountCustNo(accNo);
			mockDepositOrder.setPayBankAccount(clientSerialNo);
			mockDepositOrder.setPayUserMobile(phoneNo);
		}
	}
	
	public void initFMQuickPaymentConsumeServiceOrder(String request,
	                                                        MockDepositOrder mockDepositOrder) {
		String sortedMaps = request;
		if (sortedMaps != null) {
			String Str = sortedMaps.toString().substring(1);
			Str = Str.substring(0,Str.length()-2);
			com.alibaba.fastjson.JSONObject resString = JSON.parseObject(sortedMaps);
			resString = JSON.parseObject(resString.get("data").toString()) ;
			log.info(JSON.toJSONString(resString).toString());
			log.info(resString.toString());
			
			String bizChannelOrderid = resString.get("bizChannelOrderid")  != null ? resString.get("bizChannelOrderid") .toString() : "";
			if(resString.get("biz_channel_orderid")  != null){
				bizChannelOrderid = resString.get("biz_channel_orderid") .toString();
			}
			String custMerchantNo = resString.get("custMerchantNo")  != null ? resString.get("custMerchantNo") .toString() : "";
			String nameOut = resString.get("nameOut")  != null ? resString.get("nameOut") .toString() : "";
			String orderId = resString.get("orderId")  != null ? resString.get("orderId") .toString() : "";
			String accNo = resString.get("accNo")  != null ? resString.get("accNo") .toString() : "";
			String smsCode = resString.get("smsCode")  != null ? resString.get("smsCode") .toString() : "";
			String clientSerialNo = resString.get("clientSerialNo")  != null ? resString.get("clientSerialNo") .toString() : "";
			String phoneNo = resString.get("phoneNo")  != null ? resString.get("phoneNo") .toString() : "";
			String prorateInfo = resString.get("prorateInfo")  != null ? resString.get("prorateInfo") .toString() : "";
			String certifId = resString.get("certifId")  != null ? resString.get("certifId") .toString() : "";
			String tradeRemark = resString.get("tradeRemark")  != null ? resString.get("tradeRemark") .toString() : "";
			String certifTp = resString.get("certifTp")  != null ? resString.get("certifTp") .toString() : "";
			String subTradeType = resString.get("subTradeType")  != null ? resString.get("subTradeType") .toString() : "";
			String txnAmt = resString.get("txnAmt")  != null ? JSON.parseObject(resString.get("txnAmt").toString()).get("cent").toString() : "";
			
			mockDepositOrder.setAmount( txnAmt == "" ? 0l: Long.valueOf(txnAmt));
			mockDepositOrder.setBizOrderNo(bizChannelOrderid);
			mockDepositOrder.setMerchOrderNo(orderId);
			mockDepositOrder.setPayBankAccount(accNo);
			mockDepositOrder.setPayUserName(nameOut);
			mockDepositOrder.setPayUserMobile(phoneNo);
			mockDepositOrder.setPayBankId(certifId);
			mockDepositOrder.setUserId(custMerchantNo);
			mockDepositOrder.setBankSerialNo(clientSerialNo);
			mockDepositOrder.setPayType(subTradeType);
		}
	}
	
	
	public void initFmAccountIIRechargeServiceOrder(String request,
	                                                     MockDepositOrder mockDepositOrder) {
		String sortedMaps = request;
		if (sortedMaps != null) {
			String Str = sortedMaps.toString().substring(1);
			Str = Str.substring(0,Str.length()-2);
			com.alibaba.fastjson.JSONObject resString = JSON.parseObject(sortedMaps);
			resString = JSON.parseObject(resString.get("data").toString()) ;
			log.info(JSON.toJSONString(resString).toString());
			log.info(resString.toString());
			
			
			String name_out = resString.get("name_out")  != null ? resString.get("name_out") .toString() : "";
			String client_serial_no = resString.get("client_serial_no")  != null ? resString.get("client_serial_no") .toString() : "";
			String trade_amount = resString.get("trade_amount")  != null ? JSON.parseObject(resString.get("trade_amount").toString()).get("cent").toString() : "";
			String account_out = resString.get("account_out")  != null ? resString.get("account_out") .toString() : "";
			String account_in = resString.get("account_in")  != null ? resString.get("account_in") .toString() : "";
			String currency = resString.get("currency")  != null ? resString.get("currency") .toString() : "";
			String cust_merchant_no = resString.get("cust_merchant_no")  != null ? resString.get("cust_merchant_no") .toString() : "";
			String name_in = resString.get("name_in")  != null ? resString.get("name_in") .toString() : "";
			String trade_remark = resString.get("trade_remark")  != null ? resString.get("trade_remark") .toString() : "";
			String biz_channel_orderid = resString.get("biz_channel_orderid")  != null ? resString.get("biz_channel_orderid") .toString() : "";
			
			
			mockDepositOrder.setPayUserName(name_out);
			mockDepositOrder.setRecBankName(name_in);
			mockDepositOrder.setBizOrderNo(biz_channel_orderid);
			mockDepositOrder.setBankSerialNo(client_serial_no);
			mockDepositOrder.setAmount(trade_amount == "" ? 0l: Long.valueOf(trade_amount));
			mockDepositOrder.setPayBankAccount(account_out);
			mockDepositOrder.setRecBankAccount(account_in);
			mockDepositOrder.setMerchantId(cust_merchant_no);
		}
	}
	
	
	public void initFmAccountIIWithdrawServiceOrder(String request,
	                                                   MockWithdrawOrder mockWithdrawOrder) {
		String sortedMaps = request;
		if (sortedMaps != null) {
			String Str = sortedMaps.toString().substring(1);
			Str = Str.substring(0,Str.length()-2);
			com.alibaba.fastjson.JSONObject resString = JSON.parseObject(sortedMaps);
			resString = JSON.parseObject(resString.get("data").toString()) ;
			log.info(JSON.toJSONString(resString).toString());
			log.info(resString.toString());
			
			String name_out = resString.get("name_out")  != null ? resString.get("name_out") .toString() : "";
			String account_in = resString.get("account_in")  != null ? resString.get("account_in") .toString() : "";
			String document_id = resString.get("document_id")  != null ? resString.get("document_id") .toString() : "";
			String trade_remark = resString.get("trade_remark")  != null ? resString.get("trade_remark") .toString() : "";
			String biz_channel_orderid = resString.get("biz_channel_orderid")  != null ? resString.get("biz_channel_orderid") .toString() : "";
			String acct_flag = resString.get("acct_flag")  != null ? resString.get("acct_flag") .toString() : "";
			String client_serial_no = resString.get("client_serial_no")  != null ? resString.get("client_serial_no") .toString() : "";
			String cust_no = resString.get("cust_no")  != null ? resString.get("cust_no") .toString() : "";
			String account_out = resString.get("account_out")  != null ? resString.get("account_out") .toString() : "";
			String currency = resString.get("currency")  != null ? resString.get("currency") .toString() : "";
			String name_in = resString.get("name_in")  != null ? resString.get("name_in") .toString() : "";
			String transfer_type = resString.get("transfer_type")  != null ? resString.get("transfer_type") .toString() : "";
			String trans_type = resString.get("trans_type")  != null ? resString.get("trans_type") .toString() : "";
			String trade_amount = resString.get("trade_amount")  != null ? JSON.parseObject(resString.get("trade_amount").toString()).get("cent").toString() : "";
			
			mockWithdrawOrder.setPayUserName(name_out);
			mockWithdrawOrder.setRecBankName(name_in);
			mockWithdrawOrder.setBizOrderNo(biz_channel_orderid);
			mockWithdrawOrder.setPayBankId(client_serial_no);
			mockWithdrawOrder.setAmount(trade_amount == "" ? 0l: Long.valueOf(trade_amount));
			mockWithdrawOrder.setPayAccountNo(account_out);
			mockWithdrawOrder.setUserId(account_in);
			mockWithdrawOrder.setPayBankCurrency(currency);
			mockWithdrawOrder.setCustUserid(document_id);
			mockWithdrawOrder.setUserId(cust_no);
			
		}
	}
	
	public void initFmAccountIIWithdrawServiceOrder2(String request,
	                                                   MockWithdrawOrder mockWithdrawOrder) {
		String sortedMaps = request;
		if (sortedMaps != null) {
			String Str = sortedMaps.toString().substring(1);
			Str = Str.substring(0,Str.length()-2);
			com.alibaba.fastjson.JSONObject resString = JSON.parseObject(sortedMaps);
			resString = JSON.parseObject(resString.get("data").toString()) ;
			log.info(JSON.toJSONString(resString).toString());
			log.info(resString.toString());
			
			String name_out = resString.get("name_out")  != null ? resString.get("name_out") .toString() : "";
			String account_in = resString.get("account_in")  != null ? resString.get("account_in") .toString() : "";
			String document_id = resString.get("document_id")  != null ? resString.get("document_id") .toString() : "";
			String trade_remark = resString.get("trade_remark")  != null ? resString.get("trade_remark") .toString() : "";
			String biz_channel_orderid = resString.get("biz_channel_orderid")  != null ? resString.get("biz_channel_orderid") .toString() : "";
			String acct_flag = resString.get("acct_flag")  != null ? resString.get("acct_flag") .toString() : "";
			String client_serial_no = resString.get("client_serial_no")  != null ? resString.get("client_serial_no") .toString() : "";
			String cust_no = resString.get("cust_no")  != null ? resString.get("cust_no") .toString() : "";
			String account_out = resString.get("account_out")  != null ? resString.get("account_out") .toString() : "";
			String currency = resString.get("currency")  != null ? resString.get("currency") .toString() : "";
			String name_in = resString.get("name_in")  != null ? resString.get("name_in") .toString() : "";
			String transfer_type = resString.get("transfer_type")  != null ? resString.get("transfer_type") .toString() : "";
			String trans_type = resString.get("trans_type")  != null ? resString.get("trans_type") .toString() : "";
			String trade_amount = resString.get("trade_amount")  != null ? JSON.parseObject(resString.get("trade_amount").toString()).get("cent").toString() : "";
			
			mockWithdrawOrder.setPayUserName(name_out);
			mockWithdrawOrder.setRecBankName(name_in);
			mockWithdrawOrder.setBizOrderNo(biz_channel_orderid);
			mockWithdrawOrder.setPayBankId(client_serial_no);
			mockWithdrawOrder.setAmount(trade_amount == "" ? 0l: Long.valueOf(trade_amount));
			mockWithdrawOrder.setPayAccountNo(account_out);
			mockWithdrawOrder.setUserId(account_in);
			mockWithdrawOrder.setPayBankCurrency(currency);
			mockWithdrawOrder.setCustUserid(document_id);
			mockWithdrawOrder.setUserId(cust_no);
			
		}
	}
	
	public void initFmPaidTransferServiceOrder(String resString,
	                                              MockDepositOrder mockWithdrawOrder) {
		if (resString != null) {
			com.alibaba.fastjson.JSONObject resStrings = JSON.parseObject(resString);
			resString = resStrings.get("data").toString();
			
			
			String amount = JSON.parseObject(resString).get("amount") != null ?
					JSON.parseObject( JSON.parseObject(resString).get("amount").toString()).get("cent").toString() : "";
			String bizOrderNo = JSON.parseObject(resString).get("bizOrderNo") != null ? JSON.parseObject(resString).get("bizOrderNo").toString() : "";
			String gid = JSON.parseObject(resString).get("gid") != null ? JSON.parseObject(resString).get("gid").toString() : "";
			String merchOrderNo = JSON.parseObject(resString).get("merchOrderNo") != null ? JSON.parseObject(resString).get("merchOrderNo").toString() : "";
			String partnerId = JSON.parseObject(resString).get("partnerId") != null ? JSON.parseObject(resString).get("partnerId").toString() : "";
			String payAccountName = JSON.parseObject(resString).get("payAccountName") != null ? JSON.parseObject(resString).get("payAccountName").toString() : "";
			String payAccountNo = JSON.parseObject(resString).get("payAccountNo") != null ? JSON.parseObject(resString).get("payAccountNo").toString() : "";
			String recBankCardNo = JSON.parseObject(resString).get("recBankCardNo") != null ? JSON.parseObject(resString).get("recBankCardNo").toString() : "";
			String recRealName = JSON.parseObject(resString).get("recRealName") != null ? JSON.parseObject(resString).get("recRealName").toString() : "";
			String userNo = JSON.parseObject(resString).get("userNo") != null ? JSON.parseObject(resString).get("userNo").toString() : "";
			
			mockWithdrawOrder.setAmount(amount == "" ? 0l : Long.valueOf(amount));
			mockWithdrawOrder.setBizOrderNo(bizOrderNo);
			mockWithdrawOrder.setPartnerId(partnerId);
			mockWithdrawOrder.setMerchOrderNo(merchOrderNo);
			mockWithdrawOrder.setGid(gid);
			mockWithdrawOrder.setPayAccountName(payAccountName);
//			mockWithdrawOrder.setPayAccountNo(payAccountNo);
			mockWithdrawOrder.setRecBankId(recBankCardNo);
//			mockWithdrawOrder.setRecAccountName(recRealName);
			mockWithdrawOrder.setUserId(userNo);
		}
	}
	
	public void initFmConsumeLedgerServiceOrder(String resString,
	                                           MockDepositOrder mockWithdrawOrder) {
		if (resString != null) {
			com.alibaba.fastjson.JSONObject resStrings = JSON.parseObject(resString);
			resString = resStrings.get("data").toString();
			
			String account_out = JSON.parseObject(resString).get("account_out") != null ? JSON.parseObject(resString).get("account_out").toString() : "";
			String biz_channel_orderid = JSON.parseObject(resString).get("biz_channel_orderid") != null ? JSON.parseObject(resString).get("biz_channel_orderid").toString() : "";
			String client_serial_no = JSON.parseObject(resString).get("client_serial_no") != null ? JSON.parseObject(resString).get("client_serial_no").toString() : "";
			String currency = JSON.parseObject(resString).get("currency") != null ? JSON.parseObject(resString).get("currency").toString() : "";
			String cust_merchant_out = JSON.parseObject(resString).get("cust_merchant_out") != null ? JSON.parseObject(resString).get("cust_merchant_out").toString() : "";
			String trans_nature = JSON.parseObject(resString).get("trans_nature") != null ? JSON.parseObject(resString).get("trans_nature").toString() : "";
			String trade_amount = JSON.parseObject(resString).get("trade_amount") != null ? JSON
					.parseObject(JSON
							.parseObject(resString).get("trade_amount").toString()).get("cent")
					.toString()  : "";
			String cust_merchant_in = "" ;
			String account_in = "" ;
			if (JSON.parseObject(resString).get("ledger_account_info") != null) {
				 cust_merchant_in = JSON.parseObject(JSON.parseArray(JSON.parseObject(resString).get
						("ledger_account_info").toString()).get(0).toString()).get("cust_merchant_in") != null ? JSON.parseObject(JSON.parseArray(JSON.parseObject(resString).get
						("ledger_account_info").toString()).get(0).toString()).get("cust_merchant_in").toString() : "";
				 account_in = JSON.parseObject(JSON.parseArray(JSON.parseObject(resString).get
						("ledger_account_info").toString()).get(0).toString()).get("account_in") != null ? JSON.parseObject(JSON.parseArray(JSON.parseObject(resString).get
						("ledger_account_info").toString()).get(0).toString()).get("account_in").toString() : "";
			}
			mockWithdrawOrder.setBizOrderNo(biz_channel_orderid);
			mockWithdrawOrder.setPayBankAccount(account_out);
			mockWithdrawOrder.setBankSerialNo(client_serial_no);
			mockWithdrawOrder.setPayBankCurrency(currency);
			mockWithdrawOrder.setPayUserId(cust_merchant_out);
			mockWithdrawOrder.setAmount(trade_amount == "" ? 0l : Long.valueOf(trade_amount));
			mockWithdrawOrder.setUserId(cust_merchant_in);
			mockWithdrawOrder.setRecBankAccount(account_in);
		}
	}

	public void initFmQuickPaymentSignOrder(String request,
											MockSignInfo mockSignInfo) {
		String sortedMaps = request;
		if (sortedMaps != null) {
			String Str = sortedMaps.toString().substring(1);
			Str = Str.substring(0,Str.length()-2);
			com.alibaba.fastjson.JSONObject resString = JSON.parseObject(sortedMaps);
			resString = JSON.parseObject(resString.get("data").toString()) ;
			log.info(JSON.toJSONString(resString).toString());
			log.info(resString.toString());


			String bizChannelOrderid = resString.get("bizChannelOrderid")  != null ? resString.get("bizChannelOrderid") .toString() : "";
			String custMerchantNo = resString.get("custMerchantNo")  != null ? resString.get("custMerchantNo") .toString() : "";
			String certifId = resString.get("certifId")  != null ? resString.get("certifId") .toString() : "";
			String phoneNo = resString.get("phoneNo")  != null ? resString.get("phoneNo") .toString() : "";
			String accNo = resString.get("accNo")  != null ? resString.get("accNo") .toString() : "";
			String clientSerialNo = resString.get("clientSerialNo")  != null ? resString.get("clientSerialNo") .toString() : "";


			mockSignInfo.setBizOrderNo(bizChannelOrderid);
			mockSignInfo.setUserId(custMerchantNo);
			mockSignInfo.setCertNo(certifId);
			mockSignInfo.setMobileNo(phoneNo);
			mockSignInfo.setBankCardNo(accNo);
			mockSignInfo.setMockOrderNo(clientSerialNo);
		}
	}
	public void initFmQuickPaymentSignQueryOrder(String request,
											MockSignInfo mockSignInfo) {
		String sortedMaps = request;
		if (sortedMaps != null) {
			String Str = sortedMaps.toString().substring(1);
			Str = Str.substring(0,Str.length()-2);
			com.alibaba.fastjson.JSONObject resString = JSON.parseObject(sortedMaps);
			resString = JSON.parseObject(resString.get("data").toString()) ;
			log.info(JSON.toJSONString(resString).toString());
			log.info(resString.toString());


			String bizChannelOrderid = resString.get("bizChannelOrderid")  != null ? resString.get("bizChannelOrderid") .toString() : "";
			String accNo = resString.get("accNo")  != null ? resString.get("accNo") .toString() : "";


			mockSignInfo.setBizOrderNo(bizChannelOrderid);
			mockSignInfo.setBankCardNo(accNo);
		}
	}
	
	public void initFmVerifyTransferServiceOrder(String resString,
	                                             MockDepositOrder mockWithdrawOrder) {
		if (resString != null) {
			com.alibaba.fastjson.JSONObject resStrings = JSON.parseObject(resString);
			resString = resStrings.get("data").toString();
			
			String account_out = JSON.parseObject(resString).get("account_out") != null ? JSON.parseObject(resString).get("account_out").toString() : "";
			String biz_channel_orderid = JSON.parseObject(resString).get("biz_channel_orderid") != null ? JSON.parseObject(resString).get("biz_channel_orderid").toString() : "";
			String client_serial_no = JSON.parseObject(resString).get("client_serial_no") != null ? JSON.parseObject(resString).get("client_serial_no").toString() : "";
			String currency = JSON.parseObject(resString).get("currency") != null ? JSON.parseObject(resString).get("currency").toString() : "";
			String cust_merchant_out = JSON.parseObject(resString).get("cust_merchant_out") != null ? JSON.parseObject(resString).get("cust_merchant_out").toString() : "";
			String trans_nature = JSON.parseObject(resString).get("trans_nature") != null ? JSON.parseObject(resString).get("trans_nature").toString() : "";
			String trade_amount = JSON.parseObject(resString).get("trade_amount") != null ? JSON
					.parseObject(JSON
							.parseObject(resString).get("trade_amount").toString()).get("cent")
					.toString()  : "";
			String cust_merchant_in = "" ;
			String account_in = "" ;
			if (JSON.parseObject(resString).get("ledger_account_info") != null) {
				cust_merchant_in = JSON.parseObject(JSON.parseArray(JSON.parseObject(resString).get
						("ledger_account_info").toString()).get(0).toString()).get("cust_merchant_in") != null ? JSON.parseObject(JSON.parseArray(JSON.parseObject(resString).get
						("ledger_account_info").toString()).get(0).toString()).get("cust_merchant_in").toString() : "";
				account_in = JSON.parseObject(JSON.parseArray(JSON.parseObject(resString).get
						("ledger_account_info").toString()).get(0).toString()).get("account_in") != null ? JSON.parseObject(JSON.parseArray(JSON.parseObject(resString).get
						("ledger_account_info").toString()).get(0).toString()).get("account_in").toString() : "";
			}
			mockWithdrawOrder.setBizOrderNo(biz_channel_orderid);
			mockWithdrawOrder.setPayBankAccount(account_out);
			mockWithdrawOrder.setBankSerialNo(client_serial_no);
			mockWithdrawOrder.setPayBankCurrency(currency);
			mockWithdrawOrder.setPayUserId(cust_merchant_out);
			mockWithdrawOrder.setAmount(trade_amount == "" ? 0l : Long.valueOf(trade_amount));
			mockWithdrawOrder.setUserId(cust_merchant_in);
			mockWithdrawOrder.setRecBankAccount(account_in);
		}
	}
	
	public void initFmAccountBalanceQueryServiceOrder(String resString,
	                                                  MockDepositOrder mockWithdrawOrder) {
		if (resString != null) {
			com.alibaba.fastjson.JSONObject resStrings = JSON.parseObject(resString);
			resString = resStrings.get("data").toString();
			
			String userNo = JSON.parseObject(resString).get("cust_merchant_no") != null ?
					JSON.parseObject(resString).get("cust_merchant_no").toString() : "";
			String recBankCardNo = JSON.parseObject(resString).get("base_acct_no") != null ?
					JSON.parseObject(resString).get("base_acct_no").toString() : "";
			String clientSerialNo  = JSON.parseObject(resString).get("client_serial_no") != null ?
					JSON.parseObject(resString).get("client_serial_no").toString() : "";
			
			mockWithdrawOrder.setBizOrderNo(clientSerialNo);
			mockWithdrawOrder.setRecBankId(recBankCardNo);
			mockWithdrawOrder.setUserId(userNo);
		}
		
	}
	
	public void initHaierNetBankPayServiceOrder(String resString,
	                                                  MockDepositOrder mockWithdrawOrder) {
		if (resString != null) {
			com.alibaba.fastjson.JSONObject resStrings = JSON.parseObject(resString);
			resString = resStrings.get("data").toString();
			log.info("MOCK-请求-result.data() ： {}", resString);
			
			String bank_code = JSON.parseObject(resString).get("bank_code") != null ?
					JSON.parseObject(resString).get("bank_code").toString() : "";
			String pay_product_code = JSON.parseObject(resString).get("pay_product_code") != null ?
					JSON.parseObject(resString).get("pay_product_code").toString() : "";
			String payer_ip = JSON.parseObject(resString).get("payer_ip") != null ?
					JSON.parseObject(resString).get("payer_ip").toString() : "";
			
			com.alibaba.fastjson.JSONObject pay_methods =
					JSON.parseObject(JSON.parseObject(resString).get("pay_method").toString());
			log.info("MOCK-请求-pay_methods ： {}", pay_methods);
			String trade_amount = pay_methods.get("amount") != null ? JSON.parseObject(pay_methods.get("amount").toString()).get("cent").toString()  : "";
			
			com.alibaba.fastjson.JSONObject trade_info =
					JSON.parseObject(JSON.parseObject(resString).get("trade_info").toString());
			String out_trade_no = trade_info.get("out_trade_no") != null ? trade_info.get("out_trade_no").toString() : "";
			
			mockWithdrawOrder.setAmount(trade_amount == "" ? 0l: Long.valueOf(trade_amount));
			mockWithdrawOrder.setPayBankCode(bank_code);
			mockWithdrawOrder.setPayBankCode(pay_product_code);
			mockWithdrawOrder.setBizOrderNo(out_trade_no);
			mockWithdrawOrder.setUserEndIp(payer_ip);
			
			log.info("MOCK-请求-mockWithdrawOrder ： {}", mockWithdrawOrder);
		}
		
	}
	
	public void initHaierTradeQueryServiceOrder(String resString,
	                                                  MockDepositOrder mockWithdrawOrder) {
		if (resString != null) {
			com.alibaba.fastjson.JSONObject resStrings = JSON.parseObject(resString);
			resString = resStrings.get("data").toString();
			log.info("MOCK-请求-result.data() ： {}", resString);
			String userNo = JSON.parseObject(resString).get("cust_merchant_no") != null ?
					JSON.parseObject(resString).get("cust_merchant_no").toString() : "";
			String recBankCardNo = JSON.parseObject(resString).get("base_acct_no") != null ?
					JSON.parseObject(resString).get("base_acct_no").toString() : "";
			String out_trade_no  = JSON.parseObject(resString).get("out_trade_no") != null ?
					JSON.parseObject(resString).get("out_trade_no").toString() : "";
			
			mockWithdrawOrder.setBizOrderNo(out_trade_no);
			mockWithdrawOrder.setRecBankId(recBankCardNo);
			mockWithdrawOrder.setUserId(userNo);
		}
		
	}
	
	public void initShchinaumsWeixinRawH5ServiceOrder(String resString,
	                                            MockDepositOrder mockWithdrawOrder) {
		if (resString != null) {
			com.alibaba.fastjson.JSONObject resStrings = JSON.parseObject(resString);
			resString = resStrings.get("data").toString();
			log.info("MOCK-请求-result.data() ： {}", resString);
			
			String merOrderId = JSON.parseObject(resString).get("merOrderId") != null ?
					JSON.parseObject(resString).get("merOrderId").toString() : "";
			String orderDesc = JSON.parseObject(resString).get("orderDesc") != null ?
					JSON.parseObject(resString).get("orderDesc").toString() : "";
			String subAppId = JSON.parseObject(resString).get("subAppId") != null ?
					JSON.parseObject(resString).get("subAppId").toString() : "";
			
			String totalAmount = JSON.parseObject(resString).get("totalAmount") != null ?
							JSON.parseObject(resString).get("totalAmount").toString() : "";
			
			mockWithdrawOrder.setAmount(totalAmount == "" ? 0l: Long.valueOf(totalAmount));
			
			mockWithdrawOrder.setBizOrderNo(merOrderId);
			mockWithdrawOrder.setGoodsMemo(orderDesc);
			mockWithdrawOrder.setAppId(subAppId);
			
			log.info("MOCK-请求-mockWithdrawOrder ： {}", mockWithdrawOrder);
		}
	}
	
	public void initShchinaumsQueryServiceOrder(String resString,
	                                                  MockDepositOrder mockWithdrawOrder) {
		if (resString != null) {
			com.alibaba.fastjson.JSONObject resStrings = JSON.parseObject(resString);
			resString = resStrings.get("data").toString();
			log.info("MOCK-请求-result.data() ： {}", resString);
			
			String merOrderId = JSON.parseObject(resString).get("merOrderId") != null ?
					JSON.parseObject(resString).get("merOrderId").toString() : "";
			
			String totalAmount = JSON.parseObject(resString).get("totalAmount") != null ?
							JSON.parseObject(resString).get("totalAmount").toString() : "";
			
			mockWithdrawOrder.setAmount(totalAmount == "" ? 0l: Long.valueOf(totalAmount));
			mockWithdrawOrder.setBizOrderNo(merOrderId);
			
			log.info("MOCK-请求-mockWithdrawOrder ： {}", mockWithdrawOrder);
		}
	}
	
	
}
