package base;

import factory.DriverFactory;
import utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ConfigReader.initProperties();

        String browser = ConfigReader.get("browser");
        String url = ConfigReader.get("url");

        driver = DriverFactory.initDriver(browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    // ⭐ Screenshot method
    public String takeScreenshot(String methodName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") +
                "/reports/screenshots/" + methodName + ".png";

        try {
            FileUtils.copyFile(src, new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }

    // ⭐ Getter for driver (Fix for access error)
    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
