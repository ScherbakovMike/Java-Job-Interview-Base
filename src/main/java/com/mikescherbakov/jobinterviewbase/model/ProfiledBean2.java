package com.mikescherbakov.jobinterviewbase.model;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Getter
@Profile("profile2")
@Component
@Slf4j
@ToString
public class ProfiledBean2 implements ProfiledBean {

  private static final String NAME = "ProfiledBean3";

  @PostConstruct
  void logStatus() {
    log.info("Profile 2 started.");
  }
}
