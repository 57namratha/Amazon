package com.amazon.loginTest;

import com.amazon.Pages;
import com.amazon.utils.PropertyReader;
import com.amazon.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;


public class LoginTest extends TestBase {

    private HashMap<String,String> getProperties  = PropertyReader.getPropValues("credential.properties");

    @Test
    public void loginIsSuccessful() {
        String email = getProperties.get("mobileNumber");
        String password = getProperties.get("password");
        Assert.assertTrue(Pages.LoginPage().login(email, password), "Failed to Login");
    }
}
