package com.shurel.automation.candytheatre;

import static org.junit.Assert.assertEquals;

import org.testng.Reporter;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.*;

public class UC01Test {

    private static WebDriver driver;
    private static UC01 uc01;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\reynolds\\Documents\\course\\java\\automation_candytheatre\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        uc01 = new UC01();
    }

    @Test
    public void testOpenURL() throws Exception {
        Reporter.log("UC01 - Visitor loads the site and click access all links on the home page");
        Reporter.log("Launching FireFox Driver");
        boolean actual = uc01.open(driver, UC.URL);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void testLinks() throws Exception {
        Map map = uc01.getFaultyLinks(driver, UC.URL);
        int actual = map.size();
        int expected = 0;

        String msg = "";
        String[] l = null;
        if (actual > 0) {
            l = map.toString().split(",");
            for (int i = 0; i < l.length; i++) {
                msg += l[i].substring(0, l[i].lastIndexOf('=')) + " --> " + l[i].substring(l[i].lastIndexOf('=') + 1) + "\n";
            }
            Reporter.log(msg);
        }


        assertEquals(expected, actual);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        Reporter.log("Driver closed after testing");

    }
}