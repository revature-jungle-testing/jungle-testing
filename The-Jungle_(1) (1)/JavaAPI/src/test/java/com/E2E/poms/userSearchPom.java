package com.E2E.poms;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class userSearchPom {
    
    private WebDriver driver;

    public userSearchPom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Call to web element ID's
    @FindBy(id = "search-inputbar")
    public WebElement searchInput;

    public void searchInput(String username){
        this.searchInput.sendKeys(username);
    }

    @FindBy(id = "searchButton")
    public WebElement searchButton;

    public void searchButton(){
        this.searchButton.click();
    }


}
