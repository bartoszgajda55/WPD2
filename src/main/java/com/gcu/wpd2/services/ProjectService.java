package com.gcu.wpd2.services;

import com.gcu.wpd2.db.ProjectRepository;
import com.gcu.wpd2.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
  @Autowired
  private ProjectRepository projectRepository;

  public List<Project> getAll() {
    return projectRepository.findAll();
  }
}
