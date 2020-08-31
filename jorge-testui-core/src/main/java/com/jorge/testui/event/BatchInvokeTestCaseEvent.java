package com.jorge.testui.event;

import com.jorge.testui.platform.entity.Parameters;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-07-22 09:44
 */
@Getter
@Setter
public class BatchInvokeTestCaseEvent {
    private String url;
    private List<Parameters> parametersList;
}
