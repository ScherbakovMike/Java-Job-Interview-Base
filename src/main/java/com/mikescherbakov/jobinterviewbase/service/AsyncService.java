package com.mikescherbakov.jobinterviewbase.service;

import com.mikescherbakov.jobinterviewbase.model.AsyncExecutorImpl;
import com.mikescherbakov.jobinterviewbase.model.AsyncResult;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsyncService {

  private final AsyncExecutorImpl<Integer> executor;

  public AsyncResult<Integer> executeLongOperation() {
    return executor.execute(() -> {
          try {
            TimeUnit.SECONDS.sleep(5);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          return 5;
        },
        System.out::println);
  }
}
