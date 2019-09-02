package com.amazon.purchaseItem;

import com.amazon.utils.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;


public class PurchaseItem extends Base {
    PurchaseItemObjectRepository pI;

    public PurchaseItem() {
        pI = new PurchaseItemObjectRepository(driver);
    }

    //Search fo the 65 inch tv
    public void search(String searchKey) {
        try {
            waitUntilElementIsVisible(pI.searchField);
            pI.searchField.click();
            waitUntilElementIsVisible(pI.searchField);
            pI.searchField.sendKeys(searchKey);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.ENTER);
            waitUntilElementIsVisible(pI.searchResultPage);
            pI.searchResults.click();
        } catch (Exception e) {
             System.out.println("Exception occured"+ e.getMessage());
        }
    }

    //Add the searched content to cart
    public void addTheSearchedItemToCart()  {
        try {
            //scroll the page to click on add to cart button
            boolean notPresent = true;
            while(notPresent){
                scrollUp(2000);
                if(pI.addToCartButton.isDisplayed())
                    notPresent=false;
            }

            pI.addToCartButton.click();
        } catch (Exception e) {
            System.out.println("Exception occured"+ e.getMessage());
        }
    }

    //Go to cart screen
    public void verifyProductIsAddedToCart() {
        try {
            if(pI.cartIcon.isDisplayed())
                pI.cartIcon.click();
        } catch (Exception e) {
            System.out.println("Exception occured"+ e.getMessage());
        }
    }

    //Choose the delivery option
    public void continueToPayment() {
        try {
            waitUntilElementIsVisible(pI.proceedToBuyButton);
            pI.proceedToBuyButton.click();
            waitUntilElementIsVisible(pI.deliveryAddressPage);
            pI.deliverToThisAddressButton.click();
            waitUntilElementIsVisible(pI.chooseYourDeliveryOptionPage);
            pI.chooseYourDeliveryOptionContinueButton.click();
        } catch (Exception e) {
            System.out.println("Exception occured"+ e.getMessage());
        }
    }

    //Navigate to payment page
    public boolean goToPayment(String product)  {
        try {
            search(product);
            addTheSearchedItemToCart();
            verifyProductIsAddedToCart();
            continueToPayment();
            waitUntilElementIsVisible(pI.startPaymentMethodPage);
        } catch (Exception e) {
            System.out.println("Exception occured"+ e.getMessage());
        }
        if(pI.startPaymentMethodPage.isDisplayed())
            return true;
        return false;
    }
}
