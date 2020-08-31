/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-07-16
 */
package com.jorge.testui.platform.web;

import com.acooly.core.common.web.AbstractJQueryEntityController;
import com.acooly.core.utils.Servlets;
import com.acooly.core.utils.StringUtils;
import com.jorge.testui.platform.entity.Interface;
import com.jorge.testui.platform.entity.Project;
import com.jorge.testui.platform.service.InterfaceService;
import com.jorge.testui.platform.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * interface 管理控制器
 *
 * @author mufanglin
 * Date: 2019-07-16 16:08:56
 */
@Controller
@RequestMapping(value = "/manage/jorge/interface")
public class InterfaceManagerController extends AbstractJQueryEntityController<Interface, InterfaceService> {


    {
        allowMapping = "*";
    }

    @Autowired
    private ProjectService projectService;

    @SuppressWarnings("unused")
    @Autowired
    private InterfaceService interfaceService;


    @Override
    protected void referenceData(HttpServletRequest request, Map<String, Object> model) {
        String projectNo = Servlets.getParameter("projectNo");
        List<Project> projects;
        if (!StringUtils.isEmpty(projectNo)){
            projects = projectService.findListProjectByProjectNo(projectNo);
        }else {
            projects = projectService.getAll();
        }
        Map<String, String> allProducts = projects.stream().collect(Collectors.toMap(Project::getProjectNo, Project::getProjectName));
        model.put("allProjectNos", allProducts);
    }

}
