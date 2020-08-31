package com.jorge.testui.enums;
/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-03-23 11:43
 */

import com.acooly.core.utils.enums.Messageable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum GatewayChannelApiEnum implements Messageable {
    TEST("TEST","测试"),
    FMPayQueryService("FMPayQueryService", "富民支付查询服务"),
    FMPayWeixinJsService("FMPayWeixinJsService", "富民微信公众号(线上)"),
    FMPayWeixinJsOfflineService("FMPayWeixinJsOfflineService", "富民微信公众号(线下)"),
    ChinaumsWeixinAppService("ChinaumsWeixinAppService", "银联商务微信APP服务"),
    ChinaumsQueryService("ChinaumsQueryService", "银联商务微信APP服务"),
    ChinaumsRefundService("ChinaumsRefundService", "银商交易退款"),
    ChinaumsRefundQueryService("ChinaumsRefundQueryService", "银商交易退款查询"),
    
    CpcnQuickPaymentService("CpcnQuickPaymentService", "中金快捷支付"),
    
    QuickPaymentConsumeSms("QuickPaymentConsumeSms", "富民快捷支付短信申请"),
    TradeQuickPaymentConsume("TradeQuickPaymentConsume", "富民快捷支付确认"),
    
    FmAccountIIRechargeService("FmAccountIIRechargeService", "富民II类户资金转入"),
    FmAccountIIWithdrawService("FmAccountIIWithdrawService", "富民II类账户资金转出"),
    FmAccountIIRegisterInfoReviewService("FmAccountIIRegisterInfoReviewService","二类户开户资料提交"),
    FmAccountIIOpenAccountService("FmAccountIIOpenAccountService","二类户开户"),
    FmAccountIIBalanceQueryService("FmAccountIIBalanceQueryService","二类户余额查询"),
    
    FmPaidTransferService("FmPaidTransferService", "富民企富通代付转账"),
    FmConsumeLedgerService("FmConsumeLedgerService", "富民企富通商户消费分账"),
    FMPayAlipayNativeService("FMPayAlipayNativeService", "富民支付宝扫码支付服务"),
    FMPayAlipayScanCodeService("FMPayAlipayScanCodeService", "富民银联(支付宝)条码支付服务"),
    FMPayAlipayServiceWindowService("FMPayAlipayServiceWindowService", "富民支付宝服务窗支付服务"),
    FmQuickPaymentSignService("FmQuickPaymentSignService", "富民快捷绑卡"),
    FmQuickPaymentSignQueryService("FmQuickPaymentSignQueryService", "富民快捷绑卡查询"),
    FmVerifyTransferService("FmVerifyTransferService", "富民企富通账户转账"),
    FmAccountBalanceQueryService("FmAccountBalanceQueryService", "富民企富通账户查询"),
    FmSignBindCardService("FmSignBindCardService","富民企富通绑卡签约申请"),
    FmSignBindCardConfirmService("FmSignBindCardConfirmService","富民企富通绑卡签约确认"),
    FmDownloadElectronicCredentialsService("FmDownloadElectronicCredentialsService","电子回单下载"),
    CpcnSignBindCardService("CpcnSignBindCardService","中金快捷绑卡签约申请"),
    CpcnSignBindCardConfirmService("CpcnSignBindCardConfirmService","中金快捷绑卡签约确认"),
    CpcnUnSignBindCardService("CpcnUnSignBindCardService","中金快捷绑卡解约"),
    FMPayWeixinScanCodeOfflineService("FMPayWeixinScanCodeOfflineService","富民银联(微信)条码支付服务-线下"),
    FMPayWeixinScanCodeService("FMPayWeixinScanCodeService","富民银联(微信)条码支付服务-线上"),
    FMPayWeixinMiniProgramPayOfflineService("FMPayWeixinMiniProgramPayOfflineService","富民银联(微信)小程序支付服务-线下"),
    FMPayWeixinMiniProgramPayService("FMPayWeixinMiniProgramPayService","富民银联(微信)小程序支付服务-线上"),
    FbankqftVerifyWithdrawalsService("FbankqftVerifyWithdrawalsService","富民企富通账户提现"),

    FmQueryPalmAccountTradeDetailService("FmQueryPalmAccountTradeDetailService", "富民企富通托底账户资金交易明细查询"),
    HaierNetBankPayService("HaierNetBankPayService", "海尔网银下单服务"),
    HaierTradeQueryService("HaierTradeQueryService", "海尔交易订单查询"),

    ShchinaumsWeixinMiniProgramService("ShchinaumsWeixinMiniProgramService","上海银商微信小程序服务"),
    ShchinaumsWeixinRawH5Service("ShchinaumsWeixinRawH5Service","上海银商微信H5(wap)服务"),
    ShchinaumsQueryService("ShchinaumsQueryService","上海银联商务查询"),
    ShchinaumsRefundService("ShchinaumsRefundService", "上海银联商务交易退款"),

    FMTradeRefundQueryService("FMTradeRefundQueryService","富民交易退款查询"),
    FMTradeRefundService("FMTradeRefundService", "富民交易退款")
    ;
    
    private final String code;
    private final String message;

    GatewayChannelApiEnum(String code, String message) {
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
        for (GatewayChannelApiEnum type : values()) {
            map.put(type.getCode(), type.getMessage());
        }
        return map;
    }

    /**
     * 通过枚举值码查找枚举值。
     *
     * @param code 查找枚举值的枚举值码。
     * @return 枚举值码对应的枚举值。
     * @throws IllegalArgumentException 如果 code 没有对应的 Status 。
     */
    public static GatewayChannelApiEnum find(String code) {
        for (GatewayChannelApiEnum status : values()) {
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
    public static List<GatewayChannelApiEnum> getAll() {
        List<GatewayChannelApiEnum> list = new ArrayList<GatewayChannelApiEnum>();
        for (GatewayChannelApiEnum status : values()) {
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
        for (GatewayChannelApiEnum status : values()) {
            list.add(status.code());
        }
        return list;
    }

}
