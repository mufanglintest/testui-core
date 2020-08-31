/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-07-16
 *
 */
package com.jorge.testui.platform.service;

import com.acooly.core.common.service.EntityService;
import com.jorge.testui.platform.entity.Project;

import java.util.List;

/**
 * project Service接口
 *
 * Date: 2019-07-16 16:08:56
 * @author mufanglin
 *
 */
public interface ProjectService extends EntityService<Project> {

    List<Project> findListProjectByProjectNo(String projectNo);
}
