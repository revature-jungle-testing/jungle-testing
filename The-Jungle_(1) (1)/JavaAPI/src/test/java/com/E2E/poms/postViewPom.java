package com.E2E.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class postViewPom {

    private WebDriver driver;

    public postViewPom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
        
    @FindBy(className = "overlap-group1-1")
    public By postFeed;
}