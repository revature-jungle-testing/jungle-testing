package com.E2E.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class postViewPom {

    private WebDriver driver;

    public postViewPom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // method to refresh page
        // location.reload()? window.reload, something like that
        
}
