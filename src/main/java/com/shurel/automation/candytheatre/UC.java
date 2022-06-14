package com.shurel.automation.candytheatre;

import org.openqa.selenium.*;
import java.util.*;
import java.net.*;

public interface UC {
    String URL = "https://www.candytheatre.com/";
    default boolean open(WebDriver driver, String URL) throws Exception {
        driver.get(URL);
        Thread.sleep(5);

        return URL.equals(driver.getCurrentUrl());
    }

    default List<WebElement> getAllLinks(WebDriver driver, String URL) throws Exception {
        boolean b = open(driver, URL);


        return driver.findElements(By.tagName("a"));
    }

    default HashMap<String,String> getFaultyLinks(WebDriver driver, String URL) throws Exception {
List<WebElement> links=getAllLinks(driver,URL);
        HashMap<String,String> map=new HashMap<String,String>();

        HttpURLConnection huc = null;
        int respCode = 200;
String url=null;

        Iterator<WebElement> it = links.iterator();

        while(it.hasNext()){

            url = it.next().getAttribute("href");



            if(url == null || url.isEmpty()){
                map.put(url,"URL is either not configured for anchor tag or it is empty");
                continue;
            }


            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();

                respCode = huc.getResponseCode();

                if(respCode >= 400){
                    map.put(url,respCode+"");
                }


            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return map;





    }

}
