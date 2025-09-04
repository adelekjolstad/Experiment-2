package com.example.Experiment;

public class User {
  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  private String username;
  private String email;

  public User() {}

}
