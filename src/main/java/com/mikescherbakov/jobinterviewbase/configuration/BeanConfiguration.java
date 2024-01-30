package com.mikescherbakov.jobinterviewbase.configuration;

import com.mikescherbakov.jobinterviewbase.model.RecordImmutableBean;
import com.mikescherbakov.jobinterviewbase.model.ValueImmutableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

  @Bean
  public RecordImmutableBean recordBean() {
    return new RecordImmutableBean("Some name", 100);
  }

  @Bean
  public ValueImmutableBean valueBean() {
    return new ValueImmutableBean("Some name", 100);
  }
}
