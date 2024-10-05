package com.mikescherbakov.jobinterviewbase.runner;

import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RecordMatchingRunner implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    var testRecord = new TestRecord("Mike", LocalDate.of(1988, 9, 17));
    if(testRecord instanceof TestRecord(String name, LocalDate birthDate)) {
      System.out.printf("Name: %s, Birth date: %s%n", name, birthDate);
    }
  }

  record TestRecord(String name, LocalDate birthDate) {}

}
