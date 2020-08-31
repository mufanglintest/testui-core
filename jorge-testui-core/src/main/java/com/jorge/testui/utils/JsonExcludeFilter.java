/**
 * jorge-testui-parent
 * <p>
 * Copyright 2019 Acooly.cn, Inc. All rights reserved.
 *
 * @author zhike
 * @date 2019-07-31 16:40
 */
package com.jorge.testui.utils;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.SerialContext;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhike
 * @date 2019-07-31 16:40
 */
@Slf4j
public class JsonExcludeFilter implements PropertyPreFilter {

    private final Class<?> clazz;
    private final Set<String> includes = new HashSet<String>();
    private final Set<String> excludes = new HashSet<String>();
    private int maxLevel = 0;

    public JsonExcludeFilter(String... properties) {
        this(null, properties);
    }

    public JsonExcludeFilter(Class<?> clazz, String... properties) {
        super();
        this.clazz = clazz;
        for (String item : properties) {
            if (item != null) {
                this.excludes.add(item);
            }
        }
    }

    /**
     * @since 1.2.9
     */
    public int getMaxLevel() {
        return maxLevel;
    }

    /**
     * @since 1.2.9
     */
    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public Set<String> getIncludes() {
        return includes;
    }

    public Set<String> getExcludes() {
        return excludes;
    }

    @Override
    public boolean apply(JSONSerializer serializer, Object source, String name) {
        if (source == null) {
            return true;
        }

        if (clazz != null && !clazz.isInstance(source)) {
            return true;
        }

        if (this.excludes.contains(name)) {
            return false;
        }

        if (maxLevel > 0) {
            int level = 0;
            SerialContext context = serializer.getContext();
            while (context != null) {
                level++;
                if (level > maxLevel) {
                    return false;
                }
                context = context.parent;
            }
        }

        if (includes.size() == 0 || includes.contains(name)) {
            return true;
        }

        return false;
    }
}
