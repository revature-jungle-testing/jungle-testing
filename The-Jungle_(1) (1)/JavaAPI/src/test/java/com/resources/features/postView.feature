Feature: Users should be able to view their post and other user's posts

    Scenario: As a user, I want to view posts

        Given the user is on their dashboard page
        When they refresh the page
        Then the user should be able to view their post feed