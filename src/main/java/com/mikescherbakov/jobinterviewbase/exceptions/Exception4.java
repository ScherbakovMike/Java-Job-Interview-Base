package com.mikescherbakov.jobinterviewbase.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Exception4 extends RuntimeException {

  public Exception4(String message) {
    super(message);
    log.info("Exception4: {}", message);
  }
}
