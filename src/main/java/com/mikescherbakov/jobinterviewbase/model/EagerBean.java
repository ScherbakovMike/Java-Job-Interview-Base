package com.mikescherbakov.jobinterviewbase.model;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EagerBean {

  @PostConstruct
  public void postConstruct() {
    log.info("Eager bean initialized");
  }
}
