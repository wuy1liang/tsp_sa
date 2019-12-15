package com.tsp.sa;

import com.tsp.sa.entity.GaodeTransitDirectionRequestParameters;
import com.tsp.sa.entity.GaodeTransitDirectionResponseData;
import com.tsp.sa.entity.GeocodeRegeoRequestParameters;
import com.tsp.sa.entity.GeocodeRegeoResponseData;
import com.tsp.sa.properties.SaProperties;
import com.tsp.sa.service.GaodeService;
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

    @Autowired
    GaodeService gaodeService;

    @Autowired
    SaProperties saProperties;

    @Test
    public void contextLoads() {
        String start = "116.703426,23.365613";  // 汕头
        List<String> po = new ArrayList<>();
        po.add("126.534967,45.803775");   // 哈尔滨
        po.add("112.484848,23.052101");    // 肇庆
        po.add("113.884020,22.555259");    // 深圳
        po.add("104.066541,30.572269");    // 成都
        saService.sa(start,po,"0");
    }

}
