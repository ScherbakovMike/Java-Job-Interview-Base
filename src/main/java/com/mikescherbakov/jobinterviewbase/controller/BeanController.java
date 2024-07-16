package com.mikescherbakov.jobinterviewbase.controller;

import com.mikescherbakov.jobinterviewbase.service.BeanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BeanController {

  private final BeanService service;

  @GetMapping("/get-bean-mode-no")
  public ResponseEntity<String> getBeanModeNo() {
    return ResponseEntity.ok(service.resolveBeanModeNo().toString());
  }

  @GetMapping("/get-bean-mode-target-class")
  public ResponseEntity<String> getBeanModeTargetClass() {
    return ResponseEntity.ok(service.resolveBeanModeTargetClass().toString());
  }
}
