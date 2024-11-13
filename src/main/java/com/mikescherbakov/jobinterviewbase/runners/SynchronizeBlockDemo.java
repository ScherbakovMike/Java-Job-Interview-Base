package com.mikescherbakov.jobinterviewbase.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/*
1. Concurrency and Multithreading:
Write code to demonstrate various synchronization techniques
(e.g., synchronized, ReentrantLock, ReadWriteLock),
and solve a producer-consumer problem using different concurrency tools
(e.g., BlockingQueue, Semaphore).
 */
@Component
public class SynchronizeBlockDemo implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    var thread1 = new Thread(this::methodWithSynchronizedBlock);
    var thread2 = new Thread(this::methodWithSynchronizedBlock);
    thread1.start();
    thread2.start();
  }

  private void methodWithSynchronizedBlock() {
    while (true) {
      synchronized (this) {
        notify();
        System.out.printf(
            "The thread %s has entered to the synchronized block.%n",
            Thread.currentThread().getName());
        System.out.printf(
            "The thread %s is working...%n",
            Thread.currentThread().getName());
        delay(1000L);
        System.out.printf(
            "The thread %s has finished working...%n",
            Thread.currentThread().getName());
        waitUntilNotified();
      }
    }
  }

  private void delay(Long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }

  private synchronized void waitUntilNotified() {
    try {
      wait();
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }
}
