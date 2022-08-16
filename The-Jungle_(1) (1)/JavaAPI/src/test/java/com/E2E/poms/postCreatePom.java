package com.E2E.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class postCreatePom {

    private WebDriver driver;

    public postCreatePom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(id = "usernameInput")
    public WebElement usernameInput;

    @FindBy(className = "rightSection")
    public WebElement rightSection;

    @FindBy(id = "passcodeInput")
    public WebElement passcodeInput;

    @FindBy(id = "submitLogin")
    public WebElement submitLogin;

        // method to login
        public void login (String username, String password){
            this.usernameInput.sendKeys(username);
            this.passcodeInput.sendKeys(password);
            this.rightSection.click();
            this.submitLogin.click();
        }

    @FindBy(id = "updateProfileEditProfileBtn")
    public WebElement createPostButton;

        public void clickCreatePost(){
            this.createPostButton.click();
        }

    @FindBy(id = "postText")
    public WebElement postText;

        public void goodPost(String goodPostText){
            this.postText.sendKeys(goodPostText);
        }

        public void badPost(String badPostText){
            this.postText.sendKeys(badPostText);
        }

    @FindBy(xpath =  "//*[@id='createPostForm']/button")
    public WebElement confirmPost;

        public void confirmPost(){
            this.confirmPost.click();
        }

    @FindBy(className = "overlap-group-1")
    public WebElement newlyCreatedPost;

    
}