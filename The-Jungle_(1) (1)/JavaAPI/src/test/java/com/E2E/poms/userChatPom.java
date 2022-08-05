package com.E2E.poms;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class userChatPom {

    private WebDriver driver;

    public userChatPom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Call to web element ID's
    @FindBy(id = "message")
    public WebElement msgInput;

    public void  msgInput(String message){
        this.msgInput.sendKeys(message);
        
    }

    @FindBy(id = "imgInput")
    public WebElement imgInput;

    public void imgInput(String filepath){
        this.imgInput.sendKeys(filepath);
    }

    @FindBy(xpath = "//*[@id='send']")
    public WebElement sendButton;

    public void sendButton(){
        // this.msgInput.sendKeys(Keys.ENTER);
        this.sendButton.click();
    }
    
    @FindBy(xpath = "//*[@id='chat']/div/div")
    public WebElement chatOutput;

}
