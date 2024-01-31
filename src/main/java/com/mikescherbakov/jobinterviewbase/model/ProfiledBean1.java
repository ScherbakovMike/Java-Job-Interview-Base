package com.mikescherbakov.jobinterviewbase.model;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Getter
@Profile("profile1")
@Component
@Slf4j
@ToString
public class ProfiledBean1 implements ProfiledBean {

  private static final String NAME = "ProfiledBean1";

  @PostConstruct
  void logStatus() {
    log.info("Profile 1 started.");
  }
}
