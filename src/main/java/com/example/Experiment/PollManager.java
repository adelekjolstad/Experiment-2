package com.example.Experiment;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PollManager {

  private Map<String, User> users = new HashMap<>();
  private Map<Long, Poll> polls = new HashMap<>();
  private Map<Long, VoteOption> votesOptions = new HashMap<>();

  private Map<Long, Map<String, Vote>> votesByPoll = new HashMap<>();

  public void setNextPollId(long nextPollId) {
    this.nextPollId = nextPollId;
  }

  private long nextPollId = 1;

  public Map<String, User> getUsers() {
    return users;
  }

  public User getUser(String username) {
    return users.get(username);
  }

  public void deleteUser(String username) {
    users.remove(username);
  }

  public void deletePoll(long id) {
    polls.remove(id);
  }

  public Map<Long, Poll> getPolls() {
    return polls;
  }

  public User addUser(User user) {
    users.put(user.getUsername(), user);
    return user;
  }

  public Poll addPoll(Poll poll) {
    poll.setId(nextPollId);
    polls.put(nextPollId,poll);
    nextPollId++;
    return poll;
  }

  public Poll getPoll(long id) {
    return polls.get(id);
  }

  public void setUsers(Map<String, User> users) {
    this.users = users;
  }

  public void setPolls(Map<Long, Poll> polls) {
    this.polls = polls;
  }

  public VoteOption getVoteOptions(long id) {
    return votesOptions.get(id);
  }

  public void addVotesByPoll(Long id, Vote vote) {
    if (vote == null || vote.getUser() == null) {
      throw new IllegalArgumentException("Vote or User cannot be null");
    }
    votesByPoll.putIfAbsent(id, new HashMap<>());
    votesByPoll.get(id).put(vote.getUser().getUsername(), vote);

  }

  public Collection<Vote> getVotes(long id) {
    return votesByPoll.getOrDefault(id, Map.of()).values();
  }




}
