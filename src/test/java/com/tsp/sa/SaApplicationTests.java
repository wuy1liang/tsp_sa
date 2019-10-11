package com.tsp.sa;

import com.tsp.sa.service.SaService;
import com.tsp.sa.utils.HttpUtil;
import com.tsp.sa.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SaApplicationTests {

    @Autowired
    SaService saService;

    @Test
    public void contextLoads() {
        saService.sa();
    }

    @Test
    public void t1(){
        String url = "https://restapi.amap.com/v3/direction/transit/integrated?";
        url += "key=a52b22a186c5a4d2b3fb0ff0cbc26ae4&";
        url += "origin=116.481499,39.990475&";
        url += "destination=116.465063,39.999538&";
        url += "city=010&";
        url += "extensions=all&";

        Map<String,Object> params = new HashMap<>();
        params.put("key","a52b22a186c5a4d2b3fb0ff0cbc26ae4");
        params.put("origin","116.481499,39.990475");
        params.put("destination","116.465063,39.999538");
        params.put("city","010");
        params.put("extensions","all");
        url += "key="+getGaodeSign(params,"824d4a179ba5c4bf30ecea829ad82122");

        System.out.println(url);
        String rest = HttpUtil.rest(params, url, HttpMethod.GET);
        System.out.println(JsonUtil.json2Data(rest));
    }

    public String getGaodeSign(Map<String,Object> paramMap,String privateKey) {
        Iterator<Entry<String, Object>> it = paramMap.entrySet().iterator();
        List<String> paramKeyList = new ArrayList<String>();
        while(it.hasNext()) {
            Entry<String, Object> entry = it.next();
            paramKeyList.add(entry.getKey());
        }
        String[] array = new String[paramKeyList.size()];
        paramKeyList.toArray(array);
        Arrays.sort(array);
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < array.length;i++) {
            sb.append(array[i]);
            sb.append("=");
            sb.append(paramMap.get(array[i]));
            sb.append("&");
        }
        String param = sb.substring(0, sb.length() - 1);
        param = param + privateKey;
        System.out.println(param);
        String sign = getMD5(param);
        System.out.println(sign);
        return sign;
    }

    //生成MD5
    public String getMD5(String message) {
        String md5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");  // 创建一个md5算法对象
            byte[] messageByte = message.getBytes("UTF-8");
            byte[] md5Byte = md.digest(messageByte);              // 获得MD5字节数组,16*8=128位
            md5 = bytesToHex(md5Byte);                            // 转换为16进制字符串
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5;
    }
    // 二进制转十六进制
    public static String bytesToHex(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();
        int num;
        for (int i = 0; i < bytes.length; i++) {
            num = bytes[i];
            if(num < 0) {
                num += 256;
            }
            if(num < 16){
                hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString().toUpperCase();
    }
}
