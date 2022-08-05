Feature: User should be able to find existing and matching profiles when searching by username

    Scenario: As a user I want to be able to Search for a user by username
        Given the user is on the homepage
        When user inputs username into the search input field
        When the user clicks the search button
        Then results will be displayed

    Scenario: As a System I don't want to allow incorrect usernames to be searched
        Given the user is on the homepage
        When user inputs incorrect username into the search input field
        When the user clicks the search button
        Then no results displayed