package com.mikescherbakov.jobinterviewbase.demostration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DeadlockDemonstration implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {

    var object1 = new Object();
    var object2 = new Object();

    var thread1 = new Thread(() -> {
      synchronized (object1) {
        System.out.println("Thread1 has synchronized the Object1");

        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        synchronized (object2) {
          System.out.println("Thread1 has synchronized the Object2");

          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
    });

    var thread2 = new Thread(() -> {
      synchronized (object2) {
        System.out.println("Thread2 has synchronized the Object2");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        synchronized (object1) {
          System.out.println("Thread2 has synchronized the Object1");
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
    });

    thread1.start();
    thread2.start();
  }
}
