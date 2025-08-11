package PageObjects.pim.employee.employeeTabs;

import PageUIs.pim.employee.employeeTabs.ReportToPU;
import org.openqa.selenium.WebDriver;

public class ReportToPO extends EmployeeTabsPO {
    private WebDriver driver;

    public ReportToPO(WebDriver driver)  {
        super(driver);
        this.driver = driver;
    }


    public void clickToAddButtonAtAddSupervisor() {
        waitForElementClickable(driver, ReportToPU.ADD_BUTTON_IN_ASSIGNED_SUPERVISORS);
        clickToElement(driver, ReportToPU.ADD_BUTTON_IN_ASSIGNED_SUPERVISORS);
    }

    public void clickToSaveButtonAtAddSupervisor() {
        waitForElementClickable(driver, ReportToPU.SAVE_BUTTON_AT_ASSIGNED_SUPERVISORS_CONTAINER);
        clickToElement(driver, ReportToPU.SAVE_BUTTON_AT_ASSIGNED_SUPERVISORS_CONTAINER);
    }

    public boolean isRequiredTextDisplayedInName() {
        waitForElementVisible(driver, ReportToPU.REQUIRED_TEXT_IN_NAME);
        return isElementDisplay(driver, ReportToPU.REQUIRED_TEXT_IN_NAME);
    }

    public boolean isRequiredTextDisplayedInReportingMethod() {
        waitForElementVisible(driver, ReportToPU.REQUIRED_TEXT_IN_REPORTING_METHOD);
        return isElementDisplay(driver, ReportToPU.REQUIRED_TEXT_IN_REPORTING_METHOD);
    }

    public void clickToCancelButtonAtAddSuppervisor() {
        waitForElementClickable(driver, ReportToPU.CANCEL_BUTTON_AT_ASSIGNED_SUPERVISORS_CONTAINER);
        clickToElement(driver, ReportToPU.CANCEL_BUTTON_AT_ASSIGNED_SUPERVISORS_CONTAINER);
    }
}
