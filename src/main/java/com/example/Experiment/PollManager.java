package com.example.Experiment;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PollManager {
  public Map<String, User> getUsers() {
    return users;
  }

  public Map<Long, Poll> getPolls() {
    return polls;
  }

  public void setUsers(Map<String, User> users) {
    this.users = users;
  }

  public void setPolls(Map<Long, Poll> polls) {
    this.polls = polls;
  }

  private Map<String, User> users = new HashMap<>();
  private Map<Long, Poll> polls = new HashMap<>();
}
