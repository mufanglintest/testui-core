package com.jorge.testui.event;

import com.acooly.core.utils.Ids;
import com.acooly.module.event.EventHandler;
import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import com.jorge.testui.platform.entity.BatchInvoke;
import com.jorge.testui.platform.entity.BatchInvokeResult;
import com.jorge.testui.platform.entity.Parameters;
import com.jorge.testui.platform.service.BatchInvokeResultService;
import com.jorge.testui.platform.service.BatchInvokeService;
import lombok.extern.slf4j.Slf4j;
import net.engio.mbassy.listener.Handler;
import net.engio.mbassy.listener.Invoke;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-07-22 09:46
 */
@Slf4j
@EventHandler
public class BatchInvokeTestCaseEventHandler {
    @Autowired
    private BatchInvokeService batchInvokeService;
    @Autowired
    private BatchInvokeResultService batchInvokeResultService;
    //异步事件处理器
    @Handler(delivery = Invoke.Asynchronously)
    public void handleAddApiRequestDocEventAsyn(BatchInvokeTestCaseEvent event) {
        log.info("开始处理异步事件！");
        Date fromDate3 = new Date();
        log.info("开始时间:{}",fromDate3);
        String batchNo = Ids.getDid();
        int successCaseCount = 0;
        List<BatchInvokeResult> batchInvokeResults = new ArrayList<>();
        for (Parameters parameters:event.getParametersList()) {
            BatchInvokeResult batchInvokeResult = new BatchInvokeResult();
            String response = HttpRequest.get(event.getUrl() + "/case.do?requestType=parameters&caseNo="+parameters.getCaseNo()+"&parametersNo="+parameters.getParametersNo()).body();
            log.info("执行结果：{}",response);
            int invokeStatus = 0;
            JSONObject jsonResponse = JSONObject.parseObject(response);
            if (Boolean.valueOf(jsonResponse.getString("success"))){
                successCaseCount++;
                invokeStatus = 1;
            }
            batchInvokeResult.setBatchNo(batchNo);
            batchInvokeResult.setCaseNo(parameters.getCaseNo());
            batchInvokeResult.setParameterNo(parameters.getParametersNo());
            batchInvokeResult.setParameterRequest(parameters.getParameters());
            batchInvokeResult.setParameterResponse(jsonResponse.toJSONString());
            batchInvokeResult.setInvokeStatus(invokeStatus);
            batchInvokeResults.add(batchInvokeResult);
        }
        batchInvokeResultService.inserts(batchInvokeResults);
        Date toDate3 = new Date();
        long from3 = fromDate3.getTime();
        long to3 = toDate3.getTime();
        log.info("结束时间:{}",toDate3);
        int minutes = (int) ((to3 - from3) / 1000 );
        BatchInvoke batchInvoke = new BatchInvoke();
        batchInvoke.setBatchNo(batchNo);
        batchInvoke.setTotalCase(event.getParametersList().size());
        batchInvoke.setTotalTime(minutes);
        batchInvoke.setSuccessCase(successCaseCount);
        batchInvoke.setFailCase(event.getParametersList().size()-successCaseCount);
        batchInvokeService.save(batchInvoke);
        log.info("批量用例执行时间:{}秒，总执行用例数：{},成功数:{},失败数:{}",minutes,
                batchInvoke.getTotalCase(),
                batchInvoke.getSuccessCase(),
                batchInvoke.getFailCase());
        log.info("异步事件处理完成！");
    }
}
