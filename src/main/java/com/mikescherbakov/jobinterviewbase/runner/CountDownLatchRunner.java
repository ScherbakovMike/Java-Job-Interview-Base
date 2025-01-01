package com.mikescherbakov.jobinterviewbase.runner;

import java.util.concurrent.CountDownLatch;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CountDownLatchRunner implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    var countDownLatch = new CountDownLatch(3);
    var thread1 = new Thread(() -> {
      try {
        System.out.println("Count of waiting threads: " + countDownLatch.getCount());
        countDownLatch.countDown();
        countDownLatch.await();
        System.out.println("Thread 1 has started execution");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
    var thread2 = new Thread(() -> {
      try {
        System.out.println("Count of waiting threads: " + countDownLatch.getCount());
        countDownLatch.countDown();
        countDownLatch.await();
        System.out.println("Thread 2 has started execution");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
    var thread3 = new Thread(() -> {
      try {
        System.out.println("Count of waiting threads: " + countDownLatch.getCount());
        countDownLatch.countDown();
        countDownLatch.await();
        System.out.println("Thread 3 has started execution");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
    thread1.start();
    Thread.sleep(3000);
    thread2.start();
    Thread.sleep(3000);
    thread3.start();
  }
}
