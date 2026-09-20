package com.OrangeHRM.pim;

import PageObjects.pim.employee.employeeTabs.ImmigrationPO;
import PageObjects.pim.employee.employeeTabs.JobPO;
import PageObjects.pim.employee.employeeTabs.PersonalDetailPO;
import PageObjects.pim.employee.employeeTabs.ReportToPO;
import PageObjects.pim.employee.employeeTabs.SalaryPO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Orange HRM Demo")
@Feature("Employee Management")
public class PIM_03_EmployeeEmploymentTests extends BaseEmployeeTests {

    @Story("Immigration")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Add and delete immigration record")
    public void Employee_07_Immigration() {
        PersonalDetailPO personalDetailPage = createEmployeeAndOpenPersonalDetails();
        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Saved");

        ImmigrationPO immigrationPage = personalDetailPage.openImmigrationPage();
        immigrationPage.clickToAddButtonInAddImmigration();
        immigrationPage.selectPassportDocumentRadioButton("Passport");
        immigrationPage.enterTextboxByText(driver, "Number", immigrationNumber);
        immigrationPage.enterTextboxByText(driver, "Issued Date", immigrationIssueDate);
        immigrationPage.enterTextboxByText(driver, "Eligible Status", immigrationEligibleStatus);
        immigrationPage.selectIssuedByDropdown("Viet Nam");
        immigrationPage.clickToSaveButtonAtImmigration();

        Assert.assertEquals(immigrationPage.getSuccesstext(driver), "Successfully Saved");
        immigrationPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(immigrationPage.isDynamicDataRowImmigrationDisplay("1", "Passport", immigrationNumber, "Viet Nam", immigrationIssueDate));

        immigrationPage.clickToDynamicDeleteIcon(driver, "1");
        immigrationPage.clickToYesDeleteButton(driver);
        Assert.assertEquals(immigrationPage.getSuccesstext(driver), "Successfully Deleted");
        immigrationPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(immigrationPage.isDataRowImmigrationUndisplayed("1", "Passport", immigrationNumber, "Viet Nam", immigrationIssueDate));
    }

    @Story("Job")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Update employee job information")
    public void Employee_08_Job() {
        PersonalDetailPO personalDetailPage = createEmployeeAndOpenPersonalDetails();
        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Saved");

        JobPO jobPage = personalDetailPage.openJobDetailsPage();
        jobPage.enterTextboxByText(driver, "Joined Date", joinedDate);
        jobPage.selectJobTitleDropdown(jobTitle);
        jobPage.selectJobCategoryDropdown(jobCategory);
        jobPage.selectLocationDropdown(location);
        jobPage.selectEmploymentStatusDropdown(employmentStatus);
        jobPage.clickToSaveButtonAtJobDetail();

        Assert.assertEquals(jobPage.getSuccesstext(driver), "Successfully Updated");
        jobPage.waitAllLoadingIconInvisible(driver);
        Assert.assertEquals(jobPage.getJoinedDateTextboxValue(), joinedDate);
        Assert.assertEquals(jobPage.getJobTitleTextboxValue(), jobTitle);
        Assert.assertEquals(jobPage.getJobCategoryTextboxValue(), jobCategory);
        Assert.assertEquals(jobPage.getEmploymentStatusTextboxValue(), employmentStatus);
        Assert.assertEquals(jobPage.getLocationTextboxValue(), location);
    }

    @Story("Salary")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "Validate required fields in salary component")
    public void Employee_09_Salary() {
        PersonalDetailPO personalDetailPage = createEmployeeAndOpenPersonalDetails();
        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Saved");

        SalaryPO salaryPage = personalDetailPage.openSalaryPage();
        salaryPage.clickToAddButtonAtAssignedSalary();
        salaryPage.clickToSaveButtonAtAddSalaryComponent();

        Assert.assertTrue(salaryPage.isRequiredTextDisplayedInSalaryComponent());
        Assert.assertTrue(salaryPage.isRequiredTextDisplayedInCurrency());
        Assert.assertTrue(salaryPage.isRequiredTextDisplayedInAMount());
    }

    @Story("Report To")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "Validate required fields in report-to supervisor form")
    public void Employee_10_ReportTo() {
        PersonalDetailPO personalDetailPage = createEmployeeAndOpenPersonalDetails();
        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Saved");

        ReportToPO reportToPage = personalDetailPage.openReportToPage();
        reportToPage.clickToAddButtonAtAddSupervisor();
        reportToPage.clickToSaveButtonAtAddSupervisor();

        Assert.assertTrue(reportToPage.isRequiredTextDisplayedInName());
        Assert.assertTrue(reportToPage.isRequiredTextDisplayedInReportingMethod());
        reportToPage.clickToCancelButtonAtAddSuppervisor();
    }
}
