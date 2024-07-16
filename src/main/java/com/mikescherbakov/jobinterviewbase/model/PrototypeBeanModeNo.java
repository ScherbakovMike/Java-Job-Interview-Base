package com.mikescherbakov.jobinterviewbase.model;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.NO)
public class PrototypeBeanModeNo {
  public PrototypeBeanModeNo() {
    System.out.println("\n\n\n\nI was created!\n\n\n\n");
  }
}
