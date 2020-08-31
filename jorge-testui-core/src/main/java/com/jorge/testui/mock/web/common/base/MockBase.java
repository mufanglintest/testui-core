/*
 * www.cnvex.cn

 Inc.
 * Copyright (c) 2018 All Rights Reserved.
 *                    _ooOoo_
 *                   o8888888o
 *                   88" . "88
 *                   (| -_- |)
 *                   O\  =  /O
 *                ____/`---'\____
 *              .'  \\|     |//  `.
 *             /  \\|||  :  |||//  \
 *            /  _||||| -:- |||||-  \
 *            |   | \\\  -  /// |   |
 *            | \_|  ''\---/''  |   |
 *            \  .-\__  `-`  ___/-. /
 *          ___`. .'  /--.--\  `. . __
 *       ."" '<  `.___\_<|>_/___.'  >'"".
 *      | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *      \  \ `-.   \_ __\ /__ _/   .-` /  /
 *  ======`-.____`-.___\_____/___.-`____.-'======
 *                     `=---='
 *  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *           佛祖保佑       永无测试遗漏
 */

package com.jorge.testui.mock.web.common.base;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @Filename MockBase.java
 *
 * @Description
 *
 * @Author ck.wu
 * @Email 506093826@qq.com
 * @Version 1.0
 * @History 2019年4月1日 上午9:56:55
 *
 */
public class MockBase {

	protected String  StringReplaceZore(String str){
		return str.replaceAll("^(0+)","").isEmpty()?"0":str.replaceAll("^(0+)","");
	}

	protected String getDateFormat(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String formatDate = formatter.format(date);
		return formatDate;
	}

	protected String getDateFormats(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDate = formatter.format(date);
		return formatDate;
	}

	protected String  StringReplace(String str,int sizes){
		str = str.substring(str.length() - sizes);
		return str.replaceAll("^(0+)","").isEmpty()?"0":str.replaceAll("^(0+)","");
	}

	public String getDateFormat(Date date, String format) {

		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String formatDate = formatter.format(date);

		return formatDate;
	}

	public boolean getDateFormatss(Date date) {

		String time = "2017-09-27 11:20:45";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localTime = LocalDateTime.parse( getDateFormats(date), dtf);
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













}
