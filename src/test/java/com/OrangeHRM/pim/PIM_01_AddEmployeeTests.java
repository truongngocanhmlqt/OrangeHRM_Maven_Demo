package com.OrangeHRM.pim;

import PageObjects.pim.employee.employeeTabs.PersonalDetailPO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Orange HRM Demo")
@Feature("Employee Management")
public class PIM_01_AddEmployeeTests extends BaseEmployeeTests {

    @Story("Add Employee")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Add a new employee successfully")
    public void Employee_01_Add_New() {
        PersonalDetailPO personalDetailPage = createEmployeeAndOpenPersonalDetails();

        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Saved", "Employee should be created successfully");
        Assert.assertEquals(personalDetailPage.getEmployeeID(), employeeId, "Employee ID should match created employee");
    }
}
