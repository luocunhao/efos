package utils;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ParsseResponse {
    public static Map<String,String> parseResponse(String input){
        Map<String,String> retMap = new HashMap<>();
        JSONObject jObject = JSONObject.parseObject(input);
        if (null != jObject.get("state"))
        {
            String i = jObject.get("state").toString();
            retMap.put("state", i);
        }
        if (null != jObject.get("data"))
        {
            String data = jObject.get("data").toString();
            retMap.put("data", data);
        }
        if (null != jObject.get("ProjectCode"))
        {
            String projectCode = jObject.get("ProjectCode").toString();
            retMap.put("ProjectCode", projectCode);
        }
        return retMap;
    }
}
