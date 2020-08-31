package com.jorge.testui.servlet;

import com.jorge.testui.executer.HttpMockServiceExecuter;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-05-03 17:24
 */
@Slf4j
public class MockDispatchServlet extends AbstractSpringServlet {


    private static final long serialVersionUID = 8626836189767261535L;

    private HttpMockServiceExecuter httpMockServiceExecuter;
    @Override
    protected void doInit() {
        httpMockServiceExecuter = getWebApplicationContext().getBean(HttpMockServiceExecuter.class);
    }

    @Override
    protected void doService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        httpMockServiceExecuter.execute(request, response);
    }
}
