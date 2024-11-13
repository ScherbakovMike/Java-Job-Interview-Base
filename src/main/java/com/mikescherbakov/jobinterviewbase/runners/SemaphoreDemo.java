package com.mikescherbakov.jobinterviewbase.runners;

import java.util.concurrent.Semaphore;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SemaphoreDemo implements ApplicationRunner {

  private final Semaphore semaphore = new Semaphore(3, true);

  @Override
  public void run(ApplicationArguments args) throws Exception {
    for (var i = 0; i < 1000; i++) {
      new Thread(this::concurrentMethod).start();
    }
  }

  private void concurrentMethod() {
    try {
      semaphore.acquire();
    } catch (InterruptedException e) {

    }
    System.out.printf(
        "The thread %s has acquired the lock.%n",
        Thread.currentThread().getName()
    );
    delay(1000L);
    semaphore.release();
  }

  private void delay(Long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }
}
