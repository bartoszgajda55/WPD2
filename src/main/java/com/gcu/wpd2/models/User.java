package com.gcu.wpd2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {
  @Id
  private String id;
  private String firstName;
  private String lastName;
  private String username;
  private String password;
  private String bio;
  private List<Project> projects;

  public User() {
  }

  public User(String username, String password) {
    this("", "", username, password, "");
  }

  public User(String firstName, String lastName, String username, String password, String bio) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.bio = bio;
  }

  public String getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getBio() {
    return bio;
  }

  public List<Project> getProjects() {
    return projects;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  @Override
  public String toString() {
    return String.format(
      "Customer[id=%s, firstName='%s', lastName='%s']",
      id, firstName, lastName);
  }
}
