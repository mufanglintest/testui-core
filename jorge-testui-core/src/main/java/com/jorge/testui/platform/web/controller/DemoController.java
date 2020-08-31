package com.jorge.testui.platform.web.controller;

import com.acooly.core.utils.Servlets;
import com.acooly.module.security.domain.User;
import com.acooly.openapi.framework.client.OpenApiClient;
import com.acooly.openapi.framework.common.dto.ApiMessageContext;
import com.acooly.openapi.framework.common.utils.ApiUtils;
import com.jorge.testui.platform.entity.Parameters;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author qiubo
 */
@Controller
@RequestMapping("/openapi/")
@Slf4j
public class DemoController {

    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String demo() {
        System.out.println("123c");
        return "index";
    }


    public void executer(HttpServletRequest request, Map<String, Object>  model){
        List<Parameters>   list = new ArrayList();

        while (list.iterator().hasNext()){
            Parameters parameters = list.iterator().next();

        }

    }

    @RequestMapping(value = {"lookuser"})
    protected void copy(HttpServletRequest request, Map<String, Object> model){
        User user = getSessionUser();
        System.out.println(user.getUsername());
        return ;
    }

    /**
     * 获取当前登录会员
     */
    private User getSessionUser() {
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 注意：
     * 1、openApiClient可以通过参数配置：AccessKey,SecretKey和网关地址
     * 2、可以手动通过构造函数设置和初始化
     */
    @Autowired
    private OpenApiClient openApiClient;

    @RequestMapping("testApiNotify")
    public void meta(HttpServletRequest request, HttpServletResponse response) {
        try {
            ApiMessageContext messageContext = ApiUtils.getApiRequestContext(request);
//            ApiMessageContext messageContext = openApiClient.verify(request);
            log.info("客户端 接收异步通知 验签成功。");
            log.info("客户端 接收异步通知 header: {}", messageContext.getHeaders());
            log.info("客户端 接收异步通知 params: {}", messageContext.getParameters());
            log.info("客户端 接收异步通知 body: {}", messageContext.getBody());
            Servlets.writeText(response, "success");
            log.info("客户端 接收异步通知 回写 success");
        } catch (Exception e) {
            log.info("客户端 接收异步通知 验签失败！");
        }
    }
}
