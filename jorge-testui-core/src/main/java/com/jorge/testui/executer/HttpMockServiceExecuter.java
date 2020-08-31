package com.jorge.testui.executer;

import com.acooly.core.utils.Servlets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-05-03 17:47
 */
@Slf4j
@Component
public class HttpMockServiceExecuter {
    public void execute(HttpServletRequest request, HttpServletResponse response){
        System.out.println("开始搞事情！！");
        System.out.println();

        for (String key : Servlets.getParameters(request).keySet()){
            System.out.println("keys:"+key);
        }
        response.setStatus(200);
    }
}
