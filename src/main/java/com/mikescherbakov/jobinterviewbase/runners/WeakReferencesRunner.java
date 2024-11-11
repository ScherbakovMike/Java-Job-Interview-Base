package com.mikescherbakov.jobinterviewbase.runners;

import java.lang.ref.WeakReference;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class WeakReferencesRunner implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    var strongReference = new String("Some text");
    var weakReference = new WeakReference<String>(strongReference);

    System.out.printf("Weak reference before GC: %s%n", weakReference.get());

    strongReference = null;

    System.gc();

    Thread.sleep(1000);

    System.out.printf("Weak reference after GC: %s%n", weakReference.get());
  }
}
