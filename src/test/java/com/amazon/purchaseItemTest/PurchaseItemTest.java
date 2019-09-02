package com.amazon.purchaseItemTest;

import com.amazon.Pages;
import com.amazon.utils.PropertyReader;
import com.amazon.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class PurchaseItemTest extends TestBase {
    private HashMap<String,String> getProperties  = PropertyReader.getPropValues("purchaseDetails.properties");

    @Test
    public void purchaseTheProduct() {
        String searchKey = getProperties.get("searchItem");
        Assert.assertTrue(Pages.PurchaseItem().goToPayment(searchKey), "Failed to purchase the product");
    }
}
