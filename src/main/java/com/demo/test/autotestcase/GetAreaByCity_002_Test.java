package com.demo.test.autotestcase;

import com.demo.test.base.BaseParpare;
import com.demo.utils.HttpAction;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class GetAreaByCity_002_Test extends BaseParpare{
@Test(dataProvider = "testData")
public void GetAreaByCity(Map<String, String> data) { 
    try{
        String Api = data.get("Api"); 
        JSONObject Param = new JSONObject(data.get("Param"));
        String expect=data.get("expect");
        HttpAction.httpForExcel(Api, Param, expect);
       }catch(JSONException e) {
            Assert.fail("getAreaByCity:JSONException");
            e.printStackTrace();
        }
    }
}