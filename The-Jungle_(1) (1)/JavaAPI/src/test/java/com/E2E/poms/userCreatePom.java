package com.E2E.poms;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class userCreatePom {

    private WebDriver driver;

    public userCreatePom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    //Call to web element ID's
    @FindBy(id = "signup-firstname")
    public WebElement signupFirstname;

    public void singupFirstname(String fname){
        this.signupFirstname.sendKeys(fname);
    }

    @FindBy(id = "signup-lastname")
    public WebElement signupLastname;

    public void singupLastname(String lname){
        this.signupLastname.sendKeys(lname);
    }

    @FindBy(id = "signup-email")
    public WebElement signupEmail;

    public void singupEmail(String email){
        this.signupEmail.sendKeys(email);
    }

    @FindBy(id = "signup-username")
    public WebElement signupUsername;

    public void signupUsername(String username){
        this.signupUsername.sendKeys(username);
    }

    @FindBy(id = "signup-password")
    public WebElement signupPassword;

    public void signupPassword(String password){
        this.signupPassword.sendKeys(password);
    }

    @FindBy(id = "signup-bdate")
    public WebElement signupBdate;

    public void signupBdate(String date){
        this.signupBdate.sendKeys(date);
    }

    @FindBy(id = "signup-submit")
    public WebElement signupButton;

    public void signupbutton(){
        WebDriverWait waitSubmit = new WebDriverWait(driver, null);
        waitSubmit.until(ExpectedConditions.elementToBeClickable(signupButton));
        this.signupButton.click();
    }

}
