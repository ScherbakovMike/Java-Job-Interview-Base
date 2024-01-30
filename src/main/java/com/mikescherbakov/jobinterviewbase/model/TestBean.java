package com.mikescherbakov.jobinterviewbase.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestBean implements InitializingBean, DisposableBean, BeanNameAware {

  @Override
  public void destroy() throws Exception {
    log.info("Destroying TestBean");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    log.info("Initializing TestBean");
  }

  @Override
  public void setBeanName(String name) {
    log.info("Setting name of TestBean: {}", name);
  }

  @PostConstruct
  void postConstruct() {
    log.info("PostConstruct TestBean");
  }

  @PreDestroy
  void preDestroy() {
    log.info("PreDestroying TestBean");
  }
}
