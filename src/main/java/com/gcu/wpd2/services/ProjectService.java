package com.gcu.wpd2.services;

import com.gcu.wpd2.db.ProjectRepository;
import com.gcu.wpd2.models.Project;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
  @Autowired
  private ProjectRepository projectRepository;
  @Autowired
  private UserService userService;

  public List<Project> getAll() {
    return projectRepository.findAll();
  }

  public Project getById(ObjectId id) {
    return this.projectRepository.findBy_id(id);
  }

  public List<Project> getAllByUserEmail(String email) {
    List<Project> projects = new ArrayList<>();
    this.userService.getUserProjectIdsByEmail(email).forEach(objectId -> {
      projects.add(this.getById(objectId));
    });
    return projects;
  }
}
