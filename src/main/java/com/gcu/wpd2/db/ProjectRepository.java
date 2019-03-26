package com.gcu.wpd2.db;

import com.gcu.wpd2.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {
  public Project findByName(String name);
}
