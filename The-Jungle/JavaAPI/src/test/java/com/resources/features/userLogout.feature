Feature: User is able to logout and close session

    Scenario: As a user I want to log out from my account
        Given user is on the home-page
        When user clicks on the logout button
        Then user will be redirected to the landing page
