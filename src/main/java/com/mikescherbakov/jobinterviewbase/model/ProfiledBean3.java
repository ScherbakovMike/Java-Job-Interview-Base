package com.mikescherbakov.jobinterviewbase.model;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Getter
@Profile("profile3")
@Component
@Slf4j
@ToString
public class ProfiledBean3 implements ProfiledBean {

  private static final String NAME = "ProfiledBean3";

  @PostConstruct
  void logStatus() {
    log.info("Profile 3 started.");
  }
}
