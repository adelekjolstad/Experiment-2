package com.example.Experiment;

import java.time.Instant;

public class Vote {
  public Instant getPublishedAt() {
    return publishedAt;
  }

  public void setPublishedAt(Instant publishedAt) {
    this.publishedAt = publishedAt;
  }

  public VoteOption getVoteOption() {
    return voteOption;
  }

  public User getUser() {
    return user;
  }

  public void setVoteOption(VoteOption voteOption) {
    this.voteOption = voteOption;
  }

  public void setUser(User user) {
    this.user = user;
  }

  private Instant publishedAt;
  private VoteOption voteOption;
  private User user;

  public Vote() {}
}
