/*
 * acooly.cn Inc.
 * Copyright (c) 2016 All Rights Reserved.
 * create by zhangpu
 * date:2016年3月17日
 *
 */
package com.jorge.testui.marshall;


import com.jorge.testui.enums.CaseApiProtocol;

/**
 * 组装接口
 *
 * @author zhangpu
 */
public interface CaseApiMarshall<T, S> {

  T marshall(S source);

  CaseApiProtocol getProtocol();
}
