/*
 * acooly.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * qiubo@qq.com 2017-07-27 13:53 创建
 *
 */
package com.jorge.testui.utils;

import com.acooly.core.utils.Money;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.jorge.testui.convert.ApiServiceConversionService;

import java.io.IOException;
import java.lang.reflect.Type;

/** @author qiubo@qq.com */
public class MoneySerializer implements ObjectSerializer {

  public static final MoneySerializer INSTANCE = new MoneySerializer();

  private MoneySerializer() {}

  @Override
  public void write(
      JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features)
      throws IOException {
    SerializeWriter out = serializer.getWriter();
    Money value = (Money) object;
    if (value == null) {
      out.writeNull();
      return;
    }
    out.writeString(ApiServiceConversionService.INSTANCE.convert(value, String.class));
  }
}
