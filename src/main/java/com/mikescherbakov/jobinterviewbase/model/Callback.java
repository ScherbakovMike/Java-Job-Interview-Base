package com.mikescherbakov.jobinterviewbase.model;

public interface Callback<T> {
  void execute(T value);
}
