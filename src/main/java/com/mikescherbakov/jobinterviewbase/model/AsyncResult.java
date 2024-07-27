package com.mikescherbakov.jobinterviewbase.model;

import java.io.Serializable;

public interface AsyncResult<T> extends Serializable {

  boolean isCompleted();

  boolean hasException();

  T getResult();

  RuntimeException getException();
}

