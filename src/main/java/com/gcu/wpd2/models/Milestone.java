package com.gcu.wpd2.models;



import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Milestone {
  @Id
  private ObjectId id;
  private String title;
  private String content;
  private String deadline;
  private boolean isCompleted;

  public Milestone(String title, String content, String deadline, boolean isCompleted) {
    this.title = title;
    this.content = content;
    this.deadline = deadline;
    this.isCompleted = isCompleted;
  }

  public Milestone(String title, String content) {
    this(title, content, null);
  }

  public Milestone(String title, String content, String deadline) {
    this.title = title;
    this.content = content;
    this.deadline = deadline;
    this.isCompleted = false;
  }

  public Milestone() {
  }

  public ObjectId getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public String getDeadline() {
    return deadline;
  }

  public boolean getIsCompleted() {return isCompleted;}

  public void setTitle(String title) {
    this.title = title;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setDeadline(String deadline) {
    this.deadline = deadline;
  }

  public void setIsCompleted(boolean completed) {
    isCompleted = completed;
  }

  @Override
  public String toString() {
    return "Milestone{" +
            "_id=" + id +
            ", name='" + title + '\'' +
            ", content='" + content + '\'' +
            ", deadline='" + deadline + '\'' +
            ", isCompleted=" + isCompleted +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Milestone)) return false;

    Milestone milestone = (Milestone) o;

    return id != null ? id.equals(milestone.id) : milestone.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}