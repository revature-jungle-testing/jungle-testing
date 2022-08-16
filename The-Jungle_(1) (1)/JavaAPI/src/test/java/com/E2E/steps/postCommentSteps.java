package com.E2E.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.E2E.runner.TestRunner;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class postCommentSteps {
    
    // both scenarios

    // the @Given is on postCreate

    @When("the user clicks on the create comment button")
        public void the_user_clicks_on_the_create_comment_button(){
            TestRunner.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            TestRunner.wait.until(ExpectedConditions.visibilityOf(TestRunner.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/div[2]/input[1]"))));
            WebElement newer = TestRunner.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/div[2]/input[1]"));
            newer.sendKeys("This is a comment");
           
    

     
        }

    // scenario 1

    @When("the user enters a comment")
        public void the_user_enters_a_comment(){
            TestRunner.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            TestRunner.wait.until(ExpectedConditions.visibilityOf(TestRunner.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/input"))));
            TestRunner.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/input")).click();
         
            


        }

    @Then("the user will see their comment on another user post")
        public void the_user_will_see_their_comment_on_another_user_post(){
            TestRunner.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            TestRunner.wait.until(ExpectedConditions.visibilityOf(TestRunner.driver.findElement(By.xpath("//*[@id='commentMaker1']/input[2]"))));

            TestRunner.driver.findElement(By.xpath("//*[@id='commentMaker1']/input[2]")).click();
            

    }

    
}
