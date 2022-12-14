package com.E2E.runner;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.util.log.Log;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.E2E.poms.postCreatePom;
import com.E2E.poms.postViewPom;
import com.E2E.poms.postCommentPom;
import com.E2E.poms.userChatPom;
import com.E2E.poms.userCreatePom;
import com.E2E.poms.userGlobalChat;
import com.E2E.poms.userLoginPom;
import com.E2E.poms.userLogoutPom;
import com.E2E.poms.userSearchPom;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/resources/features", glue="com/E2E/steps", plugin = {"pretty", "html:src/test/resources/reports/html-reports.html"})
public class TestRunner {

    public static WebDriver driver;

    public static WebDriverWait wait;

    public static Log login;

    public static userLoginPom userLoginPom;
    public static userCreatePom userCreatePom;
    public static userGlobalChat userGlobalChat;
    public static userChatPom userChatPom;
    public static userSearchPom userSearchPom;
    public static userLogoutPom userLogoutPom;

    public static postCommentPom postCommentPom;
    public static postCreatePom postCreatePom;
    public static postViewPom postViewPom;



    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/com/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait = new WebDriverWait.WebDriverWait(driver);
        
        userLoginPom = new userLoginPom(driver);
        userLogoutPom = new userLogoutPom(driver);
        userCreatePom = new userCreatePom(driver);
        userGlobalChat = new userGlobalChat(driver);
        userChatPom = new userChatPom(driver);
        userSearchPom = new userSearchPom(driver);

        postCommentPom = new postCommentPom(driver);
        postCreatePom = new postCreatePom(driver);
        postViewPom = new postViewPom(driver);

    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}