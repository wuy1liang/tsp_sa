package com.tsp.sa;

import com.tsp.sa.service.SaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaApplicationTests {

    @Autowired
    SaService saService;

    @Test
    public void contextLoads() {
        saService.sa();
    }

}
