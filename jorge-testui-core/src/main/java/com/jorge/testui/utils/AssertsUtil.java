package com.jorge.testui.utils;

import com.acooly.core.utils.Money;
import com.acooly.core.utils.StringUtils;
import com.jorge.testui.exception.CaseServiceException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.lang.reflect.Method;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2019-08-22 14:58
 */
@Slf4j
public class AssertsUtil {

    /**
     * 数据校验
     *
     * @param actual   真实值
     * @param expected 期望值
     * @return
     */
    public static void assertThan(Object actual, Object expected) {
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        Boolean assertSuccess = true;
        if (actual == null) {
            log.info("值为空");
            assertSuccess = false;
        }
        if (!actual.getClass().equals(expected.getClass())) {
            log.info("数据类型不匹配！");
            assertSuccess = false;
        }

        if (!actual.equals(expected)) {
            assertSuccess = false;
        }
        if (!assertSuccess) {
            int lastIndex = stacks[2].getClassName().lastIndexOf(".");
            String className = stacks[2].getClassName().substring(lastIndex+1);
            log.info("调用类名:{},方法名:{},行数{}",className,stacks[2].getMethodName(),stacks[2].getLineNumber());
            log.error("数据校验失败！期望类型【{}】,值【{}】。实际类型【{}】,值【{}】",
                    expected.getClass().getSimpleName(),
                    expected,
                    actual.getClass().getSimpleName(),
                    actual);
            throw new CaseServiceException("数据校验失败！");
        }
    }

    /**
     * 真实值 校验是否为空
     * @param expected
     */
    public static void assertNullOrEmpty(Object expected){
        if (!StringUtils.isEmpty(expected)) {
            log.error("数据校验失败！值【{}】。",
                    expected);
            throw new CaseServiceException("数据校验失败！");
        }
    }

    /**
     * 真实值 校验是否为空
     * @param expected
     */
    public static void assertNotNullOrEmpty(Object expected){
        if (StringUtils.isEmpty(expected)) {
            log.error("数据校验失败！值【{}】。",
                    expected);
            throw new CaseServiceException("数据校验失败！");
        }
    }

    public static void assertTrue(boolean ble) {
        Assert.assertTrue(ble);
    }
    
    public static void assertEquals(Object obj1, Object obj2) {
        Assert.assertEquals(obj1, obj2);
    }


    /**
     * 生成表的全字段校验方法
     * @param sourceClass
     * @param orderName
     */
    public static void printAssertMethods(Class<?> sourceClass, String orderName) {
        //存参数类型t
        Method[] methods = sourceClass.getMethods();
        System.out.println("<================assert方法====================>");
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (method.getName().length() <= 3) {
                continue;
            }
            String a = captureName(method.getName());
            if (method.getName().startsWith("set")) {
                System.out.println("AssertsUtil.assertThan("	+ orderName + ".get"
                        + a.substring(0, 1).toUpperCase() + a.substring(1) + "(),"+a+");");
            }
        }
        System.out.println();
    }

    /**
     * 获取set名，把第一个字母小写
     *
     * @param name
     * @return
     */
    public static String captureName(String name) {
        String para = name.substring(3);
        name = para.substring(0, 1).toLowerCase() + para.substring(1);
        return name;
    }
    
    public static void main(String[] args) {
        Long a = 1L;
        Money b = new Money(2);
        Long c = 2L;
//        assertThan(a, c);
        assertNotNullOrEmpty("990");

        //printAssertMethods(MusSignTransaction.class,"musSignTransaction");
    }


}
