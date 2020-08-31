package com.jorge.testui;

import com.acooly.core.common.boot.component.ComponentInitializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-08-27 09:02
 */
@Slf4j
public class TestuiComponentInitializer implements ComponentInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        setPropertyIfMissing(
                "acooly.security.xss.exclusions.mail", "/manage/jorge/*");
    }

}
