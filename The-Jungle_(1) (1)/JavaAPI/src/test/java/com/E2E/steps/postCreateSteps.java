package com.E2E.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class postCreateSteps {

    // both scenarios
    
    @Given("the user is on their dashboard page")
        public void the_user_is_on_their_dashboard_page(){

        }

    @When("the user clicks on the create post modal button")
        public void the_user_clicks_on_the_create_post_modal_button(){

        }

    @When("the user clicks on the post button")
        public void the_user_clicks_on_the_post_button(){

        }

    // scenario 1

    @When("the user enters the post body")
        public void the_user_enters_the_post_body(){

        }

    @Then("the user will see the created post")
        public void the_user_will_see_the_created_post(){

    }

    // scenario 2

    @When("the user enters their post body with too much text")
        public void the_user_enters_their_post_body_with_too_much_text(){

        }

    @Then("the user will see an error message in the post feed")
        public void the_user_will_see_an_error_message_in_the_post_feed(){

    }

    
}
