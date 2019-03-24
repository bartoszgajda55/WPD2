package com.gcu.wpd2.db;

import com.gcu.wpd2.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
  public User findByFirstName(String firstName);
  public List<User> findByLastName(String lastName);
}
