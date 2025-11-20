package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver initDriver(String browser) {

        boolean isCI = System.getenv("GITHUB_ACTIONS") != null;  // Detect GitHub Actions

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            if (isCI) {
                // Headless mode for GitHub Actions
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
            }

            tlDriver.set(new ChromeDriver(options));

        } else if (browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions ff = new FirefoxOptions();

            if (isCI) {
                ff.addArguments("--headless");
                ff.addArguments("--no-sandbox");
                ff.addArguments("--disable-dev-shm-usage");
                ff.addArguments("--disable-gpu");
                ff.addArguments("--window-size=1920,1080");
            }

            tlDriver.set(new FirefoxDriver(ff));

        } else if (browser.equalsIgnoreCase("edge")) {
            tlDriver.set(new EdgeDriver());
        } else {
            throw new RuntimeException("Invalid browser: " + browser);
        }

        return tlDriver.get();
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
