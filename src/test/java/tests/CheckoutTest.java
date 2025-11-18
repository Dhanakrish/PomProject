package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutTest() {

        LoginPage login = new LoginPage(driver);
        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutInfoPage info = new CheckoutInfoPage(driver);
        CheckoutOverviewPage overview = new CheckoutOverviewPage(driver);
        OrderCompletePage complete = new OrderCompletePage(driver);

        // Login
        login.login("standard_user", "secret_sauce");

        // Add Items
        products.addItemsToCart();
        products.clickCart();

        // Checkout Process
        cart.clickCheckout();
        info.fillInformation("John", "Doe", "560001");
        overview.clickFinish();

        // Verify completion
        String message = complete.getSuccessMessage();
        Assert.assertEquals(message, "Thank you for your order!");
    }
}
