package com.lhu.corsconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//import java.util.List;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
/*
  @Bean
  InMemoryUserDetailsManager users() {
    return new InMemoryUserDetailsManager(
        User.withUsername("dvega").password("{noop}password").roles("USER").build());
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.cors(
            Customizer
                .withDefaults()) // by default uses a Bean by the name of corsConfigurationSource
        .authorizeRequests(auth -> auth.anyRequest().authenticated())
        .httpBasic(Customizer.withDefaults())
        .build();
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
    configuration.setAllowedMethods(
        Arrays.asList("GET", "POST", "DELETE", "PUT", "PATCH", "HEAD", "OPTIONS"));
    configuration.setAllowedHeaders(
        List.of(
            "Access-Control-Request-Headers",
            "Access-Control-Request-Method",
            "origin",
            "Content-Type",
            "X-Requested-With",
            "Authorization",
            "MP-META",
            "Accept",
            "clientId"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

 */
}
