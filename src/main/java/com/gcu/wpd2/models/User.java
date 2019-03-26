package com.gcu.wpd2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Document
public class User implements UserDetails {
  @Id
  private String id;
  private String firstName;
  private String lastName;
  private String username;
  private String password;
  private String bio;
  private List<Project> projects;
  private List<GrantedAuthority> grantedAuthorities;

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

  public User(String username, String password, String[] authorities) {
    this.username = username;
    this.password = password;
    this.grantedAuthorities = AuthorityUtils.createAuthorityList(authorities);
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

  @Override
  public String getUsername() {
    return username;
  }

  @Override
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
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }

  @Override
  public String toString() {
    return "User{" +
      "id='" + id + '\'' +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", bio='" + bio + '\'' +
      ", projects=" + projects +
      ", grantedAuthorities=" + grantedAuthorities +
      '}';
  }
}
