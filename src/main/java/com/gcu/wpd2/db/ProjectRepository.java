package com.gcu.wpd2.db;

import com.gcu.wpd2.models.Project;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, String> {
  List<Project> findAll();
  Project findById(ObjectId id);
  Project findByTitle(String name);
}
