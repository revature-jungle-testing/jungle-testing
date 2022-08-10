package com.E2E.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class postCommentPom {

    private WebDriver driver;

    public postCommentPom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // find by web element for input box

        // method to enter a comment
            // send keys

        // method to enter a comment that is too long
            // send keys

    // find by web element for comment button

        // method to click on create comment button
            // click()
    
}
