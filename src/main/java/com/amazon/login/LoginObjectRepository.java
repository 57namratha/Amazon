package com.amazon.login;

import com.amazon.utils.ObjectRepository;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/*
Object repository for UI elements invloved in login flow
 */

public class LoginObjectRepository extends ObjectRepository {
    public LoginObjectRepository(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.amazon.mShop.android.shopping:id/sign_in_button\"]")
    protected static MobileElement signInButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"ap_email_login\"]")
    protected static MobileElement emailIdField;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"continue\"]")
    protected static MobileElement continueButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"ap_password\"]")
    protected static MobileElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"signInSubmit\"]")
    protected static MobileElement logInButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Home\"]")
    protected static MobileElement homePageLogo;
}
