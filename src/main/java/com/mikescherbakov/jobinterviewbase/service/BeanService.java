package com.mikescherbakov.jobinterviewbase.service;

import com.mikescherbakov.jobinterviewbase.model.PrototypeBeanModeNo;
import com.mikescherbakov.jobinterviewbase.model.PrototypeBeanModeTargetClass;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeanService {

  private final PrototypeBeanModeNo beanModeNo;
  private final PrototypeBeanModeTargetClass beanModeTargetClass;

  public PrototypeBeanModeNo resolveBeanModeNo() {
    return this.beanModeNo;
  }

  public PrototypeBeanModeTargetClass resolveBeanModeTargetClass() {
    return this.beanModeTargetClass;
  }
}
