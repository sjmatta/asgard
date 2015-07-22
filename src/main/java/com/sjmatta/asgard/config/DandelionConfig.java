package com.sjmatta.asgard.config;

import javax.servlet.DispatcherType;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dandelion.core.web.DandelionFilter;
import com.github.dandelion.core.web.DandelionServlet;
import com.github.dandelion.thymeleaf.dialect.DandelionDialect;

@Configuration
public class DandelionConfig {

  @Bean
  public FilterRegistrationBean dandelionFilter() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new DandelionFilter());
    registration.addUrlPatterns("/*");
    registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD,
        DispatcherType.INCLUDE, DispatcherType.ERROR);
    return registration;
  }

  @Bean
  public ServletRegistrationBean dandelionServlet() {
    return new ServletRegistrationBean(new DandelionServlet(), "/dandelion-assets/*");
  }

  @Bean
  public DandelionDialect dandelionDialect() {
    return new DandelionDialect();
  }
}
