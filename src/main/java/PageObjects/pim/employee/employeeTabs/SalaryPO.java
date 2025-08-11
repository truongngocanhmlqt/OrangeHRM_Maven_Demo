package PageObjects.pim.employee.employeeTabs;

import Commons.BasePages;
import PageUIs.pim.employee.employeeTabs.SalaryPU;
import org.openqa.selenium.WebDriver;

public class SalaryPO extends EmployeeTabsPO {
    private WebDriver driver;

    public SalaryPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void clickToAddButtonAtAssignedSalary() {
        waitForElementClickable(driver, SalaryPU.ADD_BUTTON_IN_SALARY);
        clickToElement(driver,SalaryPU.ADD_BUTTON_IN_SALARY);
    }

    public void clickToSaveButtonAtAddSalaryComponent() {
        waitForElementClickable(driver, SalaryPU.SAVE_BUTTON_AT_SALARY_COMPONENT_CONTAINER);
        clickToElement(driver,SalaryPU.SAVE_BUTTON_AT_SALARY_COMPONENT_CONTAINER);
    }

    public boolean isRequiredTextDisplayedInSalaryComponent() {
        waitForElementVisible(driver, SalaryPU.REQUIRED_TEXT_IN_SALARY_COMPONENT);
        return isElementDisplay(driver,SalaryPU.REQUIRED_TEXT_IN_SALARY_COMPONENT);
    }

    public boolean isRequiredTextDisplayedInCurrency() {
        waitForElementVisible(driver, SalaryPU.REQUIRED_TEXT_IN_CURRENCY);
        return isElementDisplay(driver,SalaryPU.REQUIRED_TEXT_IN_CURRENCY);
    }

    public boolean isRequiredTextDisplayedInAMount() {
        waitForElementVisible(driver, SalaryPU.REQUIRED_TEXT_IN_AMOUNT);
        return isElementDisplay(driver,SalaryPU.REQUIRED_TEXT_IN_AMOUNT);
    }
}
