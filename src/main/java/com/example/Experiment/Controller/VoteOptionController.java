package com.example.Experiment.Controller;

import com.example.Experiment.Poll;
import com.example.Experiment.PollManager;
import com.example.Experiment.VoteOption;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/polls/{id}/options")
public class VoteOptionController {
  private final PollManager pollManager;

  public VoteOptionController(PollManager pollManager) {
    this.pollManager = pollManager;
  }

  @GetMapping("/{id}")
  public List<VoteOption> getOptions(@PathVariable Long id) {
    Poll poll = pollManager.getPoll(id);
    return poll.getOptions();
  }

  @PostMapping("/{id}")
  public VoteOption addOption(@PathVariable Long id, @RequestBody VoteOption option) {
    Poll poll = pollManager.getPoll(id);
    poll.getOptions().add(option);
    return option;
  }
}
