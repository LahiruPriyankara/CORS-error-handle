package com.lhu.corsconfig.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {
  private static final int ACCESS_CONTROL_MAX_AGE = 10;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    log.info("WebMvcConfig");
    WebMvcConfigurer.super.addCorsMappings(registry);
    registry
        .addMapping("/**")
        .allowedOrigins("http://localhost:4200")
        .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "HEAD", "OPTIONS")
        .allowedHeaders(
            "Access-Control-Allow-Headers",
            "Access-Control-Request-Headers",
            "Access-Control-Request-Method",
            "origin",
            "Content-Type",
            "X-Requested-With",
            "Authorization",
            "MP-META",
            "Accept",
            "clientId")
        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
        .maxAge(ACCESS_CONTROL_MAX_AGE)
        .allowCredentials(Boolean.TRUE);
  }
}
