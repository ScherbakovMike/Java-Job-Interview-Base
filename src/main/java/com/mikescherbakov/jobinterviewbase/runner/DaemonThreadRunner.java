package com.mikescherbakov.jobinterviewbase.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DaemonThreadRunner implements ApplicationRunner {

  private final ApplicationContext context;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    var thread1 = new Thread(() -> {
      while (true) {
        System.out.println("Thread 1 is running");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          System.out.println("Thread 1 is interrupted");
        }
      }
    });

    var thread2 = new Thread(() -> {
      while (true) {
        System.out.println("Thread 2 is running");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          System.out.println("Thread 2 is interrupted");
        }
      }
    });

    var daemonThread = new Thread(() -> {
      while (true) {
        System.out.println("Daemon thread is running");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          System.out.println("Daemon thread is interrupted");
        }
      }
    });
    daemonThread.setDaemon(true);

    Thread.sleep(1000);

    thread1.start();
    thread2.start();
    daemonThread.start();

    Thread.sleep(3000);
    System.out.println("System is shutting down");
    System.exit(0);
  }
}
