package com.mikescherbakov.jobinterviewbase;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleService {

  private final PojoClass pojoClass;
  private final XMLPojo xmlPojo;

  @PostConstruct
  public void postConstruct() {
    System.out.printf("pojo class has been picked: %s%n", pojoClass.toString());
    System.out.printf("XML pojo class also has been configured and picked: %s%n", xmlPojo.toString());
  }
}
