package Commons;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Random;

public class BaseTests {
    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String url) {
        String browser = (browserName == null || browserName.trim().isEmpty())
                ? ConfigReader.getProperty("browser")
                : browserName;
        driver = DriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstant.LONG_TIME));
        driver.get(url);
        return driver;
    }

    protected int generateRandomNumber() {
        return new Random().nextInt(99999);
    }

    protected String getEmailWorkRandom(String prefix) {
        return prefix + generateRandomNumber() + "@work.com";
    }

    protected String getEmailOtherRandom(String prefix) {
        return prefix + generateRandomNumber() + "@gmail.com";
    }

    protected byte[] takeScreenshotBytes() {
        if (driver instanceof TakesScreenshot) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        return new byte[0];
    }
}
