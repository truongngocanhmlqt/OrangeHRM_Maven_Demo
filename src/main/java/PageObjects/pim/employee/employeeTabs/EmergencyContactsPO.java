package PageObjects.pim.employee.employeeTabs;

import PageUIs.pim.employee.employeeTabs.EmergencyContactsPU;
import org.openqa.selenium.WebDriver;

public class EmergencyContactsPO extends EmployeeTabsPO {
    private WebDriver driver;

    public EmergencyContactsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void clickToSaveButtonAtEmergencyContact() {
        waitForElementClickable(driver, EmergencyContactsPU.SAVE_BUTTON_AT_EMERGENCY_CONTACT_CONTAINER);
        clickToElement(driver, EmergencyContactsPU.SAVE_BUTTON_AT_EMERGENCY_CONTACT_CONTAINER);

    }
    public void clickToAddButtonInEmergencyContacts() {
        waitForElementClickable(driver, EmergencyContactsPU.ADD_BUTTON_IN_EMERGENCY_CONTACTS);
        clickToElement(driver, EmergencyContactsPU.ADD_BUTTON_IN_EMERGENCY_CONTACTS);
    }

    public boolean isDynamicDataRowEmergencyContactDisplay(String index, String name, String relationship, String homeTelephone) {
        waitForElementVisible(driver, EmergencyContactsPU.DYNAMIC_DATA_TABLE, index, name, relationship,homeTelephone);
        return isElementDisplay(driver, EmergencyContactsPU.DYNAMIC_DATA_TABLE, index, name, relationship,homeTelephone);
    }

    public boolean isDataRowEmergencyContactUndisplayed(String index, String name, String relationship, String homeTelephone) {
        return isElementUnDisplay(driver, EmergencyContactsPU.DYNAMIC_DATA_TABLE, index, name, relationship,homeTelephone);
    }
}
