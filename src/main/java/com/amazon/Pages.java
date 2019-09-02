
package com.amazon;

import com.amazon.login.Login;
import com.amazon.purchaseItem.PurchaseItem;
import com.amazon.utils.Base;
/*This class is used to refer the different page/classes*/

public class Pages {
    private static <T extends Base> T getPage(Class<T> pageType)  {
        T page;
        try {
            page = pageType.newInstance();
        } catch (InstantiationException e) { //make sure you use JDK 1.7
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return page;
    }

    public static Login LoginPage(){return getPage(Login.class);}
    public static PurchaseItem PurchaseItem(){return getPage(PurchaseItem.class);}
}
