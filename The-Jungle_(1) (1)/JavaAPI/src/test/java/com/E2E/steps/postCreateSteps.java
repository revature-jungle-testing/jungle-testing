package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class postCreateSteps {

    // both scenarios
    
    @Given("the user is on the login page")
        public void the_user_is_on_the_login_page(){
           TestRunner.driver.get("https://cam634.github.io/FrontEnd/loginpage/login.html");
        }

    @When("the user logs into their account")
        public void the_user_logs_into_their_account(){
            TestRunner.postCreatePom.login("ApeEscape123", "banana");
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

    // scenario 2

    @When("the user enters their post body with too much text")
        public void the_user_enters_their_post_body_with_too_much_text(){
            TestRunner.postCreatePom.badPost("Bananas are the single most important food in the world. Bananas are a necessity to life. I eat bananas. I BREATHE bananas. When I sleep, I dream in bananas. Yellow, brown, green, and everything in between-- every banana is delicious and deserves to be cherished. When I die, I want to be reincarnated as a banana.");
        }

    @Then("no post will be made and the user will remain on their homepage")
        public void no_post_will_be_made_and_the_user_will_remain_on_their_homepage(){
            TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
            String title = TestRunner.driver.getTitle();
            Assert.assertEquals("Home", title);
    }

    
}
