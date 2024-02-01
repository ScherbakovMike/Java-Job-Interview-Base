package com.mikescherbakov.jobinterviewbase.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Exception1 extends RuntimeException {

  public Exception1(String message) {
    super(message);
    log.info("Exception1 constructor: {}", message);
  }
}
