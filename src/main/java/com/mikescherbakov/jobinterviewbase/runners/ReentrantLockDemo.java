package com.mikescherbakov.jobinterviewbase.runners;

import java.security.SecureRandom;
import java.util.concurrent.locks.ReentrantLock;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ReentrantLockDemo implements ApplicationRunner {

  private final ReentrantLock lock = new ReentrantLock(true);
  private final SecureRandom random = new SecureRandom();

  @Override
  public void run(ApplicationArguments args) throws Exception {
    final int POOL_SIZE = 10;
    for (var i = 0; i < POOL_SIZE; i++) {
      new Thread(this::concurrentMethod, "Thread " + i).start();
    }
  }

  private void concurrentMethod() {
    lock.lock();
    System.out.printf(
        "Thread %s has entered the cohesive method.%n",
        Thread.currentThread().getName()
    );
    System.out.printf(
        "Thread %s is working now.%n",
        Thread.currentThread().getName()
    );
    delay(random.nextLong(1000));
    System.out.printf(
        "Thread %s has finished working.%n",
        Thread.currentThread().getName()
    );
    lock.unlock();
  }

  private void delay(Long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }
}
