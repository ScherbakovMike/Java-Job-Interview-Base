package com.mikescherbakov.jobinterviewbase.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class VirtualThreadRunner implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    Thread.ofVirtual().start(() -> System.out.println("I'm the first virtual thread"));
    Thread.startVirtualThread(() -> System.out.println("I'm the second virtual thread"));
    try(var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      executor.submit(() -> System.out.println("I'm the third virtual thread"));
    }
  }
}