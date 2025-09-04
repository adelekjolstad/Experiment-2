package com.example.Experiment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestApi {
  @Autowired
  private PollManager pollManager;
  @BeforeEach
  public void resetPollManager() {
    pollManager.setPolls(new HashMap<>());
    pollManager.setUsers(new HashMap<>());
    pollManager.setNextPollId(1);
  }

  @Test
  public void testCreateANdGetUser(@Autowired TestRestTemplate restTemplate) throws Exception {
    User user = new User();
    user.setUsername("user1");
    user.setEmail("user1@mail.no");

    ResponseEntity<User> postResponse = restTemplate.postForEntity(
        "/users",
        user,
        User.class
    );
    assertEquals(HttpStatus.OK, postResponse.getStatusCode());
    assertEquals("user1", postResponse.getBody().getUsername());

    // Get the user
    ResponseEntity<User> getResponse = restTemplate.getForEntity(
        "/users/user1",
        User.class
    );
    assertEquals(HttpStatus.OK, getResponse.getStatusCode());
    assertEquals("user1", getResponse.getBody().getUsername());
  }

  @Test
  public void testCreatePoll(@Autowired TestRestTemplate restTemplate) throws Exception {
    Poll poll = new Poll();
    poll.setQuestion("Favorite programming language?");
    poll.setPublishedAt(java.time.Instant.now());
    poll.setValidUntil(java.time.Instant.now().plusSeconds(86400));

    ResponseEntity<Poll> response = restTemplate.postForEntity(
        "/polls?username=user1",
        poll,
        Poll.class
    );
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("Favorite programming language?", response.getBody().getQuestion());

    ResponseEntity<Poll[]> pollsResponse = restTemplate.getForEntity("/polls", Poll[].class);
    assertEquals(HttpStatus.OK, pollsResponse.getStatusCode());
    assertEquals(1, pollsResponse.getBody().length);
  }

  @Test
  public void testVote(@Autowired TestRestTemplate restTemplate) throws Exception {

    User user1 = new User();
    user1.setUsername("user1");
    user1.setEmail("user1@example.com");
    restTemplate.postForEntity("/users", user1, User.class);

    User user2 = new User();
    user2.setUsername("user2");
    user2.setEmail("user2@example.com");
    restTemplate.postForEntity("/users", user2, User.class);

    Poll poll = new Poll();
    poll.setQuestion("Favorite language?");
    ResponseEntity<Poll> pollResponse = restTemplate.postForEntity(
        "/polls?username=user1", poll, Poll.class
    );

    Long pollId = pollResponse.getBody().getId();

    Vote vote = new Vote();
    VoteOption option = new VoteOption();
    option.setCaption("Java");
    vote.setVoteOption(option);
    vote.setUser(user2);

    ResponseEntity<Vote> voteResponse = restTemplate.postForEntity(
        "/votes/" + pollId,
        vote,
        Vote.class
    );

    assertEquals(HttpStatus.OK, voteResponse.getStatusCode());
    assertEquals("user2", voteResponse.getBody().getUser().getUsername());
    assertEquals("Java", voteResponse.getBody().getVoteOption().getCaption());
  }



}

