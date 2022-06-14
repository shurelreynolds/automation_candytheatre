package com.shurel.automation.candytheatre;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
public class UC02Test {

    private static WebDriver driver;
    private static UC02 uc02;

    @BeforeTest
    public void setUp() throws Exception{
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\reynolds\\Documents\\course\\java\\automation_candytheatre\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        uc02=new UC02(driver,UC.URL);
    }

    @Test
    public void testSearchAvailableKeyword() throws Exception {
        Reporter.log("UC02 - Visitor searches the site for available keyword");
        Reporter.log("Launching FireFox Driver");
        boolean actual = uc02.search("q","sour")>0;
        boolean expected=true;
        assertEquals(expected,actual);

    }

    @Test
    public void testSearchUnavailableKeyword() throws Exception {
        Reporter.log("UC02 - Visitor searches the site for unavailable keyword");
        Reporter.log("Launching FireFox Driver");
        boolean actual = uc02.search("q","xred")==0;
        boolean expected=true;
        assertEquals(expected,actual);

    }


    @AfterTest
    public void tearDown(){
        driver.close();
        Reporter.log("Driver closed after testing");

    }
}