package com.example.Experiment;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Vote {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private Instant publishedAt;
  @ManyToOne
  @JoinColumn(name = "vote_option_id")
  private VoteOption voteOption;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

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
  public long getId() {
    return id;
  }

  public void setVoteOption(VoteOption voteOption) {
    this.voteOption = voteOption;
  }

  public void setUser(User user) {
    this.user = user;
  }


  public Vote() {}
}
