package com.gcu.wpd2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Milestone {
  @Id
  private String id;
  private String name;
  private String content;
  private Date deadline;
  private boolean isCompleted;

  public Milestone(String name, String content) {
    this(name, content, null);
  }

  public Milestone(String name, String content, Date deadline) {
    this.name = name;
    this.content = content;
    this.deadline = deadline;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getContent() {
    return content;
  }

  public Date getDeadline() {
    return deadline;
  }

  public boolean isCompleted() {
    return isCompleted;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }

  public void setCompleted(boolean completed) {
    isCompleted = completed;
  }

  @Override
  public String toString() {
    return "Milestone{" +
      "id='" + id + '\'' +
      ", name='" + name + '\'' +
      ", content='" + content + '\'' +
      ", deadline=" + deadline +
      '}';
  }
}