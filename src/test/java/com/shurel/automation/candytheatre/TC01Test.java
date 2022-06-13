package com.shurel.automation.candytheatre;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TC01Test {
    private static int timeout = 5;
    private static String URL = "https://www.candytheatre.com/";
    private static WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\reynolds\\Documents\\course\\java\\automation_candytheatre\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void testOpenURL() throws InterruptedException {
        String actualURL = URL;
        driver.get(actualURL);
        Thread.sleep(timeout);
        String expectedURL = driver.getCurrentUrl();
        assertEquals(actualURL, expectedURL);
    }

    @AfterTest
    public void end(){
        driver.close();

    }
}