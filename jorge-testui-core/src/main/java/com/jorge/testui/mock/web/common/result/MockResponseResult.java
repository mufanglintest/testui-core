package com.jorge.testui.mock.web.common.result;

import com.acooly.core.common.facade.ResultBase;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.util.Date;
import java.util.Map;

/**
 * @Author ck.wu
 * @Email 506093826@qq.com
 * @History create 2020/03/31 9:58
 */
@Slf4j
@Data
public class MockResponseResult extends ResultBase {
	
	private String paySt;
	private Map<String , Object> payInfo;
	private String timestamp;
	private Long totalAmount;
	private Date settleDate;
	private String targetOrderId;
	private Map<String ,Object> data;
	private Map<String ,Object> signData;
	
	private String requestData;
	
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
