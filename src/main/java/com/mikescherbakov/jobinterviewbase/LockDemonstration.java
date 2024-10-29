package com.mikescherbakov.jobinterviewbase;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDemonstration {

  public static void main(String[] args) throws InterruptedException {
    var reentrantLock = new ReentrantLock();
    if(reentrantLock.tryLock()) {
      System.out.println("ReentrantLock is established.");
      if(reentrantLock.tryLock()){
        System.out.println("ReentrantLock is established again in the same thread.");
      }
      new Thread(()->{
        if(reentrantLock.tryLock()) {
          System.out.println("ReentrantLock is established again in another thread.");
        } else {
          System.out.println("ReentrantLock is not established in another thread.");
        }
      }).start();
    }
    try{
      Thread.sleep(3000);
    }catch (InterruptedException ex){

    }
    reentrantLock.unlock();
    var reentrantReadWriteLock = new ReentrantReadWriteLock();
    var readLock = reentrantReadWriteLock.readLock();
    if(readLock.tryLock()) {
      System.out.println("Read lock has been established.");
    } else {
      System.out.println("Read lock has not been established.");
    }
    new Thread(()->{
      var writeLock = reentrantReadWriteLock.writeLock();
      if(writeLock.tryLock()) {
        System.out.println("Write lock has been established.");
      } else {
        System.out.println("Write lock has not been established.");
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }).start();
    new Thread(()->{
      var writeLock = reentrantReadWriteLock.writeLock();
      if(writeLock.tryLock()) {
        System.out.println("Second write lock has been established.");
      } else {
        System.out.println("Second write lock has not been established.");
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }).start();

    Thread.sleep(1000);
    readLock.unlock();
  }
}
