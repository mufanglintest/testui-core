package com.jorge.testui.event;

import com.acooly.module.event.EventHandler;
import com.jorge.testui.platform.entity.CaseRequestParameter;
import com.jorge.testui.platform.service.CaseRequestParameterService;
import lombok.extern.slf4j.Slf4j;
import net.engio.mbassy.listener.Handler;
import net.engio.mbassy.listener.Invoke;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2019-07-31 18:11
 */
@Slf4j
@EventHandler
public class AddApiRequestDocEventHandler {

    @Autowired
    private CaseRequestParameterService caseRequestParameterService;
    //同步事件处理器
//    @Handler
//    public void handleAddApiRequestDocEvent(AddApiRequestDocEvent event) {
//        log.info("1234事件处理！");
//        //do what you like
//    }
    //异步事件处理器
    @Handler(delivery = Invoke.Asynchronously)
    public void handleAddApiRequestDocEventAsyn(AddApiRequestDocEvent event) {
        log.info("开始处理异步事件！");
        caseRequestParameterService.deleteCaseRequestParameterAll();
        Map<String,String> apiRequestDoc = event.getApiRequestDoc();
        for (Map.Entry<String, String> entry : apiRequestDoc.entrySet()) {
            CaseRequestParameter caseRequestParameter = new CaseRequestParameter();
            caseRequestParameter.setCaseNo(entry.getKey());
            caseRequestParameter.setRequestDemo(entry.getValue());
            caseRequestParameterService.save(caseRequestParameter);
        }
        log.info("异步事件处理完成！");
        //do what you like
    }
}
