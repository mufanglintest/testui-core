package com.jorge.testui.utils;

import com.acooly.core.utils.Exceptions;
import com.esotericsoftware.minlog.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2021-01-05 10:55
 */
@Slf4j
public class AssertCommonUtils {
    /**
     * 校验对象
     * @param o1 传入期望对象
     * @param o2 传入数据库查询出值对象
     */
    public static void assertUtil(Object o1,Object o2){
        Field[] field = o1.getClass().getDeclaredFields();
        for(int i = 0;i<field.length;i++){
            field[i].setAccessible(true);
            String fieldName = field[i].getName();
            try {
                Field[] field1 = o2.getClass().getDeclaredFields();
                if (field[i].get(o1) != null && StringUtils.isNotEmpty(field[i].get(o1).toString())){
                    for (int j = 0; j < field1.length; j++) {
                        field1[j].setAccessible(true);
                        String fieldName1 = field1[j].getName();
                        if (fieldName.equals(fieldName1)){
                            log.info("校验参数："+fieldName);
                            AssertsUtil.assertThan(field1[j].get(o2),field[i].get(o1));
                            break;
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                Log.error("", e);
                throw Exceptions.rethrowBusinessException(e);
            }
        }
    }

}
