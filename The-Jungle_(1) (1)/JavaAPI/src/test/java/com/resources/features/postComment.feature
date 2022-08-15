Feature: Users should be able to comment on a post

    Scenario: As a user I want to comment on a post
        Given the user is on the login page
        When the user logs into their account
        When the user enters a comment
        When the user clicks on the create comment button
        Then the user will see their comment on another user post

    Scenario: As a system I want to reject bad comments
        Given the user is on the login page
        When the user logs into their account
        When the user enters a comment that is too long
        When the user clicks on the create comment button
        Then an error message will appear that the comment could not be made