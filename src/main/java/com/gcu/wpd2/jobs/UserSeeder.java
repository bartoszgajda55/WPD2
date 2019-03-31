package com.gcu.wpd2.jobs;

import com.gcu.wpd2.db.RoleRepository;
import com.gcu.wpd2.db.UserRepository;
import com.gcu.wpd2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class UserSeeder implements CommandLineRunner {
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  @Autowired
  private UserRepository repository;
  @Autowired
  private RoleRepository roleRepository;

  @Override
  public void run(String... args) {
    repository.deleteAll();

    repository.save(new User("alice@test.com", bCryptPasswordEncoder.encode("password"), "Alice", "Smith", "Project Manager in Google", new HashSet<>(Arrays.asList(roleRepository.findByRole("ADMIN")))));
    repository.save(new User("bob@test.com", bCryptPasswordEncoder.encode("password"), "Bob", "Smith", "It's just Bob", new HashSet<>(Arrays.asList(roleRepository.findByRole("ADMIN")))));
  }
}
