package com.mikescherbakov.jobinterviewbase.runners;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SoftReferenceRunner implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {

    var strongReference = new String("Some text");
    var softReference = new SoftReference<>(strongReference);

    System.out.printf("Soft reference before GC: %s%n", softReference.get());

    long N = 10000;
    long boundary = N*N;
    for (long i=0;i<boundary;i++) {
      var ref = new SoftReference<>(strongReference);
    }

    strongReference = null;

    System.gc();

    Thread.sleep(1000);

    System.out.printf("Soft reference after GC: %s%n", softReference.get());

  }
}
