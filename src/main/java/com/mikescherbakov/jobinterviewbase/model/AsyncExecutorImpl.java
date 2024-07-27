package com.mikescherbakov.jobinterviewbase.model;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import org.springframework.stereotype.Component;

@Component
public class AsyncExecutorImpl<T> implements AsyncExecutor<T> {

  @Override
  public AsyncResult<T> execute(Supplier<T> supplier, Callback<T> callback) {
    AtomicReference<T> result = new AtomicReference<>();
    AtomicReference<RuntimeException> exception = new AtomicReference<>();
    AtomicBoolean hasException = new AtomicBoolean(false);
    AtomicBoolean isCompleted = new AtomicBoolean(false);
    new Thread(()->{
      try {
        result.set(supplier.get());
        isCompleted.set(true);
        callback.execute(result.get());
      } catch (RuntimeException ex) {
        hasException.set(true);
        exception.set(ex);
      }
    }).start();

    return new AsyncResult<T>() {
      @Override
      public boolean isCompleted() {
        return isCompleted.get();
      }

      @Override
      public boolean hasException() {
        return hasException.get();
      }

      @Override
      public T getResult() {
        return result.get();
      }

      @Override
      public RuntimeException getException() {
        return exception.get();
      }
    };
  }
}
