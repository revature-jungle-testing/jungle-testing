package com.E2E.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userSearchPom {
    
    private WebDriver driver;

    public userSearchPom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Call to web element ID's
    @FindBy(id = "searchInputBox")
    public WebElement searchInput;

    public void searchInput(String username){
        this.searchInput.sendKeys(username);
    }

    @FindBy(id = "searchButton")
    public WebElement searchButton;

    public void searchButton(){
        this.searchButton.click();
    }

    @FindBy(xpath = "/html/body/div/div/div[3]/ul/li[1]/a")
    public WebElement searchDrop;

    @FindBy(xpath = "/html/body/div/div/div[3]/ul/li")
    public WebElement noDrop;


}
