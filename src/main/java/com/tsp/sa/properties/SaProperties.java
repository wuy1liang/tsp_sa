package com.tsp.sa.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "sa")
@Configuration
@Data
public class SaProperties {

    /** 初始温度 */
    private Double T;

    /** 温度下限 */
    private Double T_min;

    /** 退火系数 */
    private Double r;

    /** 每个温度的迭代次数 */
    private Integer L;
}
