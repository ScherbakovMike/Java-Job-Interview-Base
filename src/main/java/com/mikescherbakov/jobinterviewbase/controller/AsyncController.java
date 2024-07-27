package com.mikescherbakov.jobinterviewbase.controller;

import com.mikescherbakov.jobinterviewbase.model.AsyncResult;
import com.mikescherbakov.jobinterviewbase.service.AsyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AsyncController {

  private final AsyncService asyncService;
  private AsyncResult<Integer> result = null;

  @GetMapping("/start")
  public ResponseEntity<AsyncResult<Integer>> startProcess() {
    this.result = asyncService.executeLongOperation();
    return ResponseEntity.ok(this.result);
  }

  @GetMapping("/get")
  public ResponseEntity<AsyncResult<Integer>> getResult() {
    return ResponseEntity.ok(this.result);
  }
}
