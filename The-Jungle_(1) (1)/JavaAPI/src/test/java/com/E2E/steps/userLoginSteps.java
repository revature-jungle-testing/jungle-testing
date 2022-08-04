package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class userLoginSteps {

    //Login Posi Steps
    @Given("the user is on the log-in page")
    public void the_user_is_on_the_log_in_page() {
        TestRunner.driver.get("https://cam634.github.io/FrontEnd/loginpage/login.html");
    }
    @When("the user enters correct username")
    public void the_user_enters_correct_username() {
        TestRunner.userLoginPom.usernameLoginInput("ApeEscape");
    }
    @When("the user enters correct password")
    public void the_user_enters_correct_password() {
        TestRunner.userLoginPom.passcodeLoginInput("banana");
        TestRunner.userLoginPom.rightSection();
    }
    @When("the user clicks on the log-in button correct")
    public void the_user_clicks_on_the_log_in_button_correct() {
        TestRunner.userLoginPom.submitLoginCorrect();
    }
    @Then("the user will be redirected to the homepage")
    public void the_user_will_be_redirected_to_the_homepage() {
        TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
            String title = TestRunner.driver.getTitle();
            Assert.assertEquals("Home", title);
    }

    //Login Neg Steps
    @When("the user enters wrong username")
    public void the_user_enters_wrong_username() {
        TestRunner.userLoginPom.usernameLoginInput("NotAnApeEscape");
    }
    @When("the user enters wrong password")
    public void the_user_enters_wrong_password() {
        TestRunner.userLoginPom.passcodeLoginInput("notbanana");
        TestRunner.userLoginPom.rightSection();
    }
    @When("the user clicks on the log-in button incorrect")
    public void the_user_clicks_on_the_log_in_button_incorrect() {
        TestRunner.userLoginPom.submitLoginIncorrect();
    }
    @Then("error message will be displayed")
    public void error_message_will_be_displayed() {
        TestRunner.wait.until(ExpectedConditions.titleIs("Login"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Login", title);
        
    }

}
