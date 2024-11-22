package com.mikescherbakov.jobinterviewbase.services;

import com.mikescherbakov.jobinterviewbase.model.SomeBean;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeanService {

  private final SomeBean someBean;
  private SomeBean setterBean;

  @Autowired
  private SomeBean fieldInjection;

  public void printSomeBean() {
    System.out.printf("BeanService.printSomeBean: hash: %d%n", this.someBean.hashCode());
  }

  public void fieldInjection() {
    System.out.printf("BeanService.fieldInjection: hash: %d%n", fieldInjection.hashCode());
  }

  @Autowired
  public void setterInjection(SomeBean setterBean) {
    this.setterBean = setterBean;
    System.out.println("BeanService.setterInjection: hash: " + setterBean.hashCode());
  }

  public void getInfoOfTheSetterBean() {
    System.out.printf("BeanService.getInfoOfTheSetterBean: hash: %d%n", setterBean.hashCode());
  }
}
