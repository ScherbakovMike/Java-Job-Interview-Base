package com.mikescherbakov.jobinterviewbase.runners;

import java.security.SecureRandom;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class ReadWriteLockDemo implements ApplicationRunner {

  private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
  private final SecureRandom random = new SecureRandom();

  @Override
  public void run(ApplicationArguments args) throws Exception {
    final int POOL_SIZE = 10;
    for (var i = 0; i < POOL_SIZE; i++) {
      new Thread(this::concurrentReadMethod, "Thread " + i).start();
    }
    for (var i = POOL_SIZE; i < 2*POOL_SIZE; i++) {
      new Thread(this::concurrentWriteMethod, "Thread " + i).start();
    }
  }

  private void concurrentReadMethod() {
    delay(random.nextLong(100));
    var lock = readWriteLock.readLock();
    lock.lock();  // Acquire the read lock
    try {
      System.out.printf(
          "Thread %s has acquired the read lock.%n",
          Thread.currentThread().getName()
      );

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
    } finally {
      lock.unlock();  // Ensure the lock is released
      System.out.printf(
          "Thread %s has released the read lock.%n",
          Thread.currentThread().getName()
      );
    }
  }

  private void concurrentWriteMethod() {
    delay(random.nextLong(100));
    var lock = readWriteLock.writeLock();
    lock.lock();  // Acquire the write lock
    try {
      System.out.printf(
          "Thread %s has acquired the write lock.%n",
          Thread.currentThread().getName()
      );

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
    } finally {
      lock.unlock();  // Ensure the lock is released
      System.out.printf(
          "Thread %s has released the write lock.%n",
          Thread.currentThread().getName()
      );
    }
  }

  private void delay(Long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }
}
