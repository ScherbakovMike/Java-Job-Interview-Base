package com.mikescherbakov.jobinterviewbase.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ArrayListRunner implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    var list = new ArrayList<String>();
    list.add("a");
    list.add("b");
    list.remove("a");
    System.out.println(list);
    System.out.println(list.size());
  }

}
