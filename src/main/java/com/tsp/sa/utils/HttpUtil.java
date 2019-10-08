package com.tsp.sa.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class HttpUtil {

    public static String rest(Map<String,Object> parms, String url, HttpMethod method){
        //设置请求头信息
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        //设置body部分
        HttpEntity<String> entity = new HttpEntity<>(JSON.toJSON(parms).toString(),headers);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(url, method, entity, String.class);
        return result.getBody();
    }
}
