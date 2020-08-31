package com.jorge.testui.task;

import com.acooly.module.scheduler.api.ScheduleCallBackService;
import com.alibaba.dubbo.config.annotation.Service;
import com.jorge.testui.platform.service.ExecuteLogService;
import com.jorge.testui.platform.service.LogInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2019-12-17 15:03
 */
@Slf4j
@Service(version = "1.0",group ="com.jorge.testui.task.DeleteLogsSchedule")
public class DeleteLogsSchedule implements ScheduleCallBackService {

    @Autowired
    private LogInfoService logInfoService;

    @Autowired
    private ExecuteLogService executeLogservice;

    @Override
    public void justDoIT() {
        //删除三十天内的执行日志
        log.info("定时任务开始执行删除日志！");
        logInfoService.deleteLogInfoByCreateTime();
        executeLogservice.deleteExecuteLogByCreateTime();
        log.info("定时任务执行删除日志结束！");
    }
}
