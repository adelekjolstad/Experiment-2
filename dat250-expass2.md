# DAT250 Experiment 2

## Implemented 
I developed a simple REST API for managing Polls using Spring Boot. It includes endpoints for Users, Polls, Votes, and Voteoptions, along with automated tests for the controllers. 

## Technical problems 
At the beginning, i had issues with duplicated users, which i resolved by correcting the way users were added to the system. 

I also faced problems wihle testing polls: Creating a single poll returned two when all tests were run together. This was fixed by resetting the "pollManager" before each test. 

I decided not to create a separate voteOption controller. Instead, all the voting logic was implemented directly in the PollController. 
