package com.mikescherbakov.jobinterviewbase.runner;

import com.mikescherbakov.jobinterviewbase.model.*;
import com.mikescherbakov.jobinterviewbase.repository.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Component
@Slf4j
@RequiredArgsConstructor
public class StartupRunnerConfiguration implements CommandLineRunner {

  private final UserRepository userRepository;

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    var address = new Address(1L, "Main Street", null);
    var user = new User(1L, "John Doe", address);
    address.setUser(user);
    var savedUser = userRepository.save(user);
  }
}
