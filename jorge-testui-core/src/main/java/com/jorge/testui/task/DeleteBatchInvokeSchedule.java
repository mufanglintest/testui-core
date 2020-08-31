package com.jorge.testui.task;

import com.acooly.module.scheduler.api.ScheduleCallBackService;
import com.alibaba.dubbo.config.annotation.Service;
import com.jorge.testui.platform.service.BatchInvokeResultService;
import com.jorge.testui.platform.service.BatchInvokeService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-07-22 08:57
 */
@Slf4j
@Service(version = "1.0",group ="com.jorge.testui.task.DeleteBatchInvokeSchedule")
public class DeleteBatchInvokeSchedule implements ScheduleCallBackService {
    @Resource
    BatchInvokeService batchInvokeService;

    @Resource
    BatchInvokeResultService batchInvokeResultService;

    @Override
    public void justDoIT() {
        log.info("定时任务开始执行删除批量执行日志！");
        batchInvokeService.deleteBatchInvokeByCreateTime();
        batchInvokeResultService.deleteBatchInvokeResultByCreateTime();
        log.info("定时任务结束执行删除批量执行日志！");
    }
}
