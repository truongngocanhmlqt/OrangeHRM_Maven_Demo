package Commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Locale;

public final class DriverFactory {
    private DriverFactory() {
    }

    public static WebDriver createDriver(String browserName) {
        String browser = (browserName == null || browserName.trim().isEmpty())
                ? ConfigReader.getProperty("browser")
                : browserName;

        BrowserList browserList = BrowserList.valueOf(browser.toUpperCase(Locale.ROOT));
        switch (browserList) {
            case CHROME:
                return createChromeDriver();
            case FIREFOX:
                return createFirefoxDriver();
            case EDGE:
                return createEdgeDriver();
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        if (isHeadlessEnabled()) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        if (isHeadlessEnabled()) {
            options.addArguments("-headless");
        }
        return new FirefoxDriver(options);
    }

    private static WebDriver createEdgeDriver() {
        EdgeOptions options = new EdgeOptions();
        if (isHeadlessEnabled()) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }
        return new EdgeDriver(options);
    }

    private static boolean isHeadlessEnabled() {
        String headless = System.getProperty("headless", ConfigReader.getProperty("headless", "false"));
        return "true".equalsIgnoreCase(headless);
    }
}
