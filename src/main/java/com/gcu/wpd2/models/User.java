package com.gcu.wpd2.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
public class User {
    @Id
    private ObjectId _id;
    @Indexed(unique = true)
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String bio;
    private List<ObjectId> projects;

    public User(String email, String password, String firstName, String lastName, String bio) {
        this(email, password, firstName, lastName, bio, new ArrayList<>());
    }

    public User(String email, String password, String firstName, String lastName, String bio, List<ObjectId> projects) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.projects = projects;
    }

    public User() {
    }

    public ObjectId getId() {
        return _id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBio() {
        return bio;
    }

    public List<ObjectId> getProjects() {
        return projects;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void addProject(ObjectId id) {
        this.projects.add(id);
    }

    @Override
    public String toString() {
        return "User{" +
          "id='" + _id + '\'' +
          ", email='" + email + '\'' +
          ", firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", bio='" + bio + '\'' +
          ", projects=" + projects +
          '}';
    }
}
