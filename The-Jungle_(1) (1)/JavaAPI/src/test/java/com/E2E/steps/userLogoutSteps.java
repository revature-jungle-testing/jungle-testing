package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class userLogoutSteps {
    @Given("user is on the home-page")
    public void user_is_on_the_home_page() {
        TestRunner.driver.get("https://cam634.github.io/FrontEnd/profilepage/profile-page.html");
    }
    @When("user clicks on the logout button")
    public void user_clicks_on_the_logout_button() {
        TestRunner.userLogoutPom.logoutButton();

    }
    @Then("user will be redirected to the landing page")
    public void user_will_be_redirected_to_the_landing_page() {
        TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
            String title = TestRunner.driver.getTitle();
            Assert.assertEquals("Home", title);
    }
}
