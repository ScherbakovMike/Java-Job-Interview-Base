package com.mikescherbakov.jobinterviewbase.model;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SomeBean {

  @PostConstruct
  void postConstruct() {
    System.out.printf("SomeBean.postConstruct: hash: %d%n", this.hashCode());
  }

}
