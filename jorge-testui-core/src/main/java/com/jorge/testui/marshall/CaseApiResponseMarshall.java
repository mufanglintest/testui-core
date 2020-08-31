/*
 * acooly.cn Inc.
 * Copyright (c) 2016 All Rights Reserved.
 * create by zhangpu
 * date:2016年3月17日
 *
 */
package com.jorge.testui.marshall;


import com.jorge.testui.message.CaseBaseResponse;

/**
 * 同步响应组装
 *
 * @param <T>
 * @param <S>
 * @author zhangpu
 */
public interface CaseApiResponseMarshall<T, S extends CaseBaseResponse> extends CaseApiMarshall<T, S> {}
