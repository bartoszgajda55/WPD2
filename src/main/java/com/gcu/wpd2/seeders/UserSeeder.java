package com.gcu.wpd2.seeders;

import com.gcu.wpd2.db.UserRepository;
import com.gcu.wpd2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder implements CommandLineRunner {

  @Autowired
  private UserRepository repository;

  @Override
  public void run(String... args) throws Exception {
    repository.deleteAll();

    repository.save(new User("Alice", "Smith", "alice123", "password", "Project Manager in Google"));
    repository.save(new User("Bob", "Smith", "bob123", "password", "It's just Bob"));
  }
}
