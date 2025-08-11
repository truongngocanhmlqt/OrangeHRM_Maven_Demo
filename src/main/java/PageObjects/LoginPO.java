package PageObjects;

import Commons.BasePages;
import PageUIs.LoginPU;
import org.openqa.selenium.WebDriver;

public class LoginPO extends BasePages {
    private WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }


    public void enterToUsernameTextbox(String username) {
        waitForElementVisible(driver, LoginPU.USERNAME_TEXTBOX);
        sendKeyToElement(driver, LoginPU.USERNAME_TEXTBOX, username);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPU.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPU.PASSWORD_TEXTBOX, password);
    }

    public DashboardPO clickToLoginButton() {
        waitForElementClickable(driver, LoginPU.LOGIN_BUTTON);
        clickToElement(driver, LoginPU.LOGIN_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getDashboardPage(driver);
    }
}
