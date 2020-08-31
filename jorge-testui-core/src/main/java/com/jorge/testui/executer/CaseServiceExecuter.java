/**
 * jorge-testui-parent
 * <p>
 * Copyright 2019 Acooly.cn, Inc. All rights reserved.
 *
 * @author zhike
 * @date 2019-07-19 10:10
 */
package com.jorge.testui.executer;


/**
 *
 * @author zhike
 * @date 2019-07-19 10:10
 */
public interface CaseServiceExecuter<R,T> {

    void execute(R request, T response);
}
