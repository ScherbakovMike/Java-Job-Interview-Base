package com.mikescherbakov.jobinterviewbase.model;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedClass {

  public void methodA() {
    synchronized ("A") {
      System.out.println("MethodA is executed.");
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {

      }
      var a = new AtomicInteger(1);
      a.incrementAndGet();
    }
  }

  public void methodB() {
    synchronized ("B") {
      System.out.println("MethodB is executed.");
    }
  }

  public static void main(String[] args) {
    var instance = new SynchronizedClass();
    new Thread(instance::methodA).start();
    new Thread(instance::methodA).start();
    new Thread(instance::methodB).start();
    new Thread(instance::methodB).start();
  }
}
