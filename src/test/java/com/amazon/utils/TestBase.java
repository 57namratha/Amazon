package com.amazon.utils;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;

//Base class of all the test classes
public class TestBase {

    protected AppiumDriver driver;

    @BeforeTest(alwaysRun=true)
    public void setup()
    {
        InitiateDriver initiateDriver = new InitiateDriver();
        driver = initiateDriver.getAppiumDriver();
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        Base.driver=driver;
    }

    @AfterTest(alwaysRun = true)
    public void teardown()
    {
        driver.closeApp();
        driver.quit();

    }

}
