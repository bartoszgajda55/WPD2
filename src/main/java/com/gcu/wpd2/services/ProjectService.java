package com.gcu.wpd2.services;

import com.gcu.wpd2.db.ProjectRepository;
import com.gcu.wpd2.models.Project;
import com.gcu.wpd2.models.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    return this.projectRepository.findById(id);
  }

  public Project getByName(String name) {
    return this.projectRepository.findByTitle(name);
  }

  public void save(Project project) {
    this.projectRepository.save(project);
  }

  public void remove(Project project) {this.projectRepository.delete(project);}



  public void saveToUser(Project project, User user) {
    this.projectRepository.save(project);
    user.getProjects().add(project.getId());
    userService.saveUser(user);
  }

  public List<Project> getAllByUserEmail(String email) {
    List<Project> projects = new ArrayList<>();
    this.userService.getUserProjectIdsByEmail(email).forEach(objectId -> {
      projects.add(this.getById(objectId));
    });
    return projects;
  }

  public List<Project> getSharedWithByUserId(ObjectId id) {
    List<Project> sharedWith = new ArrayList<>();
    this.projectRepository.findAll().forEach(project -> {
      if(project.getSharedWith().contains(id))
        sharedWith.add(project);
    });
    return sharedWith;
  }

  public Map<ObjectId, String> getTitlesMappedById(String email) {
    Map<ObjectId, String> projectsNameId = new HashMap<>();
    this.userService.getUserProjectIdsByEmail(email).forEach(objectId -> {
      projectsNameId.put(objectId, this.getById(objectId).getTitle());
    });
    return projectsNameId;
  }

  public void update(Project project) {
    this.projectRepository.save(project);
  }

  public void delete(Project project) {
    this.projectRepository.delete(project);
  }

}
