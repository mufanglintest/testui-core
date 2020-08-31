package com.jorge.testui.config;

import com.acooly.core.common.boot.Apps;
import com.acooly.module.jpa.JPAProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2019-11-27 10:24
 */
@Slf4j
@Configuration
public class JpaExclude {


    @Bean

    public JpaExcludeProcessor jpaExcludeProcessor() {
        return new JpaExcludeProcessor();
    }


    public static class JpaExcludeProcessor implements BeanPostProcessor {

        @Override
        public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {

            if (o instanceof LocalContainerEntityManagerFactoryBean) {

                JPAProperties properties = Apps.getApplicationContext().getBean(JPAProperties.class);
                List<String> packages = properties.getEntityPackagesToScan().entrySet()
                        .stream().filter(e -> !e.getValue().
                                contains(Apps.getBasePackage())).
                                map(e -> e.getValue()).collect(Collectors.toList());

                ((LocalContainerEntityManagerFactoryBean) o).
                        setPackagesToScan(packages.toArray(new String[packages.size()]));

            }
            return o;
        }

        @Override
        public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
            return o;
        }
    }

}
