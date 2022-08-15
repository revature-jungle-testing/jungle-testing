Feature: Users should be able to create a post with text and images

    Scenario: As a user I want to create a post
        Given the user is on the login page
        When the user logs into their account
        When the user clicks on the create post modal button
        When the user enters the post body
        When the user clicks on the post button
        Then the user will see the created post

   Scenario: As a system I want to reject bad posts
        Given the user is on the login page
        When the user logs into their account
        When the user clicks on the create post modal button
        When the user enters their post body with too much text
        When the user clicks on the post button
        Then no post will be made and the user will remain on their homepage