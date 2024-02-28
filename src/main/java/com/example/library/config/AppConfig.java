package com.example.library.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(WebClientConfig.class)
public class AppConfig {
}

