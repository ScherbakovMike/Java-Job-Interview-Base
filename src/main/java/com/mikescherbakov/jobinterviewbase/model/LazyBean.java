package com.mikescherbakov.jobinterviewbase.model;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Slf4j
public class LazyBean {

  @PostConstruct
  public void postConstruct() {
    log.info("Lazy bean initialized");
  }
}
