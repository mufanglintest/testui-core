/*
 * acooly.cn Inc.
 * Copyright (c) 2016 All Rights Reserved.
 * create by zhangpu
 * date:2016年3月17日
 *
 */
package com.jorge.testui.marshall.json;


import com.jorge.testui.message.CaseBaseResponse;
import com.jorge.testui.marshall.CaseApiResponseMarshall;
import com.jorge.testui.utils.JsonMarshallor;
import org.springframework.stereotype.Component;

/**
 * 响应报文组装
 *
 * @author zhangpu
 */
@Component
public class JsonApiResponseMarshall extends AbstractResponseMarshall<String, CaseBaseResponse>
    implements CaseApiResponseMarshall<String, CaseBaseResponse> {

  @Override
  protected String doMarshall(CaseBaseResponse response) {
    return JsonMarshallor.INSTANCE.marshall(response);
  }
}
