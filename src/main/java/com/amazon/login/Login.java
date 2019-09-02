package com.amazon.login;

import com.amazon.utils.Base;

public class Login extends Base {
    private LoginObjectRepository lp;

    public Login()  {
        lp = new LoginObjectRepository(driver);
    }

    //Click on Sign In button
    public void selectSignIn() {
        try {
            waitUntilElementIsVisible(lp.signInButton);
            lp.signInButton.click();
        } catch (Exception e) {
            System.out.println("Exception occured: "+e.getMessage());
        }
    }

    //Enter the mobile number and continue to login
    public void continueLogin(String mobileNumber) {
        try {
            waitUntilElementIsVisible(lp.emailIdField);
            lp.emailIdField.click();
            lp.emailIdField.sendKeys(mobileNumber);
            waitUntilElementIsVisible(lp.continueButton);
            lp.continueButton.click();
        } catch (Exception e) {
            System.out.println("Exception occured: "+e.getMessage());
        }

    }

    //Enter the password
    public void setPassword(String password) {
        try {
            waitUntilElementIsVisible(lp.passwordField);
            lp.passwordField.click();
            lp.passwordField.sendKeys(password);
        } catch (Exception e) {
            System.out.println("Exception occured: "+e.getMessage());
        }
    }

    //login to amazon app
    public boolean login(String mobileNumber, String password) {
        try {
            selectSignIn();
            continueLogin(mobileNumber);
            setPassword(password);
            waitUntilElementIsVisible(lp.logInButton);
            lp.logInButton.click();
            waitUntilElementIsVisible(lp.homePageLogo);
        } catch (Exception e) {
            System.out.println("Exception occured: "+e.getMessage());
        }
        if(lp.homePageLogo.isDisplayed())
            return true;
        return false;
    }
    
}
