package com.E2E.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class postCreatePom {

    private WebDriver driver;

    public postCreatePom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    // find by web element for create post button

        // method to click on create post button
            // click()


    // find by web element for enter input post body

        // method to enter a post
            // send keys

        // method to enter a post that is too long
            // send keys

    // find by web element for post button

        // method to click on post button
            // click()
    
}
