package com.gcu.wpd2.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Document
public class Project {
  @Id
  private ObjectId _id;
  private String title;
  private String description;
  private Calendar startDate;
  private Calendar endDate;
  private List<Milestone> milestones;

  public Project() {
  }

  public Project(String name, String description, Calendar starDate, Calendar endDate) {
    this(name, description, starDate, endDate, new ArrayList<>());
  }

  public Project(String title, String description, Calendar starDate, Calendar endDate, List<Milestone> milestones) {
    this.title = title;
    this.description = description;
    this.startDate = starDate;
    this.endDate = endDate;
    this.milestones = milestones;
  }

  public ObjectId getId() {
    return _id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public Calendar getStartDate() {
    return startDate;
  }

  public Calendar getEndDate() {
    return endDate;
  }

  public List<Milestone> getMilestones() {
    return milestones;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setStartDate(Calendar startDate) {
    this.startDate = startDate;
  }

  public void setEndDate(Calendar endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return "Project{" +
      "_id='" + _id + '\'' +
      ", name='" + title + '\'' +
      ", description='" + description + '\'' +
      ", startDate=" + startDate +
      ", endDate=" + endDate +
      ", milestones=" + milestones +
      '}';
  }
}