package PageObjects.pim.employee;

import Commons.BasePages;
import PageObjects.PageGenerator;
import PageObjects.pim.employee.employeeTabs.PersonalDetailPO;
import PageUIs.DashboardPU;
import PageUIs.pim.employee.AddNewEmployeePU;
import PageUIs.pim.employee.EmployeeListPU;
import org.openqa.selenium.WebDriver;

public class EmployeeListPO extends BasePages {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }


    public AddNewEmployeePO clickToAddEmployeeButton() {
        waitForElementClickable(driver, EmployeeListPU.ADD_EMPLOYEE_NAV_BUTTON);
        clickToElement(driver, EmployeeListPU.ADD_EMPLOYEE_NAV_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getAddNewEmployee(driver);
    }

    public PersonalDetailPO clickToEditEmployee(String employeeID) {
        waitForElementClickable(driver, EmployeeListPU.DYNAMIC_EDIT_EMPLOYEE, employeeID);
        clickToElement(driver, EmployeeListPU.DYNAMIC_EDIT_EMPLOYEE, employeeID);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailPage(driver);
    }
}
