package com.tsp.sa.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "gaode")
public class GaodeProperties {

    private String directionTransitUrl;

    private String directionTransitKey;

    private String directionTransitPrivatekey;

}
