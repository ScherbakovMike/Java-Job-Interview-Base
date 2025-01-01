package com.mikescherbakov.jobinterviewbase.runner;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CyclicBarrierRunner implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    var cyclicBarrier = new CyclicBarrier(3);
    var thread1 = new Thread(() -> {
      try {
        System.out.println("Count of waiting threads: " + cyclicBarrier.getNumberWaiting());
        cyclicBarrier.await();
        System.out.println("Thread 1 has started execution");
      } catch (InterruptedException | BrokenBarrierException e) {
        throw new RuntimeException(e);
      }
    });
    var thread2 = new Thread(() -> {
      try {
        System.out.println("Count of waiting threads: " + cyclicBarrier.getNumberWaiting());
        cyclicBarrier.await();
        System.out.println("Thread 2 has started execution");
      } catch (InterruptedException | BrokenBarrierException e) {
        throw new RuntimeException(e);
      }
    });
    var thread3 = new Thread(() -> {
      try {
        System.out.println("Count of waiting threads: " + cyclicBarrier.getNumberWaiting());
        cyclicBarrier.await();
        System.out.println("Thread 3 has started execution");
      } catch (InterruptedException | BrokenBarrierException e) {
        throw new RuntimeException(e);
      }
    });
    thread1.start();
    Thread.sleep(3000);
    thread2.start();
    Thread.sleep(3000);
    thread3.start();

    cyclicBarrier.reset();
  }
}