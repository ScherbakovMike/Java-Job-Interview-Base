package com.mikescherbakov.jobinterviewbase.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Exception3 extends RuntimeException {

  public Exception3(String message) {
    super(message);
    log.info("Exception3: {}", message);
  }
}
