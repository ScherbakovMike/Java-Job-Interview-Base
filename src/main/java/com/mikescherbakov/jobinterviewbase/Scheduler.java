package com.mikescherbakov.jobinterviewbase;

import com.mikescherbakov.jobinterviewbase.model.LazyBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Scheduler {

  private final ApplicationContext context;

  @Scheduled(initialDelay = 3000)
  public void delayedTask() {
    context.getBean(LazyBean.class);
  }
}
