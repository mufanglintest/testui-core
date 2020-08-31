/**
 * jorge-testui-parent
 * <p>
 * Copyright 2019 Acooly.cn, Inc. All rights reserved.
 *
 * @author zhike
 * @date 2019-07-19 09:53
 */
package com.jorge.testui.message;

import com.acooly.core.common.facade.InfoBase;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.concurrent.BlockingDeque;

/**
 *
 * @author zhike
 * @date 2019-07-19 09:53
 */
@Getter
@Setter
public abstract class CaseMessage extends InfoBase {

    /**
     * 用例编码
     */
    @NotEmpty
    private String caseNo;

    /**
     * 参数编号
     */
    private String parameterNo;

    /**
     * 公共会话
     * 调用端的API调用会话参数，请求参数任何合法值，在响应时会回传给调用端
     */
    @Size(max = 1024)
    private String context;

    @Size(max = 1024)
    private String apiResponse;

    /**
     * 请求地址
     */
    private String gatewayUrl;

    /**
     * 执行是否成功
     */
    private Boolean success = false;

    private Boolean status = false;


}
