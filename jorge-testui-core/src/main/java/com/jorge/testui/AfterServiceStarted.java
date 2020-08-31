package com.jorge.testui;

import com.acooly.module.event.EventBus;
import com.jorge.testui.event.AddApiRequestDocEvent;
import com.jorge.testui.service.factory.CaseServiceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2019-07-31 19:43
 */
@Component
@Slf4j
public class AfterServiceStarted implements ApplicationRunner {

    @Autowired
    CaseServiceFactory caseServiceFactory;

    @Autowired
    EventBus eventBus;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        //启动时发布事件，异步处理将所有的ApiRequest写入到数据库中
        log.info("发布事件开始！");
        AddApiRequestDocEvent addApiRequestDocEvent = new AddApiRequestDocEvent();
        addApiRequestDocEvent.setApiRequestDoc(caseServiceFactory.getCaseApiRequestMap());
        eventBus.publish(addApiRequestDocEvent);

        log.info("发布事件结束！");

    }
}
