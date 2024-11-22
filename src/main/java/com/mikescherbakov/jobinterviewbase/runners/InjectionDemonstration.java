package com.mikescherbakov.jobinterviewbase.runners;

import com.mikescherbakov.jobinterviewbase.model.SomeBean;
import com.mikescherbakov.jobinterviewbase.services.BeanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InjectionDemonstration implements ApplicationRunner {

  private final BeanService beanService;

  @Lookup
  public SomeBean getSomeBean() {
    return null;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
//    beanService.printSomeBean();
//    beanService.printSomeBean();
//    beanService.printSomeBean();
//
//    beanService.fieldInjection();
//    beanService.fieldInjection();
//    beanService.fieldInjection();
//
//    System.out.printf("Lookup bean: %d%n", getSomeBean().hashCode());
//    System.out.printf("Lookup bean: %d%n", getSomeBean().hashCode());
//    System.out.printf("Lookup bean: %d%n", getSomeBean().hashCode());

    beanService.getInfoOfTheSetterBean();
  }
}
