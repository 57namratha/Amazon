package com.amazon.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
Base class for
 */

public class Base {
    public static long wait=60;
    public static AppiumDriver driver;

    public static void waitUntilElementIsVisible(WebElement element){
        WebDriverWait wwait = new WebDriverWait(driver, wait);
        wwait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void scrollUp(int stepSize){
        Dimension size = driver.manage().window().getSize();
        System.out.println(size);
        int starty = (int) (size.height*0.80);
        int endy = (int) (size.height*0.20);
        int startx = size.width/2;

        driver.swipe(startx, starty, startx, endy, stepSize);
    }
}
