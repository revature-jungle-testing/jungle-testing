package com.E2E.poms;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(id = "passcodeInput")
    public WebElement passcodeInput;

    public void passcodeLoginInput(String password){
        this.passcodeInput.sendKeys(password);
    }

    @FindBy(id = "submitLogin")
    public WebElement submitLogin;

    public void submitLogin(){
        WebDriverWait waitLogin = new WebDriverWait(driver, 10);
        waitLogin.until(ExpectedConditions.elementToBeClickable(submitLogin));
        this.submitLogin.click();
    }
    

}
