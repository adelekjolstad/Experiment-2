package com.example.Experiment.Controller;

import com.example.Experiment.PollManager;
import com.example.Experiment.User;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {
  private final PollManager pollManager;

  public UserController(PollManager pollManager) {
    this.pollManager = pollManager;
  }

  @GetMapping
  public Collection<User> getAllUsers() {
    return pollManager.getUsers().values();
  }

  @GetMapping("/{username}")
  public User getUser(@PathVariable String username) {
    return pollManager.getUser(username);
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    return pollManager.addUser(user);
  }

  @DeleteMapping("/{username}")
  public void deleteUser(@PathVariable String username){
    pollManager.deleteUser(username);
  }
}
