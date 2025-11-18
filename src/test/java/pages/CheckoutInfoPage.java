package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage {

    WebDriver driver;

    private By firstName = By.cssSelector("input[data-test='firstName']");
    private By lastName = By.cssSelector("input[data-test='lastName']");
    private By postalCode = By.cssSelector("input[data-test='postalCode']");
    private By continueBtn = By.cssSelector("input[data-test='continue']");

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInformation(String fName, String lName, String zip) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(continueBtn).click();
    }
}
