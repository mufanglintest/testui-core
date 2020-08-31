/**
 * jorge-testui-parent
 * <p>
 * Copyright 2019 Acooly.cn, Inc. All rights reserved.
 *
 * @author zhike
 * @date 2019-07-29 17:18
 */
package com.jorge.testui.shop.dao;

import com.acooly.module.ds.AbstractJdbcTemplateDao;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zhike
 * @date 2019-07-29 17:18
 */
//@Service("shopDao")
@Slf4j
public class ShopDao extends AbstractJdbcTemplateDao {

    @Resource(name = "shopJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> querySql(String sql) {
        List<Map<String, Object>> lists = Lists.newArrayList();
        try {
            lists = jdbcTemplate.queryForList(sql);
            log.info("执行结果：{}",lists);
        } catch (Exception e) {
            throw new RuntimeException("数据查询错误,请检查sql语句是否可以执行" + e);
        }
        return lists;
    }
}
