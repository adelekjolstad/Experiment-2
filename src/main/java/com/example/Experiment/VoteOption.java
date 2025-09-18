package com.example.Experiment;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class VoteOption {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @ManyToOne
  @JoinColumn(name = "poll_id")
  private Poll poll;
  private String caption;
  private int presentationOrder;
  @OneToMany(mappedBy = "voteOption")
  private Set<Vote> votes = new LinkedHashSet<>();
  private Integer getId() {
    return id;
  }

  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public int getPresentationOrder() {
    return presentationOrder;
  }

  public void setPresentationOrder(int presentationOrder) {
    this.presentationOrder = presentationOrder;
  }

  public Poll getPoll() {
    return poll;
  }

  public void setPoll(Poll poll) {
    this.poll = poll;

  }
  public  Set<Vote> getVotes() {
    return votes;
  }
  public void setVotes(Set<Vote> votes) {
    this.votes = votes;
  }
  public VoteOption() {}
}
