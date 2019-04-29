package com.gcu.wpd2.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Document(collection = "user")
public class User {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String bio;
    private List<ObjectId> projects;

    public User(String email, String password, String firstName, String lastName, String bio) {
        this(null, email, password, firstName, lastName, bio, new ArrayList<>());
    }

    public User() {
        this(null, "", "", "N/A", "N/A", "N/A", new ArrayList<>());
    }

    public User(ObjectId id, String email, String password, String firstName, String lastName, String bio, List<ObjectId> projects) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.projects = projects;
    }

    public ObjectId getId() {
        return id;
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

    public void setId(ObjectId id) {
        this.id = id;
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
          "id='" + id + '\'' +
          ", email='" + email + '\'' +
          ", firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", bio='" + bio + '\'' +
          ", projects=" + projects +
          '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
