/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-30
 */
 package com.jorge.testui.platform.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.platform.entity.MockSignInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * mock_sign_info Mybatis Dao
 *
 * @author mufanglin
 * @date 2019-12-30 15:24:40
 */
public interface MockSignInfoDao extends EntityMybatisDao<MockSignInfo> {
 
 @Select("SELECT * FROM mock_deposit_order where mock_notify_status IN ('N','F') AND type_source = 'WECHAT_WEB_PAY' AND DATE_SUB(CURDATE(), INTERVAL 30 MINUTE) <= create_time  AND mock_notify_count < 6")
 List<MockSignInfo> findEntityByMockDepositOrderWechatWebPayAll();
 
 // 初始化mock订单表流水信息
 @Update("INSERT INTO mock_deposit_order (mock_order_no,mock_status,biz_order_no,amount,mch_id,trade_date,trade_time,instalments,goods_memo,jump_url,notify_url,trx_code,pay_account_name,user_pass,level,data_type,version,merchant_id,business_code,"
         + "business_time,pay_user_name,pay_bank_account,pay_bank_type,pay_bank_code,pay_bank_currency,pay_user_mobile,cust_userid,mock_notify_status,app_id,random_str,pay_end_ip,pay_type,pay_user_id,sign,type_source) "
         + " VALUES ( #{mockOrderNo},#{mockStatus},#{bizOrderNo},#{amount},#{mchId},#{tradeDate},#{tradeTime},#{instalments},#{goodsMemo},#{jumpUrl},#{notifyUrl},#{trxCode},#{payAccountName},#{userPass},#{level},#{dataType},#{version},#{merchantId},"
         + "#{businessCode},#{businessTime},#{payUserName},#{payBankAccount},#{payBankType},#{payBankCode},#{payBankCurrency},#{payUserMobile},#{custUserid},#{mockNotifyStatus},#{appId},#{randomStr},#{payEndIp},#{payType},#{payUserId},#{sign},#{typeSource}) ")
 void saveMockDepositOrder(@Param("mockOrderNo") String mockOrderNo,
                           @Param("mockStatus") String mockStatus,
                           @Param("bizOrderNo") String bizOrderNo,
                           @Param("amount") long amount, @Param("mchId") String mchId,
                           @Param("tradeDate") String tradeDate,
                           @Param("tradeTime") String tradeTime,
                           @Param("instalments") String instalments,
                           @Param("goodsMemo") String goodsMemo,
                           @Param("jumpUrl") String jumpUrl,
                           @Param("notifyUrl") String notifyUrl,
                           @Param("trxCode") String trxCode,
                           @Param("payAccountName") String payAccountName,
                           @Param("userPass") String userPass, @Param("level") int level,
                           @Param("dataType") String dataType,
                           @Param("version") String version,
                           @Param("merchantId") String merchantId,
                           @Param("businessCode") String businessCode,
                           @Param("businessTime") String businessTime,
                           @Param("payUserName") String payUserName,
                           @Param("payBankAccount") String payBankAccount,
                           @Param("payBankType") String payBankType,
                           @Param("payBankCode") String payBankCode,
                           @Param("payBankCurrency") String payBankCurrency,
                           @Param("payUserMobile") String payUserMobile,
                           @Param("custUserid") String custUserid,
                           @Param("mockNotifyStatus") String mockNotifyStatus,
                           @Param("appId") String appId, @Param("randomStr") String randomStr,
                           @Param("payEndIp") String payEndIp,
                           @Param("payType") String payType,
                           @Param("payUserId") String payUserId, @Param("sign") String sign,
                           @Param("typeSource") String typeSource);
 
 // 更新mock订单表流水信息
 @Select("update mock_sign_info set mock_status = #{mockStatus} where biz_order_no = #{bizOrderNo}")
 void updateMockSignInfoOrderMockStatusByBizOrderNo(@Param("bizOrderNo") String bizOrderNo,
                                                    @Param("mockStatus") String mockStatus);
 
 // 更新mock订单表流水信息
 @Select("update mock_sign_info set mock_notify_status = #{mockNotifyStatus} ,mock_notify_count = #{mockNotifyCount},mock_status = #{mockStatus} where mock_order_no = #{mockOrderNo}")
 void updateMockNotifyStatusBizStatusByMockOrderNo(@Param("mockOrderNo") String mockOrderNo,
                                                   @Param("mockNotifyStatus") String mockNotifyStatus,
                                                   @Param("mockNotifyCount") Integer mockNotifyCount,
                                                   @Param("mockStatus") String mockStatus);
 
 //查询mock签约订单流水信息
 @Select("SELECT * FROM mock_sign_info where  DATE_SUB(CURDATE(), INTERVAL 3 DAY) <= create_time AND mock_notify_status IN ('N','F') AND mock_notify_count<10")
 List<MockSignInfo> findEntityByMockSignInfoOrderSignAll();

 @Select("SELECT * FROM mock_sign_info where biz_order_no= #{bizOrderNo} and mock_status IN ('PROCESSING') AND mock_notify_count < 6 order by create_time desc  limit 1")
 MockSignInfo  findEntityByBizOrderNoAndMockStatus(@Param("bizOrderNo") String bizOrderNo);

}
