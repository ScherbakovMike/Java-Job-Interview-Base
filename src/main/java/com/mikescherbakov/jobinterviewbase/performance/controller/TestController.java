package com.mikescherbakov.jobinterviewbase.performance.controller;

import com.mikescherbakov.jobinterviewbase.performance.model.BeanApplication;
import com.mikescherbakov.jobinterviewbase.performance.model.BeanPrototype;
import com.mikescherbakov.jobinterviewbase.performance.model.BeanRequest;
import com.mikescherbakov.jobinterviewbase.performance.model.BeanSession;
import com.mikescherbakov.jobinterviewbase.performance.model.BeanSingleton;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {

  private final ApplicationContext context;

  @Resource(name = "beanRequest")
  private BeanRequest beanRequest;

  @Resource(name = "beanSession")
  private BeanSession beanSession;

  @Resource(name = "beanApplication")
  private BeanApplication beanApplication;

  @GetMapping("/singleton")
  public ResponseEntity<List<BeanSingleton>> getSingletonBean() {
    var singleton1 = context.getBean(BeanSingleton.class);
    var singleton2 = context.getBean(BeanSingleton.class);
    log.info("%s%n%s".formatted(singleton1.toString(), singleton2.toString()));
    return ResponseEntity.ok(List.of(singleton1, singleton2));
  }

  @GetMapping("/prototype")
  public ResponseEntity<List<BeanPrototype>> getPrototypeBean() {
    var prototype1 = context.getBean(BeanPrototype.class);
    var prototype2 = context.getBean(BeanPrototype.class);
    log.info("%s%n%s".formatted(prototype1.toString(), prototype2.toString()));
    return ResponseEntity.ok(List.of(prototype1, prototype2));
  }

  @GetMapping("/request")
  public ResponseEntity<BeanRequest> getRequestBean() {
    log.info(beanRequest.toString());
    return ResponseEntity.ok(beanRequest);
  }

  @GetMapping("/session")
  public ResponseEntity<BeanSession> getSessionBean() {
    log.info(beanSession.toString());
    return ResponseEntity.ok(beanSession);
  }

  @GetMapping("/application")
  public ResponseEntity<BeanApplication> getApplicationBean() {
    log.info(beanApplication.toString());
    return ResponseEntity.ok(beanApplication);
  }
}
