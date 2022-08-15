package com.E2E.steps;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class postViewSteps {

    // the @Given is on postCreate

    @When("they refresh the page")
        public void they_refresh_the_page(){
            TestRunner.driver.get("https://cam634.github.io/FrontEnd/profilepage/profile-page.html");
        }

    @Then("the user should be able to view their post feed")
        public void the_user_should_be_able_to_view_their_post_feed(){
            TestRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(TestRunner.postViewPom.postFeed));
        }
    
}
