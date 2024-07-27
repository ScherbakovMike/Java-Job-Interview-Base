package com.mikescherbakov.jobinterviewbase.model;

import java.util.function.Supplier;

public interface AsyncExecutor<T> {
  AsyncResult<T> execute(Supplier<T> supplier, Callback<T> callback);
}
