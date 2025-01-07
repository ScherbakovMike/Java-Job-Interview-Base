package com.mikescherbakov.jobinterviewbase.runner;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SemaphoreDemoApplicationRunner implements ApplicationRunner {

  private final int LIMITED_COUNT = 3;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    // this app demonstrates the use of semaphores and allows to run
    // a limited number of threads concurrently
    var semaphore = new Semaphore(LIMITED_COUNT);
    AtomicInteger counter = new AtomicInteger(0);
    while (true) {
      semaphore.acquire();
      var threadNumber = counter.incrementAndGet();
      new Thread(() -> {
        try {
          System.out.printf("Thread %d started%n", threadNumber);
          Thread.sleep(1000);
          System.out.printf("Thread %d finished%n", threadNumber);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          semaphore.release();
        }
      }).start();
    }
  }
}
