package com.gcu.wpd2.db;

import com.gcu.wpd2.models.Milestone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MilestoneRepository extends MongoRepository<Milestone, String> {
  public Milestone findByName(String name);
}