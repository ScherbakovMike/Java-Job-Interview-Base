package com.mikescherbakov.jobinterviewbase.performance.configuration;


import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

import com.mikescherbakov.jobinterviewbase.performance.model.BeanApplication;
import com.mikescherbakov.jobinterviewbase.performance.model.BeanPrototype;
import com.mikescherbakov.jobinterviewbase.performance.model.BeanRequest;
import com.mikescherbakov.jobinterviewbase.performance.model.BeanSession;
import com.mikescherbakov.jobinterviewbase.performance.model.BeanSingleton;
import java.security.SecureRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

  private static final SecureRandom RANDOM = new SecureRandom();

  @Bean
  @Scope(SCOPE_SINGLETON)
  public BeanSingleton beanSingleton() {
    var bean = new BeanSingleton();
    bean.setName("Bean Singleton");
    bean.setHeight(RANDOM.nextInt());
    return bean;
  }

  @Bean
  @Scope(SCOPE_PROTOTYPE)
  public BeanPrototype beanPrototype() {
    var bean = new BeanPrototype();
    bean.setName("Bean Prototype");
    bean.setHeight(RANDOM.nextInt());
    return bean;
  }

  @Bean
  @RequestScope
  public BeanRequest beanRequest() {
    var bean = new BeanRequest();
    bean.setName("Bean Request");
    bean.setHeight(RANDOM.nextInt());
    return bean;
  }

  @Bean
  @SessionScope
  public BeanSession beanSession() {
    var bean = new BeanSession();
    bean.setName("Bean Session");
    bean.setHeight(RANDOM.nextInt());
    return bean;
  }

  @Bean
  @ApplicationScope
  public BeanApplication beanApplication() {
    var bean = new BeanApplication();
    bean.setName("Bean Application");
    bean.setHeight(RANDOM.nextInt());
    return bean;
  }

}
