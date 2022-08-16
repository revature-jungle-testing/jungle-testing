package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class postCreateSteps {

    // both scenarios
    
    @Given("the user is on their dashboard page")
        public void the_user_is_on_their_dashboard_page(){
            TestRunner.driver.get("http://127.0.0.1:5500/The-Jungle_(1)%20(1)/FrontEnd/profilepage/profile-page.html");

            TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
            String title = TestRunner.driver.getTitle();
            Assert.assertEquals("Home", title);

        }

    @When("the user clicks on the create post modal button")
        public void the_user_clicks_on_the_create_post_modal_button(){
            TestRunner.postCreatePom.clickCreatePost();


        }

    @When("the user clicks on the post button")
        public void the_user_clicks_on_the_post_button(){
            TestRunner.postCreatePom.confirmPost();

        }

    // scenario 1

    @When("the user enters the post body")
        public void the_user_enters_the_post_body(){
            TestRunner.postCreatePom.goodPost("I like bananas!");


        }

    @Then("the user will see the created post")
        public void the_user_will_see_the_created_post(){
            TestRunner.wait.until(ExpectedConditions.textToBePresentInElement(TestRunner.postCreatePom.newlyCreatedPost,"I like bananas!"));
            String createdPost = TestRunner.postCreatePom.newlyCreatedPost.getText();
            Assert.assertEquals("I like bananas!", createdPost);

    }



    
}
