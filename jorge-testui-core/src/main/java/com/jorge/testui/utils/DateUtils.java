package com.jorge.testui.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2019-12-09 14:01
 */
@Slf4j
public class DateUtils {
    /**
     * @param time
     */
    public static void sleepTime(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param time 以毫秒为单位
     */
    public static void sleepTimeMillisecond(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 以yyyy-MM-dd HH:mm:ss格式化时间
     *
     * @param date
     * @return
     */
    public static String getDateFormat(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = formatter.format(date);

        return formatDate;
    }

    /**
     * 以yyyy-MM-dd 格式化时间
     *
     * @param date
     * @return
     */
    public static String getShortDateFormat(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = formatter.format(date);

        return formatDate;
    }

    /**
     * MM大写表示月，mm小写表示分钟 大写 HH 意思是二十四小时制，相反，小写hh表示十二小时制 获取对应格式的日期
     *
     * @param date   需要获取的日期
     * @param format 需要的日期格式，如“YYYY-MM-dd HH:mm:ss”
     */
    public static String getDateFormat(Date date, String format) {

        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String formatDate = formatter.format(date);

        return formatDate;
    }

    /**
     * 获取格式yyyy-MM-dd HH:mm:ss任意时间
     *
     * @param strDate 如"2012-12-12 12:12:12"
     */
    public static Date getFormatDate(String strDate) {

        Date wannaDate = null;
        if (StringUtils.isBlank(strDate)) {
            return new Date();
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            wannaDate = sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return wannaDate;
    }

    /**
     * 字符串转化为指定时间格式
     *
     * @param strDate
     * @param format
     * @return
     */
    public static Date getFormatStringToDate(String strDate, String format) {
        Date wannaDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            wannaDate = sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return wannaDate;
    }

    public static Date simpleLongStr2Date(String strDate) {
        Date wannaDate = null;
        try {
            wannaDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return wannaDate;
    }

    /**
     * 获取当前时间
     *
     * @return返回短时间格式 yyyyMM
     */
    public static String getNowDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 传入指定时间和移动于指定时间的天数（指定时间前为负数，指定时间后为正数），</br>
     * 例如：获取2016-09-20 12:00:00的前一天（2016-09-20 12:00:00，-1），获得结果为2016-09-19 12:00:00</br>
     * 获取2016-09-20 12:00:00的后一天（2016-09-20 12:00:00，1），获得结果为2016-09-21 12:00:00
     *
     * @param date
     * @param number
     * @return
     */

    @SuppressWarnings("static-access")
    public static Date moveDay(Date date, int number) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(cal.DAY_OF_YEAR, number);
        return cal.getTime();
    }

    public static boolean getDateFormatss(Date date) {

        String time = "2017-09-27 11:20:45";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localTime = LocalDateTime.parse(getDateFormat(date), dtf);
        LocalDateTime startTime = LocalDate.now().atTime(0, 0, 0);
        LocalDateTime endTime = LocalDate.now().atTime(23, 59, 59);
        //如果小于今天的开始日期
        if (localTime.isBefore(startTime)) {
            return true;
        }
//		//如果大于今天的开始日期，小于今天的结束日期
//		if (localTime.isAfter(startTime) && localTime.isBefore(endTime)) {
//			System.out.println("时间是今天");
//		}
//		//如果大于今天的结束日期
//		if (localTime.isAfter(endTime)) {
//			System.out.println("时间是未来");
//		}
        return false;
    }

    public static void main(String[] args) {
        System.out.println(moveDay(new Date(),-1));
    }
}
