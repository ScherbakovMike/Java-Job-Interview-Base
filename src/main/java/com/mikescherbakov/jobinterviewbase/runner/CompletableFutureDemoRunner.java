package com.mikescherbakov.jobinterviewbase.runner;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CompletableFutureDemoRunner implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    var completableFutureWithException = CompletableFuture.runAsync(
            this::longRunningTaskWithException)
        .exceptionallyCompose(throwable -> {
          System.out.println(
              "Exception occurred in long running task with exception: " + throwable.getMessage());
          return CompletableFuture.runAsync(this::longRunningTask);
        });
    TimeUnit.MILLISECONDS.sleep(10000);
    var completableFutureWithResult = CompletableFuture.supplyAsync(this::longRunningTaskWithResult)
        .thenAcceptAsync(
            result -> System.out.println("Result of long running task with result: " + result));
  }

  private void longRunningTask() {
    try {
      System.out.println("Long running task started");
      Thread.sleep(5000);
      System.out.println("Long running task finished");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void longRunningTaskWithException() {
    try {
      System.out.println("Long running task with exception started");
      Thread.sleep(5000);
      throw new RuntimeException("Exception in long running task");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private String longRunningTaskWithResult() {
    try {
      System.out.println("Long running task with result started");
      Thread.sleep(5000);
      System.out.println("Long running task with result finished");
      return "Result of long running task with result";
    } catch (InterruptedException e) {
      e.printStackTrace();
      return null;
    }
  }
}
