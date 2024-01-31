package com.mikescherbakov.jobinterviewbase.performance;

import com.mikescherbakov.jobinterviewbase.model.ProfiledBean;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PerformanceController {

  private final Timer timer;
  private final ProfiledBean profiledBean;

  // Access results by link:
  // http://localhost:8080/actuator/metrics/my.timer
  @GetMapping("/time")
  public String timeSomething() {
    Runnable action = () -> {

    };
    timer.record(action);
    return profiledBean.toString();
  }

}
