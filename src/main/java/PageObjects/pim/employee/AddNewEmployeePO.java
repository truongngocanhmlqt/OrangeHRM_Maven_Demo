package PageObjects.pim.employee;

import Commons.BasePages;
import PageObjects.PageGenerator;
import PageObjects.pim.employee.employeeTabs.PersonalDetailPO;
import PageUIs.pim.employee.AddNewEmployeePU;
import org.openqa.selenium.WebDriver;

public class AddNewEmployeePO extends BasePages {
    private WebDriver driver;

    public AddNewEmployeePO(WebDriver driver) {
        this.driver = driver;
    }


    public void enterToFirstNameTextbox(WebDriver driver, String firstName) {
        waitForElementVisible(driver, AddNewEmployeePU.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, AddNewEmployeePU.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToMidleNameTextbox(WebDriver driver, String middleName) {
        waitForElementVisible(driver, AddNewEmployeePU.MIDDLE_NAME_TEXTBOX);
        sendKeyToElement(driver, AddNewEmployeePU.MIDDLE_NAME_TEXTBOX, middleName);
    }

    public void enterToLastNameTextbox(WebDriver driver,String lastName) {
        waitForElementVisible(driver, AddNewEmployeePU.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, AddNewEmployeePU.LAST_NAME_TEXTBOX, lastName);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, AddNewEmployeePU.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, AddNewEmployeePU.EMPLOYEE_ID_TEXTBOX,"value");
    }

    public PersonalDetailPO clickToSaveButtonAtEmployeeContainer() {
        waitForElementClickable(driver, AddNewEmployeePU.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        clickToElement(driver, AddNewEmployeePU.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        return PageGenerator.getPersonalDetailPage(driver);
    }
}
