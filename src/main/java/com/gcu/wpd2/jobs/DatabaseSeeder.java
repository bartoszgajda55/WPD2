package com.gcu.wpd2.jobs;

import com.gcu.wpd2.db.UserRepository;
import com.gcu.wpd2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  @Autowired
  private UserRepository repository;

  @Override
  public void run(String... args) {
    repository.deleteAll();

    repository.save(new User("alice@test.com", bCryptPasswordEncoder.encode("password"), "Alice", "Smith", "Project Manager in Google"));
    repository.save(new User("bob@test.com", bCryptPasswordEncoder.encode("password"), "Bob", "Smith", "It's just Bob"));
  }
}
