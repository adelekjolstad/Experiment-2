package com.example.Experiment.Controller;

import com.example.Experiment.Poll;
import com.example.Experiment.PollManager;
import com.example.Experiment.Vote;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Collection;

@RestController
@RequestMapping("/votes")
public class VoteController {
  private final PollManager pollManager;

  public VoteController(PollManager pollManager) {
    this.pollManager = pollManager;
  }

  @PostMapping("/{id}")
  public Vote vote(@PathVariable Long id, @RequestBody Vote vote) {
    Poll poll = pollManager.getPoll(id);
    if (poll == null) throw new RuntimeException("Poll not found");

    vote.setPublishedAt(Instant.now());
    pollManager.addVotesByPoll(id, vote);
    return vote;
  }

  @GetMapping("/{id}")
  public Collection<Vote> getVotes(@PathVariable Long id) {
    return pollManager.getVotes(id);
  }
}
