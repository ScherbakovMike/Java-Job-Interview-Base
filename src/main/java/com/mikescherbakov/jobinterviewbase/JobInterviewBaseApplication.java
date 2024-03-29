package com.mikescherbakov.jobinterviewbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// Spring Security is disabled
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class JobInterviewBaseApplication {

  public static void main(String[] args) {
    SpringApplication.run(JobInterviewBaseApplication.class, args);
  }
}
