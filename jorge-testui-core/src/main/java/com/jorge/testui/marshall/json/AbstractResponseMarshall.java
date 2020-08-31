/*
 * acooly.cn Inc.
 * Copyright (c) 2016 All Rights Reserved.
 * create by zhangpu
 * date:2016年3月17日
 *
 */
package com.jorge.testui.marshall.json;

import com.jorge.testui.enums.CaseApiProtocol;
import com.jorge.testui.marshall.CaseApiMarshall;
import com.jorge.testui.message.CaseBaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * API返回报文抽象实现
 *
 * <p>Created by zhangpu on 2015/11/19.
 */
@Slf4j
public abstract class AbstractResponseMarshall<T, S extends CaseBaseResponse>
    implements CaseApiMarshall<T, S> {

  @Override
  public T marshall(CaseBaseResponse response) {
    T result = doMarshall(response);
    doLogger(response,result);
//    caseContext.setResponseBody((String) result);
    return result;
  }

  abstract T doMarshall(CaseBaseResponse response);


  /**
   * 日志
   *
   * @param caseApiResponse
   * @param marshallData
   */
  protected void doLogger(CaseBaseResponse caseApiResponse, T marshallData) {
    log.info(StringUtils.trimToEmpty(getLogLabel(caseApiResponse)) + marshallData.toString());
  }

  protected String getLogLabel(CaseBaseResponse caseApiResponse) {
    String labelPostfix =
            (StringUtils.isNotBlank(caseApiResponse.getCaseNo())
                    ? "[" + caseApiResponse.getCaseNo() + "]:"
                    : ":");
      return "服务响应" + labelPostfix;
  }

  @Override
  public CaseApiProtocol getProtocol() {
    return CaseApiProtocol.JSON;
  }


}
