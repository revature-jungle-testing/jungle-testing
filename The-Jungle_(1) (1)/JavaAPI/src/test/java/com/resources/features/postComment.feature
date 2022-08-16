Feature: Users should be able to comment on a post

    Scenario: As a user I want to comment on a post
        Given the user is on their dashboard page
        When the user enters a comment
        When the user clicks on the create comment button
        Then the user will see their comment on another user post

    