package com.E2E.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userLoginPom {

    private WebDriver driver;

    public userLoginPom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Call to web element ID's
    @FindBy(id = "usernameInput")
    public WebElement usernameInput;

    public void usernameLoginInput(String username){
        this.usernameInput.sendKeys(username);
    }

    @FindBy(className = "rightSection")
    public WebElement rightSection;

    @FindBy(id = "passcodeInput")
    public WebElement passcodeInput;

    public void passcodeLoginInput(String password){
        this.passcodeInput.sendKeys(password);
        this.rightSection.click();
        
    }

    @FindBy(id = "submitLogin")
    public WebElement submitLogin;

    public void submitLoginCorrect(){
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        // wait.until(ExpectedConditions.elementToBeClickable(submitLogin));
        this.submitLogin.click();
        
    }

    public void submitLoginIncorrect(){
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.elementToBeClickable(submitLogin));
        this.submitLogin.click();
        
    }
    

}
