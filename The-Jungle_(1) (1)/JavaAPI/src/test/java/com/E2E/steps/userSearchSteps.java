package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class userSearchSteps {

    //Search Posi Steps
    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        TestRunner.driver.get("https://cam634.github.io/FrontEnd/profilepage/profile-page.html");
    }
    @When("user inputs username into the search input field")
    public void user_inputs_username_into_the_search_input_field() {
        TestRunner.userSearchPom.searchInput("ApeEscape");
    }
    @When("the user clicks the search button")
    public void the_user_clicks_the_search_button() {
        TestRunner.userSearchPom.searchButton();
    }
    @Then("results will be displayed")
    public void results_will_be_displayed() {
        TestRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[3]/ul/li[1]/a")));
        TestRunner.wait.until(ExpectedConditions.textToBePresentInElement(TestRunner.userSearchPom.searchDrop,"ApeEscape"));
        String searchOutput = TestRunner.userSearchPom.searchDrop.getText();
        Assert.assertEquals("ApeEscape", searchOutput);
    }

    //Search Neg Steps
    @When("user inputs incorrect username into the search input field")
    public void user_inputs_incorrect_username_into_the_search_input_field() {
        TestRunner.userSearchPom.searchInput("WooglyBoogly");
    }
    @Then("no results displayed")
    public void no_results_displayed() {
        TestRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[3]/ul/li")));
        TestRunner.wait.until(ExpectedConditions.textToBePresentInElement(TestRunner.userSearchPom.noDrop,"No Results"));
        String searchOutput = TestRunner.userSearchPom.noDrop.getText();
        Assert.assertEquals("No Results", searchOutput);
    }
}
