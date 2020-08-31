/*
 * acooly.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */
package com.jorge.testui.servlet;

import com.jorge.testui.executer.HttpCaseServiceExecuter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用例框架入口
 *
 * @author zhike
 * @date 2014年8月3日
 */
public class CaseApiDispatchServlet extends AbstractSpringServlet {

  /** UID */
  private static final long serialVersionUID = -2915513005298196286L;

  private HttpCaseServiceExecuter httpCaseServiceExecuter;

  @Override
  protected void doInit() {
    httpCaseServiceExecuter = getWebApplicationContext().getBean(HttpCaseServiceExecuter.class);
  }

  @Override
  protected void doService(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    httpCaseServiceExecuter.execute(request, response);
  }
}
