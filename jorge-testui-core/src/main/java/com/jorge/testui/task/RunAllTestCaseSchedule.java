package com.jorge.testui.task;

import com.acooly.module.scheduler.api.ScheduleCallBackService;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import com.jorge.testui.platform.entity.Parameters;
import com.jorge.testui.platform.entity.Project;
import com.jorge.testui.platform.service.ParametersService;
import com.jorge.testui.platform.service.ProjectService;
import com.jorge.testui.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-01-13 09:20
 */
@Slf4j
@Service(version = "1.0",group ="com.jorge.testui.task.RunAllTestCaseSchedule")
public class RunAllTestCaseSchedule implements ScheduleCallBackService {
    @Autowired
    ProjectService projectService;

    @Autowired
    ParametersService parametersService;

    @Override
    public void justDoIT() {
        Integer totalCase = 0;
        Integer successCase = 0;
        log.info("开始回归！");
        Map<String,String> attachments = RpcContext.getContext().getAttachments();
        List<Parameters> parameters = parametersService.getAll();
        Date fromDate3 = new Date();
        log.info("开始时间:{}",fromDate3);
        totalCase = parameters.size();
        for (Parameters p: parameters
             ) {
            Map<String,String> map = new HashMap<>();
            map.put("requestType","parameters");
            map.put("caseNo",p.getCaseNo());
            map.put("parametersNo",p.getParametersNo());
            String response = HttpRequest.get("http://127.0.0.1:8999/case.do",map,true).body();
            if (StringUtils.isNotEmpty(response)){
                JSONObject jsonObject = JSON.parseObject(response);
                if(jsonObject.getBoolean("success")!= null && jsonObject.getBoolean("success")) {
                    successCase += 1;
                }
            }
        }
        Date toDate3 = new Date();
        long from3 = fromDate3.getTime();
        long to3 = toDate3.getTime();
        log.info("结束时间:{}",toDate3);
        int minutes = (int) ((to3 - from3) / (1000 * 60));
        log.info("总共执行用例数:{},成功用例数:{},失败用例数:{},总共执行时间:{}分钟。",totalCase,successCase,totalCase - successCase,minutes);
        log.info("回归结束！");
    }

    public static void main(String[] args) {
        Map<String ,String> map = new HashMap<>();
        map.put("requestType","parameters");
        map.put("caseNo","TradeFacadeQuickPaymentApplyTestFailTwo");
        map.put("parametersNo","1001");
        String s = HttpRequest.get("http://127.0.0.1:8999/case.do",map,true).body();
        System.out.println("111:"+s);
        JSONObject jsonObject = JSON.parseObject(s);
        System.out.println("222:"+jsonObject);
        if (StringUtils.isNotEmpty(s)) {
            if (jsonObject.getBoolean("success")) {
                System.out.println("000:" + s);
            } else {
                System.out.println(123);
            }
        }

    }
}
