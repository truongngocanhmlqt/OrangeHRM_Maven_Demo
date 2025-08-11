package com.OrangeHRM.PIM;

import Commons.BaseTests;
import Commons.GlobalConstant;
import PageObjects.DashboardPO;
import PageObjects.LoginPO;
import PageObjects.PageGenerator;
import PageObjects.pim.employee.EmployeeListPO;
import PageObjects.pim.employee.employeeTabs.*;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

public class PIM_02_Employee extends BaseTests {

    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailPO personalDetailPage;
    private ImmigrationPO immigrationPage;
    private ReportToPO reportToPage;
    private JobPO jobPage;
    private SalaryPO salaryPage;
    private String immigrationNumber,immigrationIssueDate,immigrationEligibleStatus;
    private String JobTitle, JobCategory, Location,EmploymentStatus, JoinedDate;





    @Parameters({"browser", "userURL"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {

        immigrationNumber = "223344";
        immigrationIssueDate= "2025-07-01";
        immigrationEligibleStatus= "Yes";
        JobTitle= "Automation Tester";
        JobCategory = "Craft Workers";
        Location ="Ha Noi Branch";
        EmploymentStatus = "Probation";
        JoinedDate = "2025-07-01";

        driver = getBrowserDriver(browserName, url);
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.enterToUsernameTextbox(GlobalConstant.ADMIN_USER_NAME);
        loginPage.enterToPasswordTextbox(GlobalConstant.PASSWORD_ADMIN);
        dashboardPage = loginPage.clickToLoginButton();

    }


    @Test
    public void Employee_07_Immigration(Method method) {
        ExtentManager.startTest(method.getName(), "Employee_07_Immigration");
        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 01: Click to PIM page");
        employeeListPage = dashboardPage.clickToPIMPage();

        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 02: Click to edit employee");
        personalDetailPage = employeeListPage.clickToEditEmployee(GlobalConstant.employeeID);

        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 03: Open to Immigration page");
        immigrationPage = personalDetailPage.openImmigrationPage();

        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 04: Click to ADD button in Immigration page");
        immigrationPage.clickToAddButtonInAddImmigration();

        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 05: Select Passport radio button");
        immigrationPage.selectPassportDocumentRadioButton("Passport");

        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 06: Enter to Immigration number" +immigrationNumber );
        immigrationPage.enterTextboxByText(driver, "Number", immigrationNumber);

        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 07: Enter to Immigration issue date" +immigrationIssueDate );
        immigrationPage.enterTextboxByText(driver, "Issued Date", immigrationIssueDate);

        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 08: Enter to Immigration eligible status" +immigrationEligibleStatus );
        immigrationPage.enterTextboxByText(driver, "Eligible Status", immigrationEligibleStatus );

        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 09: Select issued by with value : Viet Nam " );
        immigrationPage.selectIssuedByDropdown("Viet Nam");

        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 10: Click to SAVE button at Immigration" );
        immigrationPage.clickToSaveButtonAtImmigration();

        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 11: Verify Successfully Saved message displayed" );
        Assert.assertEquals(immigrationPage.getSuccesstext(driver), "Successfully Saved");

        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 12: wait all loading icon invisible" );
        immigrationPage.waitAllLoadingIconInvisible(driver);

        //Verify data row
        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 13: Verify data row is displayed" );
        Assert.assertTrue(immigrationPage.isDynamicDataRowImmigrationDisplay("1","Passport", immigrationNumber,"Viet Nam", immigrationIssueDate));

        //delete row
        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 14: click to delete icon" );
        immigrationPage.clickToDynamicDeleteIcon(driver,"1");

        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 15: click to YES delete button" );
        immigrationPage.clickToYesDeleteButton(driver);

        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 16: Verify Successfully Deleted message is displayed" );
        Assert.assertEquals(immigrationPage.getSuccesstext(driver), "Successfully Deleted");

        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 17: Wait all loading icon invisible" );
        immigrationPage.waitAllLoadingIconInvisible(driver);

        //Verify deleted row
        ExtentManager.getTest().log(Status.INFO, "Employee_07_Immigration - STEP 18: Verify row data is deleted" );
        Assert.assertTrue(immigrationPage.isDataRowImmigrationUndisplayed("1","Passport", immigrationNumber,"Viet Nam", immigrationIssueDate));
    }

    @Test
    public void Employee_08_Job(Method method) {
        ExtentManager.startTest(method.getName(), "Employee_08_Job");
        ExtentManager.getTest().log(Status.INFO, "Employee_08_Job - STEP 01: Open to Job Details page");
        jobPage = immigrationPage.openJobDetailsPage();

        ExtentManager.getTest().log(Status.INFO, "Employee_08_Job - STEP 02: Enter to Joined Date textbox with value" + JoinedDate);
        jobPage.enterTextboxByText(driver, "Joined Date", JoinedDate);

        ExtentManager.getTest().log(Status.INFO, "Employee_08_Job - STEP 03: Select Job Title dropdown with value" + JobTitle);
        jobPage.selectJobTitleDropdown(JobTitle);

        ExtentManager.getTest().log(Status.INFO, "Employee_08_Job - STEP 04: Select Job Category dropdown with value" + JobCategory);
        jobPage.selectJobCategoryDropdown(JobCategory);

        ExtentManager.getTest().log(Status.INFO, "Employee_08_Job - STEP 05: Select Location dropdown with value" + Location);
        jobPage.selectLocationDropdown(Location);

        ExtentManager.getTest().log(Status.INFO, "Employee_08_Job - STEP 06: Select Employment Status dropdown with value" + EmploymentStatus);
        jobPage.selectEmploymentStatusDropdown(EmploymentStatus);

        ExtentManager.getTest().log(Status.INFO, "Employee_08_Job - STEP 07: Click to SAVE button at Job Detail");
        jobPage.clickToSaveButtonAtJobDetail();

        ExtentManager.getTest().log(Status.INFO, "Employee_08_Job - STEP 08: Verify Successfully Updated message display");
        Assert.assertEquals(immigrationPage.getSuccesstext(driver), "Successfully Updated");

        ExtentManager.getTest().log(Status.INFO, "Employee_08_Job - STEP 09: Wait all loading icon invisible");
        jobPage.waitAllLoadingIconInvisible(driver);
        //verify
        ExtentManager.getTest().log(Status.INFO, "Employee_08_Job - STEP 10: Verify Joined Date textbox value is " + JoinedDate);
        Assert.assertEquals(jobPage.getJoinedDateTextboxValue(), JoinedDate);

        ExtentManager.getTest().log(Status.INFO, "Employee_08_Job - STEP 11: Verify Job Title textbox value is " + JobTitle);
        Assert.assertEquals(jobPage.getJobTitleTextboxValue(), JobTitle);

        ExtentManager.getTest().log(Status.INFO, "Employee_08_Job - STEP 12:  Verify Job Category textbox value is " + JobCategory);
        Assert.assertEquals(jobPage.getJobCategoryTextboxValue(), JobCategory);

        ExtentManager.getTest().log(Status.INFO, "Employee_08_Job - STEP 13: Verify Job Employment Status textbox value is " + EmploymentStatus);
        Assert.assertEquals(jobPage.getEmploymentStatusTextboxValue(), EmploymentStatus);

        ExtentManager.getTest().log(Status.INFO, "Employee_08_Job - STEP 14: Verify Location textbox value is " + Location);
        Assert.assertEquals(jobPage.getLocationTextboxValue(), Location);

    }

    @Test
    public void Employee_09_Salary(Method method) {
        ExtentManager.startTest(method.getName(), "Employee_09_Salary");
        ExtentManager.getTest().log(Status.INFO, "Employee_09_Salary - STEP 01: Open to Salary page");
        salaryPage = jobPage.openSalaryPage();

        ExtentManager.getTest().log(Status.INFO, "Employee_09_Salary - STEP 02: Click to ADD button at Assigned Salary");
        salaryPage.clickToAddButtonAtAssignedSalary();

        ExtentManager.getTest().log(Status.INFO, "Employee_09_Salary - STEP 03: Click to ADD button at Add Salary Component");
        salaryPage.clickToSaveButtonAtAddSalaryComponent();

        ExtentManager.getTest().log(Status.INFO, "Employee_09_Salary - STEP 04: Verify RequiredText displayed in Salary Component");
        Assert.assertTrue(salaryPage.isRequiredTextDisplayedInSalaryComponent());

        ExtentManager.getTest().log(Status.INFO, "Employee_09_Salary - STEP 05: Verify RequiredText displayed in Currency");
        Assert.assertTrue(salaryPage.isRequiredTextDisplayedInCurrency());

        ExtentManager.getTest().log(Status.INFO, "Employee_09_Salary - STEP 06: Verify RequiredText displayed in Amount");
        Assert.assertTrue(salaryPage.isRequiredTextDisplayedInAMount());
    }

    @Test
    public void Employee_10_ReportTo(Method method) {
        ExtentManager.startTest(method.getName(), "Employee_10_ReportTo");
        ExtentManager.getTest().log(Status.INFO, "Employee_10_ReportTo - STEP 01: Open to ReportTo page");
        reportToPage = salaryPage.openReportToPage();

        ExtentManager.getTest().log(Status.INFO, "Employee_10_ReportTo - STEP 02: Click to ADD button at Add Supervisor");
        reportToPage.clickToAddButtonAtAddSupervisor();

        ExtentManager.getTest().log(Status.INFO, "Employee_10_ReportTo - STEP 03: Click to SAVE button at Add Supervisor");
        reportToPage.clickToSaveButtonAtAddSupervisor();

        ExtentManager.getTest().log(Status.INFO, "Employee_10_ReportTo - STEP 04: Verify RequiredText displayed in Name");
        Assert.assertTrue(reportToPage.isRequiredTextDisplayedInName());

        ExtentManager.getTest().log(Status.INFO, "Employee_10_ReportTo - STEP 05: Verify RequiredText displayed in Reporting Method");
        Assert.assertTrue(reportToPage.isRequiredTextDisplayedInReportingMethod());

        ExtentManager.getTest().log(Status.INFO, "Employee_10_ReportTo - STEP 06: Click to CANCEL button at Add Supervisor");
        reportToPage.clickToCancelButtonAtAddSuppervisor();
    }




    @AfterClass

    public void afterClass() {
        //driver.quit();
    }




}

