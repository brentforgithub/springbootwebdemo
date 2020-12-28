package com.brent.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class DemoConfig {
    @Value("${demo.property}")
    private String property;
}
