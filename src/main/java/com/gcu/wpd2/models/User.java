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
  private String email;
  private String password;
  private String bio;
  private List<Project> projects;

  public User() {
  }

  public User(String email, String password) {
    this("", "", email, password, "");
  }

  public User(String firstName, String lastName, String email, String password, String bio) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
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

  public String getEmail() {
    return email;
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

  public void setEmail(String email) {
    this.email = email;
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
