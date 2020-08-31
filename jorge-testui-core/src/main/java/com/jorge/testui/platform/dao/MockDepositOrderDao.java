/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-30
 */
 package com.jorge.testui.platform.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.platform.entity.MockDepositOrder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.Date;
import java.util.List;

/**
 * 充值交易订单表 Mybatis Dao
 *
 * @author mufanglin
 * @date 2019-12-30 15:24:40
 */
public interface MockDepositOrderDao extends EntityMybatisDao<MockDepositOrder> {
 
 @Update("UPDATE mock_deposit_order SET create_time = #{createTime} where biz_order_no= " +
         "#{bizOrderNo}")
 void updateMockDepositOrderByBizOrderNo(@Param("bizOrderNo") String bizOrderNo, @Param
         ("createTime") Date createTime);
 
 @Delete("delete from mock_deposit_order where biz_order_no = #{bizOrderNo}")
 void deleteMockDepositOrderByBizOrderNo(@Param("bizOrderNo") String bizOrderNo);

 
 
 // 根据订单号查询（mock）提现流水订单表
 @Select("select * from mock_deposit_order where biz_order_no = #{bizOrderNo}")
 MockDepositOrder findEntityByBizOrderNo(@Param("bizOrderNo") String bizOrderNo);
 
 @Select("select * from mock_deposit_order where biz_order_no = #{bizOrderNo} AND confirm_status IN ('PROCESSING') AND DATE_SUB(CURDATE(), INTERVAL 30 MINUTE) <= create_time AND mock_notify_count < 6 order by create_time desc  limit 1 ")
 MockDepositOrder findEntityByBizOrderNoAndMockStatus(@Param("bizOrderNo") String bizOrderNo);
 
 @Select("select * from mock_deposit_order where biz_order_no = #{bizOrderNo} AND mock_status != 'SUCCESS' AND " +
         "mock_notify_status IN ('N','F') AND DATE_SUB(CURDATE(), INTERVAL 30 MINUTE) <= create_time  AND mock_notify_count < 6 ")
 List<MockDepositOrder> findEntityByBizOrderNoAndNotifyStatus(@Param("bizOrderNo") String bizOrderNo);
 
 @Select("SELECT * FROM mock_deposit_order where mock_notify_status IN ('N','F') AND DATE_SUB(CURDATE(), INTERVAL 30 MINUTE) <= create_time  AND mock_notify_count < 6")
 List<MockDepositOrder> findEntityByMockDepositOrderAll();
 
 @Select("SELECT * FROM mock_deposit_order where mock_notify_status IN ('N','F') AND type_source = 'WECHAT_WEB_PAY' AND DATE_SUB(CURDATE(), INTERVAL 30 MINUTE) <= create_time  AND mock_notify_count < 6")
 List<MockDepositOrder> findEntityByMockDepositOrderWechatWebPayAll();
 
