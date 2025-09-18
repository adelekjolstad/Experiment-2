package com.example.Experiment;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "polls")
public class Poll {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String question;
  private Instant publishedAt;
  private Instant validUntil;
  @ManyToOne
  @JoinColumn(name = "created_by")
  private User createdBy;

  @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
  private List<VoteOption> options = new ArrayList<>();

  public void setId(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

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


  public User getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(User createdBy) {
    this.createdBy = createdBy;
  }

  public VoteOption addVoteOption(String caption) {
    VoteOption option = new VoteOption();
    option.setCaption(caption);
    option.setPresentationOrder(options.size());
    option.setPoll(this);
    options.add(option);

    return option;
  }

  public Poll() {}

}
