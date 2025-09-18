package com.example.Experiment;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String username;
  private String email;
  @OneToMany(mappedBy = "createdBy")
  private Set<Poll> created = new LinkedHashSet<>();
  @OneToMany(mappedBy = "user")
  private Set<Vote> voted = new LinkedHashSet<>();
  public User() {}

  public User(String username, String email){
    this.username = username;
    this.email = email;
    this.created = new LinkedHashSet<>();
    this.voted = new LinkedHashSet<>();
  }


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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Poll createPoll(String question) {
    Poll poll = new Poll();
    poll.setQuestion(question);
    poll.setCreatedBy(this);
    this.created.add(poll);
    return poll;
  }

  public Vote voteFor(VoteOption option) {
    if (option == null) throw new IllegalArgumentException("VoteOption cannot be null");

    Vote vote = new Vote();
    vote.setUser(this);
    vote.setVoteOption(option);
    vote.setPublishedAt(java.time.Instant.now());
    this.voted.add(vote);

    return vote;
  }
}
