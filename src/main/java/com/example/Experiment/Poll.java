package com.example.Experiment;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Poll {
  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public Instant getPublishedAt() {
    return publishedAt;
  }

  public void setPublishedAt(Instant publishedAt) {
    this.publishedAt = publishedAt;
  }

  public Instant getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(Instant validUntil) {
    this.validUntil = validUntil;
  }

  public List<VoteOption> getOptions() {
    return options;
  }

  public void setOptions(List<VoteOption> options) {
    this.options = options;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public User getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(User createdBy) {
    this.createdBy = createdBy;
  }

  private String question;
  private Instant publishedAt;
  private Instant validUntil;
  private long id;
  private User createdBy;
  private List<VoteOption> options = new ArrayList<>();

  public Poll() {}

}
