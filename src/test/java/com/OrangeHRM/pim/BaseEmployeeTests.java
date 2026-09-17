package com.OrangeHRM.pim;

import Commons.BaseTests;
import Commons.GlobalConstant;
import PageObjects.DashboardPO;
import PageObjects.LoginPO;
import PageObjects.PageGenerator;
import PageObjects.pim.employee.AddNewEmployeePO;
import PageObjects.pim.employee.EmployeeListPO;
import PageObjects.pim.employee.employeeTabs.PersonalDetailPO;
import Utilities.ExcelConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseEmployeeTests extends BaseTests {
    protected LoginPO loginPage;
    protected DashboardPO dashboardPage;

    protected String employeeId;
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected String editFirstName;
    protected String editMiddleName;
    protected String editLastName;
    protected String driverLicense;
    protected String licenseExpiryDate;
    protected String dateOfBirth;
    protected String street1;
    protected String street2;
    protected String city;
    protected String province;
    protected String zipCode;
    protected String country;
    protected String home;
    protected String mobile;
    protected String work;
    protected String workEmail;
    protected String otherEmail;
    protected String emergencyName;
    protected String emergencyRelationship;
    protected String emergencyHomeTelephone;
    protected String dependentsName;
    protected String dependentDateOfBirth;
    protected String dependentsRelationship;
    protected final String avatarImageName = "HoChiMinh.jpg";

    protected final String immigrationNumber = "223344";
    protected final String immigrationIssueDate = "2025-07-01";
    protected final String immigrationEligibleStatus = "Yes";
    protected final String jobTitle = "Automation Tester";
    protected final String jobCategory = "Craft Workers";
    protected final String location = "Ha Noi Branch";
    protected final String employmentStatus = "Probation";
    protected final String joinedDate = "2025-07-01";

    @Parameters({"browser", "userURL"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.enterToUsernameTextbox(GlobalConstant.ADMIN_USER_NAME);
        loginPage.enterToPasswordTextbox(GlobalConstant.PASSWORD_ADMIN);
        dashboardPage = loginPage.clickToLoginButton();
        loadEmployeeTestData();
    }

    protected PersonalDetailPO createEmployeeAndOpenPersonalDetails() {
        EmployeeListPO employeeListPage = dashboardPage.clickToPIMPage();
        AddNewEmployeePO addNewEmployeePage = employeeListPage.clickToAddEmployeeButton();
        addNewEmployeePage.enterToFirstNameTextbox(driver, firstName);
        addNewEmployeePage.enterToMidleNameTextbox(driver, middleName);
        addNewEmployeePage.enterToLastNameTextbox(driver, lastName);
        employeeId = addNewEmployeePage.getEmployeeID();
        GlobalConstant.TestDataHolder.employeeID = employeeId;
        return addNewEmployeePage.clickToSaveButtonAtEmployeeContainer();
    }

    private void loadEmployeeTestData() {
        ExcelConfig excelConfig = ExcelConfig.getExcelData();
        excelConfig.switchToSheet("Employee_01");
        firstName = excelConfig.getCellData("firstName", 1);
        middleName = excelConfig.getCellData("middleName", 1);
        lastName = excelConfig.getCellData("lastName", 1);
        editFirstName = excelConfig.getCellData("editFirstName", 1);
        editMiddleName = excelConfig.getCellData("editMiddleName", 1);
        editLastName = excelConfig.getCellData("editLastName", 1);
        driverLicense = excelConfig.getCellData("driverLicense", 1);
        licenseExpiryDate = excelConfig.getCellData("licenseExpiryDate", 1);
        dateOfBirth = excelConfig.getCellData("dateOfBirth", 1);
        street1 = excelConfig.getCellData("street1", 1);
        street2 = excelConfig.getCellData("street2", 1);
        city = excelConfig.getCellData("city", 1);
        province = excelConfig.getCellData("province", 1);
        country = excelConfig.getCellData("country", 1);
        zipCode = excelConfig.getCellData("zipCode", 1);
        home = excelConfig.getCellData("home", 1);
        mobile = excelConfig.getCellData("mobile", 1);
        work = excelConfig.getCellData("work", 1);
        workEmail = getEmailWorkRandom(excelConfig.getCellData("workEmail", 1));
        otherEmail = getEmailOtherRandom(excelConfig.getCellData("otherEmail", 1));
        emergencyName = excelConfig.getCellData("emergencyName", 1);
        emergencyRelationship = excelConfig.getCellData("emergencyRelationship", 1);
        emergencyHomeTelephone = excelConfig.getCellData("emergencyHomeTelephone", 1);
        dependentsName = excelConfig.getCellData("dependentsName", 1);
        dependentsRelationship = excelConfig.getCellData("dependentsRelationship", 1);
        dependentDateOfBirth = excelConfig.getCellData("dependentDateOfBirth", 1);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
