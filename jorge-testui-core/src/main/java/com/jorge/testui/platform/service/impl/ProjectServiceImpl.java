/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-07-16
 */
package com.jorge.testui.platform.service.impl;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.platform.dao.ProjectDao;
import com.jorge.testui.platform.entity.Project;
import com.jorge.testui.platform.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * project Service实现
 * <p>
 * Date: 2019-07-16 16:08:56
 *
 * @author mufanglin
 */
@Service("projectService")
public class ProjectServiceImpl extends EntityServiceImpl<Project, ProjectDao> implements ProjectService {

    @Override
    public List<Project> findListProjectByProjectNo(String projectNo) {
        return this.getEntityDao().findListProjectByProjectNo(projectNo);
    }
}
