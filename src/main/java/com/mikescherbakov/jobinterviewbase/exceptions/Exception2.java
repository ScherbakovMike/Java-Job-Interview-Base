package com.mikescherbakov.jobinterviewbase.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class Exception2 extends RuntimeException {

  public Exception2(String message) {
    super(message);
    log.info("Exception2: {}", message);
  }
}
