package com.example.Experiment.Controller;

import com.example.Experiment.Poll;
import com.example.Experiment.PollManager;
import com.example.Experiment.User;
import com.example.Experiment.VoteOption;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

public class PollController {
  private final PollManager pollManager;

  public PollController(PollManager pollManager) {
    this.pollManager = pollManager;
  }

  @GetMapping
  public Collection<Poll> getPolls(){
    return pollManager.getPolls().values();
  }

  @GetMapping("/{id}")
  public Poll getPoll(@PathVariable int id) {
    return pollManager.getPoll(id);
  }

  @PostMapping
  public Poll addPoll(@RequestParam String username, @RequestBody Poll poll) {
    User user = pollManager.getUser(username);
    poll.setCreatedBy(user);
    return pollManager.addPoll(poll);
  }

  @DeleteMapping("/{id}")
  public void deletepoll(@PathVariable long id) {
    pollManager.deletePoll(id);
  }

  @GetMapping("/{id}/options")
  public List<VoteOption> getOptions(@PathVariable long id) {
    Poll poll = pollManager.getPoll(id);
    if (poll == null) throw new RuntimeException("Poll not found");
    return poll.getOptions();
  }

}
