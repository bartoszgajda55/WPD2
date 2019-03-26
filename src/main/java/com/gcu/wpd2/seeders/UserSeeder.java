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

    repository.save(new User("Alice", "Smith", "alice123", "$2a$10$AjHGc4x3Nez/p4ZpvFDWeO6FGxee/cVqj5KHHnHfuLnIOzC5ag4fm", "Project Manager in Google"));
    repository.save(new User("Bob", "Smith", "bob123", "$2a$10$AjHGc4x3Nez/p4ZpvFDWeO6FGxee/cVqj5KHHnHfuLnIOzC5ag4fm", "It's just Bob"));
  }
}
