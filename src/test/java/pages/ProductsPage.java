package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    private By backpack = By.cssSelector("button[data-test='add-to-cart-sauce-labs-backpack']");
    private By bikeLight = By.cssSelector("button[data-test='add-to-cart-sauce-labs-bike-light']");
    private By cartIcon = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addItemsToCart() {
        driver.findElement(backpack).click();
        driver.findElement(bikeLight).click();
    }

    public void clickCart() {
        driver.findElement(cartIcon).click();
    }
}
