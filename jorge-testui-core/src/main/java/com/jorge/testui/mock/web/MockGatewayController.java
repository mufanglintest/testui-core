package com.jorge.testui.mock.web;

import com.acooly.core.utils.Servlets;
import com.alibaba.fastjson.JSON;
import com.esotericsoftware.minlog.Log;
import com.jorge.testui.enums.MockTradeStatusEnum;
import com.jorge.testui.mock.web.common.result.MockResponseResult;
import com.jorge.testui.service.base.MockGatewayService;
import com.jorge.testui.service.factory.MockServiceFactory;
import com.jorge.testui.utils.JsonMarshallor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-03-23 12:42
 * /mock/gateway
 */
@Slf4j
@Controller
@RequestMapping(value = "/mock")
public class MockGatewayController {

    @Autowired
    MockServiceFactory mockServiceFactory;

    @RequestMapping(value = "/gateway",method = RequestMethod.POST)
    public void fmQuickPaymentService(@RequestBody String requestJson, HttpServletRequest request, HttpServletResponse response) throws Exception {
        MockResponseResult result = new MockResponseResult();
        try {
            String questString = requestJson;
            MockGatewayService mockGatewayService = mockServiceFactory.getMockGatewayService
                    (JSON.parseObject(questString).get("service").toString());
            result = (MockResponseResult) mockGatewayService.getResponseBean();
            
            result.setRequestData(questString);
            mockGatewayService.executeGateway(request,result);
        } catch (Exception e) {
            Log.error("执行失败", e);
            result.setStatus(MockTradeStatusEnum.TRADE_FAIL);
            result.setCode("fail");
            result.setDetail(e.getMessage());
        } finally {
            Servlets.writeText(response, JsonMarshallor.INSTANCE.marshall(result));
        }
    }
}
