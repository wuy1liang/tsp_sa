package com.tsp.sa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sa")
public class SaController {

    @GetMapping("/dp")
    public String dp(String origin, List<String> destinations, String strategy){
        return null;
    }
}
