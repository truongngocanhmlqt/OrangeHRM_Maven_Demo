package PageObjects.pim.employee.employeeTabs;

import Commons.BasePages;
import PageUIs.pim.employee.employeeTabs.DependentsPU;
import PageUIs.pim.employee.employeeTabs.EmergencyContactsPU;
import org.openqa.selenium.WebDriver;

public class DependentsPO extends BasePages {
    private WebDriver driver;

    public DependentsPO(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToAddButtonInDependents() {
        waitForElementClickable(driver, DependentsPU.ADD_BUTTON_IN_ASSIGNED_DEPENDENTS);
        clickToElement(driver, DependentsPU.ADD_BUTTON_IN_ASSIGNED_DEPENDENTS);
    }

    public void clickToSaveButtonAtDependents() {
        waitForElementClickable(driver, DependentsPU.SAVE_BUTTON_IN_ASSIGNED_DEPENDENTS_CONTAINER);
        clickToElement(driver, DependentsPU.SAVE_BUTTON_IN_ASSIGNED_DEPENDENTS_CONTAINER);
    }

    public void selectRelationshipDropdown(String relationship) {
        waitForElementVisible(driver, DependentsPU.RELATIONSHIP_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, DependentsPU.RELATIONSHIP_DROPDOWN_PARENT, DependentsPU.RELATIONSHIP_DROPDOWN_CHILD, relationship);
    }

    public boolean isDynamicDataRowDependentsDisplay(String index, String dependentsName, String dependentsRelationship, String dependentDateOfBirth) {
        waitForElementVisible(driver, DependentsPU.DYNAMIC_DATA_TABLE, index, dependentsName, dependentsRelationship,dependentDateOfBirth);
        return isElementDisplay(driver, DependentsPU.DYNAMIC_DATA_TABLE, index, dependentsName, dependentsRelationship,dependentDateOfBirth);
    }

    public boolean isDataRowDependentsUndisplayed(String index, String dependentsName, String dependentsRelationship, String dependentDateOfBirth) {
        return isElementUnDisplay(driver, EmergencyContactsPU.DYNAMIC_DATA_TABLE, index, dependentsName, dependentsRelationship,dependentDateOfBirth);
    }

}
