package com.E2E.steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class userCreateSteps {

    private WebDriver driver;
    
    //Posi Steps
    @Given("the user is on the sign up page")
    public void the_user_is_on_the_sign_up_page() {
        TestRunner.driver.get("https://cam634.github.io/FrontEnd/registrationpage/sign-up.html");
    }
    @When("the user enters First name")
    public void the_user_enters_First_name() {
        TestRunner.userCreatePom.signupFirstname("Tareka");
    }
    @When("the user enters Last name")
    public void the_user_enters_Last_name() {
        TestRunner.userCreatePom.signupLastname("Mann");
    }
    @When("the user enters Date of Birth")
    public void the_user_enters_Date_of_Birth() {
        TestRunner.userCreatePom.signupBdate("30-03-2015");
    }
    @When("the user enters email")
    public void the_user_enters_email() {
       TestRunner.userCreatePom.signupEmail("Tareka@Revature.com");
    }
    @When("the user enters a correct username")
    public void the_user_enters_a_correct_username() {
        TestRunner.userCreatePom.signupUsername("tarekamann");
    }
    @When("the user enters a correct password")
    public void the_user_enters_a_correct_password() {
        TestRunner.userCreatePom.signupPassword("revatureisscary");
    }
    @When("the user clicks on the signup button")
    public void the_user_clicks_on_the_signup_button() {
       TestRunner.userCreatePom.signupbutton();
    }
    @Then("the user should be sent to their profile page")
    public void the_user_should_be_sent_to_their_profile_page() {
        TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Home", title);
    }

    
    
    //Neg Steps email
    @When("the user clicks on the signup button with bad info")
    public void the_user_clicks_on_the_signup_button_with_bad_info() {
       TestRunner.userCreatePom.signupbutton2();
    }
    @When("the user enters duplicate email")
    public void the_user_enters_duplicate_email() {
        TestRunner.userCreatePom.signupEmail("email@email.com");
    }
    @Then("the user should receive an error over email")
    public void the_user_should_receive_an_error_over_email() {
        TestRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorSubmitMessage")));
        TestRunner.wait.until(ExpectedConditions.textToBePresentInElement(TestRunner.userCreatePom.invalidMessage,"Email is already in use"));
        String errorMsg = TestRunner.userCreatePom.invalidMessage.getText();
        Assert.assertEquals("Email is already in use", errorMsg);
    }
    //Neg Steps username
    @Then("the user should receive an error over username")
    public void the_user_should_receive_an_error_over_username() {
        TestRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("invalidUserName")));
        TestRunner.wait.until(ExpectedConditions.textToBePresentInElement(TestRunner.userCreatePom.invalidMessage2,"Username is missing."));
        String errorMsg = TestRunner.userCreatePom.invalidMessage2.getText();
        Assert.assertEquals("Username is missing.", errorMsg);
    }
}
