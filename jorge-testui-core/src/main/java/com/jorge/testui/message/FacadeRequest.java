package com.jorge.testui.message;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2019-11-01 15:14
 */
@Getter
@Setter()
public class FacadeRequest extends CaseBaseRequest {

    private String resultCode = "SUCCESS";

    private String resultMessage ="成功";
}
