package com.mikescherbakov.jobinterviewbase.runner;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class QueueProcessingRunner implements ApplicationRunner {

  private final CopyOnWriteArrayList<String> queue = new CopyOnWriteArrayList<>();

  @Override
  public void run(ApplicationArguments args) throws Exception {
    final int producerCount = 3;
    final int consumerCount = 3;
    for (int i = 0; i < producerCount; i++) {
      new Thread(() -> {
        while (true) {
          try {
            produce();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }).start();
    }

    for (int i = 0; i < consumerCount; i++) {
      new Thread(() -> {
        while (true) {
          try {
            consume();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }).start();
    }
  }

  private synchronized void produce() throws InterruptedException {
    notifyAll();
    queue.add("item");
    System.out.println("Produced element: item");
    System.out.println("Queue size: " + queue.size());
    Thread.sleep(1000);
    wait();
  }

  private synchronized void consume() throws InterruptedException {
    notifyAll();
    if (queue.isEmpty()) {
      return;
    }
    System.out.println("Consumed element: " + queue.removeLast());
    System.out.println("Queue size: " + queue.size());
    Thread.sleep(1000);
    wait();
  }
}
