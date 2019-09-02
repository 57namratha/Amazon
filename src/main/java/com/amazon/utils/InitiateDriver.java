package com.amazon.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class InitiateDriver {
    private AppiumDriver appiumDriver;
    private HashMap<String,String> getProperties;

    public InitiateDriver()
    {
        try
        {
            getProperties = PropertyReader.getPropValues("config.properties");
            appiumDriver = new AndroidDriver(new URL(getProperties.get("AndroidAppURL")), getCapabilities());
            appiumDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public AppiumDriver getAppiumDriver()
    {
        if(appiumDriver==null)
            throw new RuntimeException("Driver has not been instantiated");

        return appiumDriver;
    }

    private DesiredCapabilities getCapabilities()
    {
        DesiredCapabilities capabilities = null;

        try
        {
                capabilities=new DesiredCapabilities();
                capabilities.setCapability("deviceName", getProperties.get("deviceName"));
                capabilities.setCapability("platformName", getProperties.get("platformName"));
                capabilities.setCapability("platformVersion", getProperties.get("platformVersion"));
                capabilities.setCapability("app", getProperties.get("app"));
                capabilities.setCapability("appPackage", getProperties.get("appPackage"));
                capabilities.setCapability("appActivity", getProperties.get("appActivity"));
                capabilities.setCapability("automationName", getProperties.get("automationName"));
                capabilities.setCapability("--session-override",true);
                capabilities.setCapability("noReset",true);
//                capabilities.setCapability("unicodeKeyboard", "true");
//                capabilities.setCapability("resetKeyboard", "true");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return capabilities;
    }
}
