package base.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutInfoPage {
    WebDriver driver;

    private By firstName=By.cssSelector("input[data-test='firstName']");
    private By lastName=By.cssSelector("input[data-test='lastName']");
    private By postalCode=By.cssSelector("input[data-test='postalCode']");
    private By continueBtn = By.cssSelector("input[data-test='continue']");

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
    }


    public void fillInformation(String fname, String lname, String zip){
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(continueBtn).click();
    }

}
