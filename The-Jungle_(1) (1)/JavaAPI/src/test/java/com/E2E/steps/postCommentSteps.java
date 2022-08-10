package com.E2E.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class postCommentSteps {
    
    // both scenarios

    // the @Given is on postCreate

    @When("the user clicks on the create comment button")
        public void the_user_clicks_on_the_create_comment_button(){

        }

    // scenario 1

    @When("the user enters a comment")
        public void the_user_enters_a_comment(){

        }

    @Then("the user will see their comment on another user post")
        public void the_user_will_see_their_comment_on_another_user_post(){

    }

    // scenario 2

    @When("the user enters a comment that is too long")
        public void the_user_enters_a_comment_that_is_too_long(){

        }

    @Then("an error message will appear that the comment could not be made")
        public void an_error_message_will_appear_that_the_comment_could_not_be_made(){

    }

}
