/**
 * jorge-testui-parent
 * <p>
 * Copyright 2019 Acooly.cn, Inc. All rights reserved.
 *
 * @author zhike
 * @date 2019-07-19 09:55
 */
package com.jorge.testui.message;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author zhike
 * @date 2019-07-19 09:55
 */
@Getter
@Setter
public class CaseBaseResponse extends CaseMessage {

    /**
     * 执行完用例后是否删除数据
     */
    private Boolean isEndDelete = true;
}