 @Select("SELECT * FROM mock_deposit_order where type_source = #{typeSource} AND mock_notify_status IN ('N','F') AND DATE_SUB(CURDATE(), INTERVAL 30 MINUTE) <= create_time  AND mock_notify_count < 6")
 List<MockDepositOrder> findEntityByMockDepositOrderByTypeSource(@Param("typeSource") String typeSource);
 
 
 @Select("SELECT * FROM mock_deposit_order where type_source = 'CREDIT_INSTALMENT_PAY' AND mock_notify_status IN ('N','F') AND DATE_SUB(CURDATE(), INTERVAL 30 MINUTE) <= create_time  AND mock_notify_count < 6")
 List<MockDepositOrder> findEntityByMockDepositOrderByTypeSourceByCreditInstalmentPay();
 
 
 // 初始化mock订单表流水信息
 @Update("INSERT INTO mock_deposit_order (mock_order_no,mock_status,biz_order_no,amount,mch_id,trade_date,trade_time,instalments,goods_memo,jump_url,notify_url,trx_code,pay_account_name,user_pass,level,data_type,version,merchant_id,business_code," +
         "business_time,pay_user_name,pay_bank_account,pay_bank_type,pay_bank_code,pay_bank_currency,pay_user_mobile,cust_userid,mock_notify_status,app_id,random_str,pay_end_ip,pay_type,pay_user_id,sign,type_source) " +
         " VALUES ( #{mockOrderNo},#{mockStatus},#{bizOrderNo},#{amount},#{mchId},#{tradeDate},#{tradeTime},#{instalments},#{goodsMemo},#{jumpUrl},#{notifyUrl},#{trxCode},#{payAccountName},#{userPass},#{level},#{dataType},#{version},#{merchantId}," +
         "#{businessCode},#{businessTime},#{payUserName},#{payBankAccount},#{payBankType},#{payBankCode},#{payBankCurrency},#{payUserMobile},#{custUserid},#{mockNotifyStatus},#{appId},#{randomStr},#{payEndIp},#{payType},#{payUserId},#{sign},#{typeSource}) ")
 void saveMockDepositOrder(@Param("mockOrderNo") String mockOrderNo, @Param("mockStatus") String mockStatus, @Param("bizOrderNo") String bizOrderNo, @Param("amount") long amount, @Param("mchId") String mchId,
                           @Param("tradeDate") String tradeDate, @Param("tradeTime") String tradeTime, @Param("instalments") String instalments, @Param("goodsMemo") String goodsMemo,
                           @Param("jumpUrl") String jumpUrl, @Param("notifyUrl") String notifyUrl, @Param("trxCode") String trxCode, @Param("payAccountName") String payAccountName,
                           @Param("userPass") String userPass, @Param("level") int level, @Param("dataType") String dataType, @Param("version") String version, @Param("merchantId") String merchantId,
                           @Param("businessCode") String businessCode, @Param("businessTime") String businessTime, @Param("payUserName") String payUserName, @Param("payBankAccount") String payBankAccount,
                           @Param("payBankType") String payBankType, @Param("payBankCode") String payBankCode, @Param("payBankCurrency") String payBankCurrency, @Param("payUserMobile") String payUserMobile,
                           @Param("custUserid") String custUserid, @Param("mockNotifyStatus") String mockNotifyStatus, @Param("appId") String appId, @Param("randomStr") String randomStr,
                           @Param("payEndIp") String payEndIp, @Param("payType") String payType, @Param("payUserId") String payUserId, @Param("sign") String sign, @Param("typeSource") String typeSource);
 
 
 // 更新mock订单表流水信息
 @Select("update mock_deposit_order set mock_notify_status = #{mockNotifyStatus} ,mock_notify_count = #{mockNotifyCount},suc_amount = #{sucAmount},mock_status = #{mockStatus} where biz_order_no = #{bizOrderNo}")
 void updateMockNotifyStatusByBizOrderNo(@Param("bizOrderNo") String bizOrderNo, @Param("mockNotifyStatus") String mockNotifyStatus, @Param("mockNotifyCount") Integer mockNotifyCount,
                                         @Param("sucAmount") long sucAmount, @Param("mockStatus") String mockStatus);
 
 // 更新mock订单表流水信息
 @Select("update mock_deposit_order set mock_notify_status = #{mockNotifyStatus} ,mock_notify_count = #{mockNotifyCount},mock_status = #{mockStatus} where biz_order_no = #{bizOrderNo}")
 void updateMockNotifyStatusBizStatusByBizOrderNo(@Param("bizOrderNo") String bizOrderNo, @Param("mockNotifyStatus") String mockNotifyStatus, @Param("mockNotifyCount") Integer mockNotifyCount,
                                                  @Param("mockStatus") String mockStatus);
 
 @Select("select * from mock_deposit_order where user_id = #{userNo} order by create_time desc  limit 1")
 MockDepositOrder findEntityByUserNo(@Param("userNo") String userNo);
 
}
