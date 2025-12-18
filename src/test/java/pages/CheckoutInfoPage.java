package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutInfoPage {

    WebDriver driver;

    private By firstName = By.cssSelector("input[data-test='firstName']");
    private By lastName  = By.cssSelector("input[data-test='lastName']");
    private By zip       = By.cssSelector("input[data-test='postalCode']");
    private By continueBtn = By.cssSelector("input[data-test='continue']");

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInformation(String fn, String ln, String zp) {
        driver.findElement(firstName).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(zip).sendKeys(zp);
        driver.findElement(continueBtn).click();
    }
}
