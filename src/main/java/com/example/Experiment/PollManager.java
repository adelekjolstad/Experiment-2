package com.example.Experiment;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PollManager {
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

  public void addVotes(Long id, VoteOption voteOptions) {
    votesOptions.put(id, voteOptions);
  }

  private Map<String, User> users = new HashMap<>();
  private Map<Long, Poll> polls = new HashMap<>();
  private Map<Long, VoteOption> votesOptions = new HashMap<>();
  private long nextPollId = 1;
}
