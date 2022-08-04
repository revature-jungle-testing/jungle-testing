Feature: User should be able to create a new profile given personal information

    Scenario: As a User, I should be able to register a new account, With correct informatrion.
        Given the user is on the sign up page
        When the user enters First name
        When the user enters Last name
        When the user enters Date of Birth
        When the user enters email
        When the user enters a correct username
        When the user enters a correct password
        When the user clicks on the signup button
        Then the user should be sent to their profile page

    Scenario: As the System, I want to reject bad new account creations with a blank username.
        Given the user is on the sign up page
        When the user enters First name
        When the user enters Last name
        When the user enters Date of Birth
        When the user enters email
        When the user enters a correct password
        When the user clicks on the signup button
        Then the user should receive an error over username

    Scenario: As the System, I want to reject bad new account creations with a duplicate email.
        Given the user is on the sign up page
        When the user enters First name
        When the user enters Last name
        When the user enters Date of Birth
        When the user enters duplicate email
        When the user enters a correct username
        When the user enters a correct password
        When the user clicks on the signup button
        Then the user should receive an error over email