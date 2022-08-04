package com.E2E.runner;

import org.eclipse.jetty.util.log.Log;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/resources/features", glue="", plugin = {"pretty", "html:src/test/resources/reports/html-reports.html"})
public class TestRunner {

    public static WebDriver driver;

    public static WebDriver wait;

    public static Log login;


    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
        driver = new ChromeDriver();       

    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}