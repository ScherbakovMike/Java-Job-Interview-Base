package com.mikescherbakov.jobinterviewbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

// Spring Security is disabled
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class,
    ManagementWebSecurityAutoConfiguration.class})
@PropertySource("classpath:application.properties")
@PropertySource("classpath:database.properties")
public class JobInterviewBaseApplication {

  public static void main(String[] args) {
    SpringApplication.run(JobInterviewBaseApplication.class, args);
  }
}
