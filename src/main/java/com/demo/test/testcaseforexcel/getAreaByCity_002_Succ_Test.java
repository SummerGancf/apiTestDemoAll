package com.demo.test.testcaseforexcel;

import com.demo.base.Common;
import com.demo.base.HttpRespones;
import com.demo.test.base.BaseParpare;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.io.IOException;
import java.util.Map;

/**
 * @author aEcho
 */
public class getAreaByCity_002_Succ_Test extends BaseParpare {
	private  Logger logger = Logger
			.getLogger(getAreaByCity_002_Succ_Test.class);
	public String httpResult = null, exp_code = null, Code = null,
			areaId = null;
	public JSONArray Result = null;
	public static String method = "GET";
	public static String Api = "";
	public static HttpRespones getAreaByCity;
	JSONObject Param;

	@BeforeTest
	public void setUp() {

		getAreaByCity = new HttpRespones();
		
	}

	/**
	 * @author aEcho
	 */
	/*
	 * @Test(groups = { "BaseCase"}) public void getAreaByCity_Succ() throws
	 * IOException{ exp_code="10000"; // Api="baseinfo.CommonApi.getAreaByCity";
	 * try { Param.put("cityId", 32); resultCheck(Api,Param,exp_code,method); }
	 * catch (JSONException e) { e.printStackTrace(); }
	 * 
	 * }
	 */
	/**
	 * @author aEcho
	 */
	/*
	 * @Test(groups = { "BaseCase"}) public void getAreaByCity_Fail() throws
	 * IOException{ exp_code="-10000"; //
	 * Api="baseinfo.CommonApi.getAreaByCity"; try { Param.put("cityId", "福州");
	 * resultCheck(Api,Param,exp_code,method); } catch (JSONException e) {
	 * e.printStackTrace(); }
	 * 
	 * } public void resultCheck(String Api_str, JSONObject Param_str,String
	 * exp_code_str,String method) throws IOException{
	 * Reporter.log("【正常用例】:获取"+Api+"成功");
	 * getAreaByCity.seturl("http://172.19.0.26/WSGW/rest?");
	 * httpResult=getAreaByCity.getHttpRespone(Api_str, Param_str,method);
	 * Reporter.log("请求地址: "+getAreaByCity.geturl());
	 * Reporter.log("返回结果: "+httpResult); Code=Common.getJsonValue(httpResult,
	 * "Code"); Result=Common.getJsonArrayValue(httpResult, "Result");
	 * areaId=Common.getJsonValueForJsonArray(Result, "areaId",0);
	 * Reporter.log("用例结果: resultCode=>expected: " + exp_code_str +
	 * " ,actual: "+ Code+" ,Result:"+Result+" ,areaId:"+areaId);
	 * Assert.assertEquals(Code,exp_code_str);
	 * Assert.assertEquals(areaId,"396"); }
	 */

	/**
	 * @author aEcho
	 * @deprecated 从excel里面读取数据
	 */
	@Test(dataProvider = "testData")
	public void getAreaByCityforJson(Map<String, String> data) {
		Api = data.get("Api");
		
		try {
			//Param 在 excel中以json格式传递
			Param = new JSONObject(data.get("Param"));
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
