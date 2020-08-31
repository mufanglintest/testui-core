/*
 * acooly.cn Inc.
 * Copyright (c) 2016 All Rights Reserved.
 * create by zhangpu
 * date:2016年3月17日
 *
 */
package com.jorge.testui.marshall;

import com.jorge.testui.message.CaseBaseRequest;

/**
 * 请求报文组装接口
 *
 * @author zhangpu
 * @param <T>
 */
public interface CaseApiRequestMarshall<T extends CaseBaseRequest, S> extends CaseApiMarshall<T, S> {

  @Override
  T marshall(S source);
}
