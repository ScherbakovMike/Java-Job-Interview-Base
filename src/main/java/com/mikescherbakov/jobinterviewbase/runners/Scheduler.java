package com.mikescherbakov.jobinterviewbase.runners;

import com.mikescherbakov.jobinterviewbase.model.SimpleClass;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@RequiredArgsConstructor
@Component
public class Scheduler {

  private final SimpleClass simpleClass;

  @Lookup
  protected SimpleClass getSimpleClass() {
    return null;
  }

  @Scheduled(fixedRate = 1000)
  public void scheduledMethod() {
    System.out.printf("Singleton: %s%n", simpleClass.getName());
    System.out.printf("Prototype: %s%n", getSimpleClass().getName());
  }
}
