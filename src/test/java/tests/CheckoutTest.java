package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutTest {

    WebDriver driver;
    WebDriverWait wait;

    private By firstName = By.cssSelector("input[data-test='firstName']");
    private By lastName  = By.cssSelector("input[data-test='lastName']");
    private By zip       = By.cssSelector("input[data-test='postalCode']");
    private By continueBtn = By.cssSelector("input[data-test='continue']");

    public CheckoutTest(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillInformation(String fn, String ln, String zp) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));

        driver.findElement(firstName).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(zip).sendKeys(zp);

        driver.findElement(continueBtn).click();
    }
}
