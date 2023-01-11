package com.lhu.corsconfig.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static org.springframework.http.HttpHeaders.ORIGIN;

// @Component
@Slf4j
public class CorsFilter extends OncePerRequestFilter {

  // List of origins..
  @Value("#{'${allowed.origins}'.split(',')}")
  private List<String> allowedOrigins;

  private static final int ACCESS_CONTROL_MAX_AGE = 10;

  @Override
  protected void doFilterInternal(
      final HttpServletRequest request,
      final HttpServletResponse response,
      final FilterChain filterChain)
      throws ServletException, IOException {

    final String origin = request.getHeader(ORIGIN);

    boolean isValidDomain = false;
    if (Objects.nonNull(origin) && allowedOrigins.contains(origin)) {
      isValidDomain = true;
      response.setHeader("Access-Control-Allow-Origin", origin);
    }
    log.info("Received Origin : " + origin + ".IsValidDomain : " + isValidDomain);

    response.addHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,PATCH,HEAD,OPTIONS");

    response.addHeader(
        "Access-Control-Allow-Headers",
        "Access-Control-Allow-Headers,"
            + "origin, Accept, X-Requested-With, Content-Type,Access-Control-Request-Method, "
            + "Access-Control-Request-Headers, Authorization, MP-META, clientId");

    response.addHeader(
        "Access-Control-Expose-Headers",
        "Access-Control-Allow-Origin, Access-Control-Allow-Credentials");

    response.addHeader("Access-Control-Allow-Credentials", "true");

    response.addIntHeader("Access-Control-Max-Age", ACCESS_CONTROL_MAX_AGE);

    filterChain.doFilter(request, response);
  }

  //    @Bean
  //    public WebMvcConfigurer corsConfigurer() {
  //        return new WebMvcConfigurer() {
  //            @Override
  //            public void addCorsMappings(CorsRegistry registry) {
  //
  // registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:8080");
  //            }
  //        };
  //    }
}
