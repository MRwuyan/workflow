package com.yiyin.workflow.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yiyin.workflow.constant.Constants;
import com.yiyin.workflow.utils.http.HttpUtil;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Barry on 2018/7/31.
 */
@Slf4j
@UtilityClass
public class IPLocationUtils {
    public String cityName(String ip){
        String city = "";
        try {
            Map<String, String> requestMap = new HashMap<>();
            requestMap.put("ip", ip);
            requestMap.put("ak", Constants.URL.百度地图定位.ak);
            String returnJsonStr = HttpUtil.requestPost(Constants.URL.百度地图定位.IP定位, requestMap, "UTF-8");

            log.debug("定位返回:" + returnJsonStr);

            JSONObject jsonObject = JSON.parseObject(returnJsonStr);
            JSONObject content = jsonObject.getJSONObject("content");
            JSONObject address_detail = content.getJSONObject("address_detail");
            city = address_detail.getString("city");
        } catch (Exception e) {
            log.error("城市获取失败!IP:{}", ip);
        }
        return city;
    }
}
