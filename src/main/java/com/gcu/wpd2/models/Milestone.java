package com.gcu.wpd2.models;



import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Milestone {
  @Id
  private ObjectId _id;
  private String name;
  private String content;
  private String deadline;
  private boolean isCompleted;

  public Milestone(String name, String content, String deadline, boolean isCompleted) {
    this.name = name;
    this.content = content;
    this.deadline = deadline;
    this.isCompleted = isCompleted;
  }

  public Milestone(String name, String content) {
    this(name, content, null);
  }

  public Milestone(String name, String content, String deadline) {
    this.name = name;
    this.content = content;
    this.deadline = deadline;
  }

  public Milestone() {
  }

  public ObjectId getId() {
    return _id;
  }

  public String getName() {
    return name;
  }

  public String getContent() {
    return content;
  }

  public String getDeadline() {
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

  public void setDeadline(String deadline) {
    this.deadline = deadline;
  }

  public void setCompleted(boolean completed) {
    isCompleted = completed;
  }

  @Override
  public String toString() {
    return "Milestone{" +
            "_id=" + _id +
            ", name='" + name + '\'' +
            ", content='" + content + '\'' +
            ", deadline='" + deadline + '\'' +
            ", isCompleted=" + isCompleted +
            '}';
  }
}