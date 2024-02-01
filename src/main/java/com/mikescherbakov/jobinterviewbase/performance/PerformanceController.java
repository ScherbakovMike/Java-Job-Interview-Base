package com.mikescherbakov.jobinterviewbase.performance;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.mikescherbakov.jobinterviewbase.exceptions.Exception1;
import com.mikescherbakov.jobinterviewbase.exceptions.Exception2;
import com.mikescherbakov.jobinterviewbase.exceptions.Exception3;
import com.mikescherbakov.jobinterviewbase.exceptions.Exception4;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PerformanceController {

  private final Timer timer;

  // Access results by link:
  // http://localhost:8080/actuator/metrics/my.timer
  @GetMapping("/time")
  public String timeSomething() {
    Runnable action = () -> {

    };
    timer.record(action);
    return "Action has been recorded.";
  }

  @GetMapping("/exception1")
  public String exception1() {
    throw new Exception1("Exception1");
  }

  @GetMapping("/exception2")
  public String exception2() {
    throw new Exception2("Exception2");
  }

  @GetMapping("/exception3")
  public String exception3() {
    throw new Exception3("Exception3");
  }

  @GetMapping("/exception4")
  public String exception4() {
    try {
      throw new Exception4("Exception4");
    } catch (Exception4 ex) {
      throw new ResponseStatusException(NOT_FOUND, "The resource can't be found.", ex);
    }
  }

  @ExceptionHandler({Exception1.class})
  public void handleExceptions() {
    log.info("Exception1 has been caught in performance controller");
  }

}
