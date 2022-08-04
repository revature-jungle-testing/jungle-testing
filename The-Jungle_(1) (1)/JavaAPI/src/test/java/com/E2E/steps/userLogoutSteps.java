package com.E2E.steps;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class userLogoutSteps {
    @Given("user is on the home-page")
    public void user_is_on_the_home_page() {
        TestRunner.driver.get("File://C:/Users/lyndo/Revature-Training/Project3/jungle-testing/The-Jungle_(1) (1)/FrontEnd/profilepage/profile-page.html");
    }
    @When("user clicks on the logout button")
    public void user_clicks_on_the_logout_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user will be redirected to the landing page")
    public void user_will_be_redirected_to_the_landing_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
