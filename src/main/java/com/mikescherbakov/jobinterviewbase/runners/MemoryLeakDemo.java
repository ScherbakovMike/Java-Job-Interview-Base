package com.mikescherbakov.jobinterviewbase.runners;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MemoryLeakDemo implements ApplicationRunner {

  private static final List<String> list = new ArrayList<>();

  @Override
  public void run(ApplicationArguments args) throws Exception {
    while(true) {
      list.add(UUID.randomUUID().toString());
    }
  }
}
