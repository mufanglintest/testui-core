/**
 * jorge-testui-parent
 * <p>
 * Copyright 2019 Acooly.cn, Inc. All rights reserved.
 *
 * @author zhike
 * @date 2019-07-19 09:50
 */
package com.jorge.testui.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 *
 * @author zhike
 * @date 2019-07-19 09:50
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface CaseApiService {

    /**
     * 用例编码
     * @return
     */
    String caseNo();

    /**
     * 用例描述
     * @return
     */
    String desc();

    /**
     * 用例的开发人员
     * @return
     */
    String owner() default "unknown";
}
