package com.E2E.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userGlobalChat {
       
    private WebDriver driver;

    public userGlobalChat(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Call to web element ID's
    @FindBy(className = "linkChat")
    public WebElement chatButton;

    public void chatButton(){
        this.chatButton.click();;
    }

    @FindBy(className = "jungle3-1")
    public WebElement homeButton;

    public void homeButton(){
        this.homeButton.click();
    } 
}
