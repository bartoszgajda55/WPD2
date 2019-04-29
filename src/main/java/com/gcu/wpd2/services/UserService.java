package com.gcu.wpd2.services;

import com.gcu.wpd2.db.UserRepository;
import com.gcu.wpd2.models.Project;
import com.gcu.wpd2.models.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public void saveUser(User user) {
    this.userRepository.save(user);
  }

  public void saveUserAndHashPassword(User user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    userRepository.save(user);
  }

  public List<User> getAll() {
    return userRepository.findAll();
  }

  public User findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public List<ObjectId> getUserProjectIdsByEmail(String email) {
    return userRepository.findByEmail(email).getProjects();
  }

  public void deleteUserProjectByEmail(String email, ObjectId projectId) {
    User user = this.userRepository.findByEmail(email);
    user.getProjects().remove(projectId);
    userRepository.save(user);
  }
}
