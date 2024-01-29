package com.mikescherbakov.jobinterviewbase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleConfiguration {

  @Bean
  public PojoClass pojoClass() {
    return new PojoClass("Some name");
  }
}
