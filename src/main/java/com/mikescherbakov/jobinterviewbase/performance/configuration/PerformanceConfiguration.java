package com.mikescherbakov.jobinterviewbase.performance.configuration;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PerformanceConfiguration {

  @Bean
  public Timer timer(MeterRegistry meterRegistry) {
    // Create and configure the MeterRegistry instance here
    return Timer.builder("my.timer")
        .description("Times something")
        .tags("region", "us-east")
        .register(meterRegistry);
  }
}
