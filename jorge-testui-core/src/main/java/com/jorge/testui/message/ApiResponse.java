package com.jorge.testui.message;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-10-28 12:04
 */
@Getter
@Setter
public class ApiResponse extends CaseBaseResponse {
    JSONObject responseEntity = new JSONObject();
}
