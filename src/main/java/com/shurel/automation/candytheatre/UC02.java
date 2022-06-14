package com.shurel.automation.candytheatre;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;


/**
 * UC02 - Visitor searches the site for available and unavailable keyword
 */


public class UC02 implements UC {
    private WebDriver driver;
    private WebDriverWait wait;

    public UC02(WebDriver driver, String URL) throws Exception {
        this.driver = driver;
        open(driver, URL);
        wait = new WebDriverWait(driver, 20);
    }

    //elementName if the name of the searchfield
    public int search(String elementName, String query) {

        WebElement element = driver.findElement(By.name(elementName));
        element.clear();
        element.sendKeys(query);
        element.sendKeys(Keys.RETURN);
        try {

            By waitFor = By.name("HI");
            WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(waitFor));

            Thread.sleep(5);

        } catch (Exception e) {

        }
        String str = driver.getTitle();
        try {
            return Integer.parseInt(str.split(" ")[1]);
        } catch (Exception e) {
            return 0;
        }

    }

}
