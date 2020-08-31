/*
 * mufl.com Inc.
 * Copyright (c) 2019 All Rights Reserved.
 * create by mufanglin
 * date:2019-07-16
 */
package com.jorge.testui.platform.service.impl;

import com.acooly.core.common.service.EntityServiceImpl;
import com.jorge.testui.platform.dao.InterfaceDao;
import com.jorge.testui.platform.entity.Interface;
import com.jorge.testui.platform.service.InterfaceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * interface Service实现
 *
 * Date: 2019-07-16 16:08:56
 *
 * @author mufanglin
 *
 */
@Service("interfaceService")
public class InterfaceServiceImpl extends EntityServiceImpl<Interface, InterfaceDao> implements InterfaceService {

    @Override
    public List<Interface> findListInterfaceByProjectNo(String projectNo) {
        return this.getEntityDao().findListInterfaceByProjectNo(projectNo);
    }
}
