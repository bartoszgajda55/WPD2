package com.gcu.wpd2.db;

import com.gcu.wpd2.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
  public User findByEmail(String email);
  public User findByFirstNameAndLastName(String firstName, String lastName);
}
