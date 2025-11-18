package base.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;

    //locators
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginbtn = By.id("login-button");

    //constructor
    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    //action
    public LoginPage login(String user, String password) {
        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-btn")).click();
    }
}
