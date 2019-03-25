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

  public void setName(String name) {
    this.name = name;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setDeadline(Date deadline) {
    this.deadline = deadline;
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
