package com.jorge.testui.service.base;

import com.acooly.core.common.facade.ResultBase;
import com.jorge.testui.message.CaseBaseRequest;
import com.jorge.testui.message.CaseBaseResponse;
import com.jorge.testui.utils.GenericsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-03-23 14:45
 */
@Slf4j
public abstract class AbstractMockGatewayService<O,R extends ResultBase> implements MockGatewayService<O,R> {
    private Class<O> orderClazz;
    private Class<R> resultClazz;

    @Override
    public O getGatewayOrderBean() {
        if (orderClazz == null) {
            orderClazz = GenericsUtils.getSuperClassGenricType(getClass(), 0);
        }
        try {
            if (orderClazz.equals(Object.class)) {
                return (O) new CaseBaseRequest();
            } else {
                return BeanUtils.instantiate(orderClazz);
            }
        } catch (Exception e) {
            throw new RuntimeException("实例化Request对象失败:" + orderClazz.toString());
        }
    }

    @Override
    public R getResponseBean() {
        if (resultClazz == null) {
            resultClazz = GenericsUtils.getSuperClassGenricType(getClass(), 1);
        }
        try {
            if (resultClazz.equals(Object.class)) {
                return (R) new ResultBase();
            } else {
                return BeanUtils.instantiate(resultClazz);
            }
        } catch (Exception e) {
            throw new RuntimeException("实例化Response对象失败:" + resultClazz.toString());
        }
    }
}
