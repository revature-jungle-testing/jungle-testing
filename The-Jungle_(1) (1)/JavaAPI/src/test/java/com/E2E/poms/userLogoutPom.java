package com.E2E.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userLogoutPom {
    
    private WebDriver driver;

    public userLogoutPom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Call to web element ID's
    @FindBy(className = "logout-container")
    public WebElement logoutButton;

    public void logoutButton(){
        this.logoutButton.click();
    }

}
