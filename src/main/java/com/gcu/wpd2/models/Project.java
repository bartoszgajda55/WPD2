package com.gcu.wpd2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Project {
  @Id
  private String id;
  private String name;
  private String description;
  private Date starDate;
  private Date endDate;
  private List<Milestone> milestones;

  public Project(String name, String description, Date starDate, Date endDate, List<Milestone> milestones) {
    this.name = name;
    this.description = description;
    this.starDate = starDate;
    this.endDate = endDate;
    this.milestones = milestones;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Date getStarDate() {
    return starDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public List<Milestone> getMilestones() {
    return milestones;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setStarDate(Date starDate) {
    this.starDate = starDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return "Project{" +
      "id='" + id + '\'' +
      ", name='" + name + '\'' +
      ", description='" + description + '\'' +
      ", starDate=" + starDate +
      ", endDate=" + endDate +
      ", milestones=" + milestones +
      '}';
  }
}