package com.mikescherbakov.jobinterviewbase.configuration;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

import com.mikescherbakov.jobinterviewbase.model.SimpleClass;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfiguration {

  @Bean
  @Scope(SCOPE_PROTOTYPE)
  public SimpleClass getSimpleClassBean() {
    return new SimpleClass(UUID.randomUUID().toString());
  }
}
