package com.demo.test.testcaseforexcel;

import com.demo.base.Common;
import com.demo.base.HttpRespones;
import com.demo.test.base.BaseParpare;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.io.IOException;
import java.util.Map;

public class getAreaByCity_001_Succ_Test extends BaseParpare{
  
	private  Logger logger = Logger
			.getLogger(getAreaByCity_001_Succ_Test.class);
	public String httpResult = null, exp_code = null, Code = null,
			areaId = null;
	public JSONArray Result = null;
	public static String method = "GET";
	public static String Api = "";
	public static HttpRespones getAreaByCity;
	JSONObject Param;



		
		
		
		/**
	 * @author aEcho
	 * @deprecated 从excel里面读取数据
	 */
	@Test(dataProvider = "testData")
	public void getAreaByCity(Map<String, String> data) {	
		try {
			getAreaByCity = new HttpRespones();
			Api = data.get("Api");
			Param = new JSONObject().put("cityId", data.get("cityId"));
			Reporter.log("【正常用例】:获取" + Api + "成功");
			getAreaByCity.seturl("http://172.19.0.26/WSGW/rest?");
			httpResult = getAreaByCity.getHttpRespone(Api, Param, method);
			Reporter.log("请求地址: " + getAreaByCity.geturl());
			Reporter.log("返回结果: " + httpResult);
			Code = Common.getJsonValue(httpResult, "Code");
			Reporter.log("用例结果: resultCode=>expected: " + data.get("expect")
					+ " ,actual: " + Code);
			Assert.assertEquals(Code, data.get("expect"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}
}
