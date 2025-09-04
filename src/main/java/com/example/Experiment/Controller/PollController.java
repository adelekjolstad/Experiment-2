package com.example.Experiment.Controller;

import com.example.Experiment.Poll;
import com.example.Experiment.PollManager;
import com.example.Experiment.User;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/polls")
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

}
