package com.gcu.wpd2.db;

import com.gcu.wpd2.models.Milestone;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MilestoneRepository extends MongoRepository<Milestone, String> {
   Milestone findByTitle(String title);

  Milestone findBy_id(ObjectId id);

}
