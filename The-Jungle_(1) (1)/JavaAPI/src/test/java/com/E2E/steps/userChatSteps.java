package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class userChatSteps {

@Given("the user is on their home page")
public void the_user_is_on_their_home_page(){
    TestRunner.driver.get("https://cam634.github.io/FrontEnd/profilepage/profile-page.html");
}
@When("the user clicks the chat room button")
public void the_user_clicks_the_chat_room_button(){
    TestRunner.userGlobalChat.chatButton();
}
@Then("the users should be redirected to chat room")
public void the_users_should_be_redirected_to_chat_room(){
    TestRunner.wait.until(ExpectedConditions.titleIs("ChatRoom"));
    String title = TestRunner.driver.getTitle();
    Assert.assertEquals("ChatRoom", title);
}

@Given("the user is in the chatroom")
public void the_user_is_in_the_chatroom(){
    TestRunner.driver.get("https://cam634.github.io/FrontEnd/chatpage/chat-page.html");
    TestRunner.driver.manage().window().maximize();


}

@When("the user clicks on the logo")
public void the_user_clicks_on_the_logo(){
    TestRunner.userGlobalChat.homeButton();
}

@Then("they are redirected to their home page")
public void they_are_redirected_to_their_home_page(){
    TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
    String title = TestRunner.driver.getTitle();
    Assert.assertEquals("Home", title);
}

@When("the user enters their chat message")
public void the_user_enters_their_chat_message(){
    TestRunner.userChatPom.msgInput("This is a sentence for texting message");
    // TestRunner.userChatPom.msgInput.sendKeys(Keys.ENTER);
}

@When("the user clicks the send chat message button")
public void the_user_clicks_the_send_chat_message_button(){
    TestRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[3]/button")));
    TestRunner.userChatPom.sendButton();
}

@Then("the message will appear in chat")
public void the_message_will_appear_in_chat(){
    // TestRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/div[1]/div")));
    TestRunner.wait.until(ExpectedConditions.textToBePresentInElement(TestRunner.userChatPom.chatOutput,"This is a sentence for texting message"));
    String chatOutput = TestRunner.userChatPom.chatOutput.getText();
    Assert.assertEquals("This is a sentence for texting message", chatOutput);
}


// @When("the user clicks on the Choose File button in chatroom")
// public void the_user_clicks_on_the_Choose_File_button_in_chatroom(){

// }

// @When("the user selects their chat image they want to send")
// public void the_user_selects_their_chat_image_they_want_to_send(){

// }

// @Then("the image appears in the group chat")
// public void the_image_appears_in_the_group_chat(){

// }

// @When("the user selects their chat image that is too big")
// public void the_user_selects_their_chat_image_that_is_too_big(){

// }

// @Then("the user clicks the alert button saying File is too big to send")
// public void the_user_clicks_the_alert_button_saying_File_is_too_big_to_send(){

// }



// @When("the user clicks on the refresh button")
// public void the_user_clicks_on_the_refresh_button(){

// }

// @Then("the user will see their previous messages")
// public void the_user_will_see_their_previous_messages(){

// }


}
