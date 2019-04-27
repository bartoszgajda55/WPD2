package com.gcu.wpd2.jobs;

import com.gcu.wpd2.db.ProjectRepository;
import com.gcu.wpd2.db.UserRepository;
import com.gcu.wpd2.models.Project;
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
  private UserRepository userRepository;
  @Autowired
  private ProjectRepository projectRepository;

  @Override
  public void run(String... args) {
    userRepository.deleteAll();

    User alice = new User("alice@test.com", bCryptPasswordEncoder.encode("password"), "Alice", "Smith", "Project Manager in Google");
    User bob = new User("bob@test.com", bCryptPasswordEncoder.encode("password"), "Bob", "Smith", "It's just Bob");
    userRepository.save(bob);
    userRepository.save(alice);

    Project wpd2 = new Project(null, "WPD2", "Web Platform Development 2", "2019-04-02", "2019-04-06");
    Project ip3 = new Project(null, "IP3", "Integrated Project 3", "2019-04-01", "2019-04-05");
    Project rspi = new Project(null, "RSPI", "Research Skills and Professional Issues", "2019-04-20", "2019-04-30");
    rspi.addUserToSharedWith(bob);
    projectRepository.save(wpd2);
    projectRepository.save(ip3);
    projectRepository.save(rspi);

    bob.addProject(wpd2.getId());
    bob.addProject(ip3.getId());
    alice.addProject(rspi.getId());
    userRepository.save(bob);
    userRepository.save(alice);
  }
}
