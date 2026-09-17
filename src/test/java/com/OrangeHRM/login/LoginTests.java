package com.OrangeHRM.login;

import Commons.BaseTests;
import Commons.GlobalConstant;
import PageObjects.DashboardPO;
import PageObjects.LoginPO;
import PageObjects.PageGenerator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {
    private LoginPO loginPage;
    private DashboardPO dashboardPage;

    @Parameters({"browser", "userURL"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGenerator.getLoginPage(driver);
    }

    @Test(description = "Login with valid admin user")
    public void loginWithValidCredentials() {
        loginPage.enterToUsernameTextbox(GlobalConstant.ADMIN_USER_NAME);
        loginPage.enterToPasswordTextbox(GlobalConstant.PASSWORD_ADMIN);
        dashboardPage = loginPage.clickToLoginButton();

        Assert.assertNotNull(dashboardPage, "Dashboard should be displayed after login");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

