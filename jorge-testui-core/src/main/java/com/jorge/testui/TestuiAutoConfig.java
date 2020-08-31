package com.jorge.testui;

import com.jorge.testui.utils.JorgeCommonProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static com.jorge.testui.utils.JorgeCommonProperties.PREFIX;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-08-27 09:04
 */
@Configuration
@EnableConfigurationProperties({JorgeCommonProperties.class})
@ConditionalOnProperty(value = PREFIX+"configuration.enable", matchIfMissing = true)
@ComponentScan(basePackages = {"com.jorge.testui"})
//@MapperScan(basePackages = "com.jorge.testui")
public class TestuiAutoConfig {
    @Autowired
    private JorgeCommonProperties jorgeCommonProperties;


}
