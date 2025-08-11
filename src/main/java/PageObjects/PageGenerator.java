package PageObjects;

import PageObjects.pim.employee.*;
import PageObjects.pim.employee.employeeTabs.*;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }
    public static DashboardPO getDashboardPage(WebDriver driver) {
        return new DashboardPO(driver);
    }
    public static AddNewEmployeePO getAddNewEmployee(WebDriver driver) {
        return new AddNewEmployeePO(driver);
    }
    public static ContactDetailsPO getContactDetailPage(WebDriver driver) {
        return new ContactDetailsPO(driver);
    }
    public static EmergencyContactsPO getEmergencyContactsPage(WebDriver driver) {
        return new EmergencyContactsPO(driver);
    }
    public static EmployeeListPO getEmployeeListPage(WebDriver driver) {
        return new EmployeeListPO(driver);
    }
    public static PersonalDetailPO getPersonalDetailPage(WebDriver driver) {
        return new PersonalDetailPO(driver);
    }
    public static DependentsPO getDependentsPage(WebDriver driver) {
        return new DependentsPO(driver);
    }
    public static EmergencyContactsPO getEmergencyPage(WebDriver driver) {
        return new EmergencyContactsPO(driver);
    }
    public static ImmigrationPO getImmigrationPage(WebDriver driver) {
        return new ImmigrationPO(driver);
    }
    public static JobPO getJobPage(WebDriver driver) {
        return new JobPO(driver);
    }
    public static SalaryPO getSalaryPage(WebDriver driver) {
        return new SalaryPO(driver);
    }
    public static ReportToPO getReportToPage(WebDriver driver) {
        return new ReportToPO(driver);
    }

}
