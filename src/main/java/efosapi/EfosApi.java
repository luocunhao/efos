package efosapi;

import cn.xlink.iot.sdk.datastruct.XlinkIotPublishModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import config.UrlConfig;
import config.XagentConfig;
import utils.HttpClientUtil;
import utils.ParsseResponse;

import java.util.*;

public interface EfosApi {
    List<XlinkIotPublishModel> query(String host,int port,String access_token);
    default Set<Integer> queryAllProject(){
        Set<Integer> set = new HashSet<>();
        String url = XagentConfig.efoshost +":"
                + XagentConfig.efosport
                + UrlConfig.ProjectUrl
                + "?AccessToken=" + XagentConfig.efostoken;
        try {
            String response = HttpClientUtil.HttpPost(url,new HashMap());
            Map<String,String> retMap = ParsseResponse.parseResponse(response);
            String data = retMap.get("data");
            JSONArray projectArray = JSONObject.parseArray(data);
            for (int i = 0; i < projectArray.size(); i++) {
                JSONObject projectObj = projectArray.getJSONObject(i);
                int proid = projectObj.getInteger("projectCode");
                set.add(proid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }
}
