package com.amazon.purchaseItem;

import com.amazon.utils.ObjectRepository;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/*
Object repository for UI elements involved in purchasing an item process
 */

public class PurchaseItemObjectRepository extends ObjectRepository {
    public PurchaseItemObjectRepository(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.amazon.mShop.android.shopping:id/rs_search_src_text\"]")
    protected static MobileElement searchField;

    @AndroidFindBy(xpath = "\n" +
            "(//*[@class='android.widget.ScrollView']//*[@class='android.view.ViewGroup']//*[@class='android.widget.ImageView' and contains(@content-desc,',image')])[4]" )
    protected static MobileElement searchResults;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Filter\"]")
    protected static MobileElement searchResultPage;

    @AndroidFindBy(id = "//android.widget.Button[@resource-id=\"add-to-cart-button\"]")
    protected static MobileElement addToCartButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Cart\"]")
    protected static MobileElement cartIcon;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Proceed to Buy\"]")
    protected static MobileElement proceedToBuyButton;

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Select a delivery address\"]")
    protected static MobileElement deliveryAddressPage;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Deliver to this address\"]")
    protected static MobileElement deliverToThisAddressButton;

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Choose your delivery options\"]")
    protected static MobileElement chooseYourDeliveryOptionPage;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Continue\"]")
    protected static MobileElement chooseYourDeliveryOptionContinueButton;

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Select a payment method\"]")
    protected static MobileElement startPaymentMethodPage;

}


