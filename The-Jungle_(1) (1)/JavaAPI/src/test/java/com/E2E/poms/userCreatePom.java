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

    public void signupFirstname(String fname){
        this.signupFirstname.sendKeys(fname);
    }

    @FindBy(id = "signup-lastname")
    public WebElement signupLastname;

    public void signupLastname(String lname){
        this.signupLastname.sendKeys(lname);
    }

    @FindBy(id = "signup-email")
    public WebElement signupEmail;

    public void signupEmail(String email){
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

    @FindBy(className = "leftSection")
    public WebElement leftSection;

    public void signupbutton(){
        this.signupUsername.click();
        this.leftSection.click();
        this.signupButton.click();
        
    }
    public void signupbutton2(){
        this.signupUsername.click();
        this.leftSection.click();
        this.signupUsername.click();
        
    }


    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[9]/p")
    public WebElement invalidMessage;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[6]/div/p")
    public WebElement invalidMessage2;

}
