package main;

import cn.xlink.iot.sdk.XlinkIot;
import cn.xlink.iot.sdk.XlinkIotBuilder;
import cn.xlink.iot.sdk.operator.XlinkIotPublish;
import config.XagentConfig;

public class EfosMain {
    private static XlinkIotPublish xlinkIotPublish;
    public static void main(String[] args){
        //创建一个客户端构造器
        XlinkIotBuilder builder = new XlinkIotBuilder();
        //设置凭证和地址
        builder.setAppId(XagentConfig.appId)
                .setAppSecret(XagentConfig.appSecret)
                .setEndPoint(XagentConfig.endPoint);
        //创建一个http连接的客户端
        XlinkIot xlinkIot = builder.buildXlinkIotHttpClient();
        //创建一个publish实例
        xlinkIotPublish = new XlinkIotPublish(xlinkIot);
    }
    public static XlinkIotPublish getXlinkIotPublish(){return xlinkIotPublish;}
}
