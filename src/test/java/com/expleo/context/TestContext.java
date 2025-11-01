package com.expleo.context;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private static Response response;
    private Map testData=new HashMap();

    public Response getResponse()
    {
        return response;
    }

    public void setResponse(Response response)
    {
        this.response=response;
    }

    public void setTestData(String key,Object value)
    {
        testData.put(key,value);
    }

    public Object getTestData(String key)
    {
        return testData.get(key);
    }

    public String getTestDataAsString(String key)
    {
        return String.valueOf(testData.get(key));
    }

    public void reset()
    {
        response=null;
        testData.clear();
    }
}
