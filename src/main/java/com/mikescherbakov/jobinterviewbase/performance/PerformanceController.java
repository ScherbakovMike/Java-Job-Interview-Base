package com.mikescherbakov.jobinterviewbase.performance;

import com.mikescherbakov.jobinterviewbase.model.RecordImmutableBean;
import com.mikescherbakov.jobinterviewbase.model.ValueImmutableBean;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PerformanceController {

  private final Timer timer;
  private final RecordImmutableBean recordImmutableBean;
  private final ValueImmutableBean valueImmutableBean;

  // Access results by link:
  // http://localhost:8080/actuator/metrics/my.timer
  @GetMapping("/time")
  public String timeSomething() {
    Runnable action = () -> {
      System.out.println(recordImmutableBean.toString());
      System.out.println(valueImmutableBean.toString());
    };
    timer.record(action);
    return "Action has been recorded.";
  }

}
