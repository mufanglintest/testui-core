/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-12-30
 */
 package com.jorge.testui.platform.dao;

import com.acooly.module.mybatis.EntityMybatisDao;
import com.jorge.testui.platform.entity.MockWithdrawOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 提现交易订单表 Mybatis Dao
 *
 * @author mufanglin
 * @date 2019-12-30 15:24:40
 */
public interface MockWithdrawOrderDao extends EntityMybatisDao<MockWithdrawOrder> {
 
 // 根据订单号查询（mock）提现流水订单表
 @Select("SELECT * FROM mock_withdraw_order where biz_order_no = #{bizOrderNo} ")
 MockWithdrawOrder findEntityByBizOrderNo(@Param("bizOrderNo") String bizOrderNo);
 
 @Select("SELECT * FROM mock_withdraw_order where biz_order_no = #{bizOrderNo} AND mock_notify_status IN ('N','F') AND type_source = #{typeSource} " +
         "AND mock_status IN ('INIT','PROCESSING') AND DATE_SUB(CURDATE(), INTERVAL 30 MINUTE) <= " +
         "create_time  AND mock_notify_count < 6 order by create_time desc  limit 1")
 MockWithdrawOrder findEntityByBizOrderNoAndTypeSource(@Param("bizOrderNo") String bizOrderNo, @Param("typeSource") String typeSource);
 
 // 初始化mock订单表流水信息
 @Update("INSERT INTO mock_withdraw_order (mock_order_no,amount,rec_account_no,rec_bank_name,rec_account_name,mock_status,biz_order_no,rec_bank_lasalle,rec_city,rec_province) " +
         " VALUES ( #{mockOrderNo},#{amount},#{recAccountNo},#{recBankName},#{recAccountName},#{mockStatus},#{bizOrderNo},#{recBankLasalle},#{recCity},#{recProvince} ) ")
 void saveMockWithdrawOrder(@Param("mockOrderNo") String mockOrderNo, @Param("amount") long amount, @Param("recAccountNo") String recAccountNo, @Param("recBankName") String recBankName,
                            @Param("recAccountName") String recAccountName, @Param("mockStatus") String mockStatus, @Param("bizOrderNo") String bizOrderNo, @Param("recBankLasalle") String recBankLasalle,
                            @Param("recCity") String recCity, @Param("recProvince") String recProvince);
 
 // 更新mock订单表流水信息
 @Select("update mock_withdraw_order set mock_notify_status = #{mockNotifyStatus} ,mock_notify_count = #{mockNotifyCount} ,mock_status = #{mockStatus} ,suc_amount = #{sucAmount} " +
         "where biz_order_no = #{bizOrderNo}")
 void updateMockNotifyStatusByBizOrderNo(@Param("bizOrderNo") String bizOrderNo, @Param("mockNotifyStatus") String mockNotifyStatus, @Param("mockNotifyCount") Integer mockNotifyCount,
                                         @Param("mockStatus") String mockStatus, @Param("sucAmount") long sucAmount);
 
 // 查询mock订单表流水信息
 @Select( "SELECT * FROM mock_withdraw_order where status IN ('US','BF','BP','BS') AND DATE_SUB(CURDATE(), INTERVAL 3 DAY)"
         + " <= create_time AND notify_inter_status IN ('N','F') AND notify_send_count<10")
 List<MockWithdrawOrder> yxtQuicklyWithdrawQuery();
 
 // 查询mock订单表流水信息
 @Select("SELECT * from mock_withdraw_order where settle_serial_no = #{settleSerialNo} and partner_id = #{partnerId}")
 MockWithdrawOrder findEntityBySsnAndPId(@Param("settleSerialNo") String settleSerialNo, @Param("partnerId") String partnerId);
 
 // 查询mock订单表流水信息
 @Select("SELECT * from mock_withdraw_order where bank_serial_no = #{bankSerialNo}")
 MockWithdrawOrder findEntityByBankSerialNo(@Param("bankSerialNo") String bankSerialNo);
 
 @Select("SELECT * FROM mock_withdraw_order where user_id = #{userNo} ")
 MockWithdrawOrder findEntityByUserNo(@Param("userNo") String userNo);
 
}
