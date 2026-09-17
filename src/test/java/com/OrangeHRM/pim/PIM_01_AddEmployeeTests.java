package com.OrangeHRM.pim;

import PageObjects.pim.employee.employeeTabs.PersonalDetailPO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PIM_01_AddEmployeeTests extends BaseEmployeeTests {

    @Test(description = "Add a new employee successfully")
    public void Employee_01_Add_New() {
        PersonalDetailPO personalDetailPage = createEmployeeAndOpenPersonalDetails();

        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Saved", "Employee should be created successfully");
        Assert.assertEquals(personalDetailPage.getEmployeeID(), employeeId, "Employee ID should match created employee");
    }
}
