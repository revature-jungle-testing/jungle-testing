# Test Plan
This test plan is a project-wide document with information specific to the project that it is attached to.

This is our plan for our Final Project (Project #3) where we are testing the social media application, the Jungle.

## Goal
Our goal is to test the Jungle, and add on a few new features.

We will be given zipped code of the Jungle and must add it into a new project repository, which is right here: [github repository](https://github.com/revature-The-Jungle/The-Jungle)

In Phase One, we will then create our own database, reconfigure the database connection, and test the previous Java code to ensure our application works.

In Phase Two, we will then write new features to add onto the application. We should then check that our required functionality works and the entire application runs successfully.

Our deadline is 8/18.

## Technologies
These are the various technologies we will be using in our project.

- UI
    - HTML: the backbone of our webpages
    - CSS: styles our webpages
    - JavaScript: helps add dynamic features to our UI, methods to work with API
- SQL
    - AWS (RDS: PostgreSQL, follow up on Elastic Beanstalk): remote database
    - DBeaver: database application
- Java
    - Hibernate: uses object-relational mapping to connect Java code with our SQL database
    - Unit Testing
        - Mockito: can create mock objects so we can run service tests without affecting our database
    - Integration Testing
        - Javalin: supports HTTP requests
        - Postman: controls API functions
    - E2E Testing
        - Cucumber-Junit: testing framework that integrates with Cucumber
        - Cucumber: testing framework to run acceptance criteria into executable steps
    - Selenium
        - Browser automation tool
- Workspace
    - Github: where our repository is located
    - Github Actions: hosts our site remotely so everyone can access it

## Sprint Backlog
These are all the user stories we need to complete a minimum viable product (MVP):

Phase One:

Phase Two:

As a user, I should be able to create a post with texts and images.

As a user, I should be able to comment on posts or other comments.

As a user, I should have a post feed that displays other user's posts.

## Product Backlog
These are some stretch goals we can add in upon completing our MVP:

As a user, I should be able to create and maintain a profile page that is visible to other users.

As a user, I should be able to react in various ways to another user's post.

As a user, I should be able to create or join a group/team where there can be collaborative posts only for the group/team to view.

## Requirement Documentation

- Test Plan
    - This is our test plan
- Test Case
- Requirements Traceability Matrix
    - [This is the link to the Google Sheets](
https://docs.google.com/spreadsheets/d/1_LSMeeyc0zRD3C_axRhEhj5vYdgETOQip0AXORZRBFk/edit?usp=sharing)
- Acceptance Criteria
    - We will convert user stories to acceptance criteria once we have it all
    - There is a positive AND negative test for each feature so we can make sure it's solid and bug-free

## Testing Requirements
See Sprint Backlog for what user stories we will be testing for, or look at Acceptance Criteria above.

- Unit Tests
    - "Repository Layer"
        - All methods must have a positive test
            - This is where we will take a single piece of the application's code logic and test it in isolation
            - The goal of this is to check the logic of the code we have written
    - "Service Layer"
        - All methods must have a negative test per business rule
            - We can use Mockito to stub the methods for these tests
            - This is where we will confirm that we have handled any business logic that has specifically been requested

- Integration Tests
    - API
        - All routes must have a positive test
        - All routes must have a negative test per business rue

- End to End Tests
    - All acceptance criteria must be tested via Cucumber and Selenium

### PHASE ONE TESTS:

#### User:
- createNewUser(User user)
- requestLogin(String username, String password)
- getUserById(int userId)
- searchForUser(String username)
- getAllUsers()
- getGroupsNames(int userId)
- getGroups(int userId)

#### User Service:
- serviceCreateNewUser(User user)
- serviceRequestLogin(String username, String password)
- serviceGetUserById(int userId)
- serviceSearchForUser(String username)
- serviceGetAllUsers()
- serviceGetGroupsNames(int userId)
- serviceGetGroups(int userId)

#### Chat:
- createMessage(ChatMessage chatMessage)
- getMessageHistory(int groupId)
- getMessageHistory()

#### Chat Service:
- serviceCreateMessageObject(ChatMessage chatMessage)
- serviceGetMessageHistory(int groupId)
- serviceGetMessageHistory()

### PHASE TWO TESTS:
NOTE: Need to tweak these later, these are just ideas

#### Post:
- createPost(parameters here)
- getPostsByUsername(parameters here)
- createComment(parameters here)
- viewPostFeed(parameters here)

STRETCH:
- createCollabPost(parameters here)
- createReaction(parameters here)

#### Post Service: 
- serviceCreatePost(parameters here)
- serviceCreateComment(parameters here)
- serviceViewPostFeed(parameters here)

STRETCH:
- serviceCreateCollabPost(parameters here)
- serviceCreateReaction(parameters here)

#### Profile:
STRETCH:
- createProfilePage(parameters here)

#### Profile Service:
STRETCH:
- serviceCreateProfilePage(parameters here)

## Timeline
- Week of 8/1 - 8/5:
    - Create Github repo
    - Create database
    - Reconfigure JDBC to Hibernate
    - Upload Jungle zipped file onto our Github
    - More to be updated

- Week of 8/8 - 8/12:
    - To be updated

- Week of 8/15 - 8/18:
    - To be updated