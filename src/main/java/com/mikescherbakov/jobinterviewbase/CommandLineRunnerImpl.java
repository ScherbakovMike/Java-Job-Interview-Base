package com.mikescherbakov.jobinterviewbase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommandLineRunnerImpl implements org.springframework.boot.CommandLineRunner {

  @Override
  public void run(String... args) {
    log.info("CommandLineRunnerImpl has been executed.");
  }
}
