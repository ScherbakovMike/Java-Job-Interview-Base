package com.mikescherbakov.jobinterviewbase.runners;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class BlockingQueueDemo implements ApplicationRunner {

  private static final int POOL_SIZE = 3;
  private static final int THREAD_COUNT = 1000;

  private final BlockingQueue<String> queue = new ArrayBlockingQueue<>(POOL_SIZE);
  private final SecureRandom random = new SecureRandom();

  @Override
  public void run(ApplicationArguments args) throws Exception {
    for (var i = 0; i < THREAD_COUNT; i++) {
      if (random.nextBoolean()) {
        new Thread(this::produce).start();
      } else {
        new Thread(this::consume).start();
      }
      delay(1000L);
    }
  }

  private void produce() {
    try {
      System.out.printf(
          "The thread %s is trying to put value to the queue.%n",
          Thread.currentThread().getName());
      queue.put(UUID.randomUUID().toString());
      System.out.printf(
          "The thread %s has put value to the queue.%n",
          Thread.currentThread().getName());
      delay(1000L);
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }

  private void consume() {
    System.out.printf(
        "The thread %s is trying to get value from the queue.%n",
        Thread.currentThread().getName());
    try {
      System.out.println(queue.take());
    } catch (InterruptedException e) {
      System.out.println(e);
    }
    System.out.printf(
        "The thread %s has retrieved value from the queue.%n",
        Thread.currentThread().getName());
  }

  private void delay(Long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }
}
