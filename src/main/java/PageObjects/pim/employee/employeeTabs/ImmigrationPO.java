package PageObjects.pim.employee.employeeTabs;

import Commons.BasePages;
import PageUIs.BasePagePU;
import PageUIs.pim.employee.employeeTabs.ContactDetailPU;
import PageUIs.pim.employee.employeeTabs.ImmigrationPU;
import PageUIs.pim.employee.employeeTabs.PersonalDetailPU;
import org.openqa.selenium.WebDriver;

public class ImmigrationPO extends EmployeeTabsPO {
    private WebDriver driver;

    public ImmigrationPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void clickToAddButtonInAddImmigration() {
        waitForElementClickable(driver, ImmigrationPU.ADD_BUTTON_IN_IMMIGRATION);
        clickToElement(driver, ImmigrationPU.ADD_BUTTON_IN_IMMIGRATION);
    }

    public void clickToSaveButtonAtImmigration() {
        waitForElementClickable(driver, ImmigrationPU.SAVE_BUTTON_AT_IMMIGRATION_CONTAINER);
        clickToElement(driver, ImmigrationPU.SAVE_BUTTON_AT_IMMIGRATION_CONTAINER);
    }

    public void selectPassportDocumentRadioButton(String document) {
        clickToElementByJS(driver, ImmigrationPU.DOCUMENT_RADIO_BUTTON,document);

    }


    public void selectIssuedByDropdown(String country) {
        waitForElementVisible(driver, ImmigrationPU.ISSUED_BY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, ImmigrationPU.ISSUED_BY_DROPDOWN_PARENT, ImmigrationPU.ISSUED_BY_DROPDOWN_CHILD, country);
    }

    public boolean isDynamicDataRowImmigrationDisplay(String index, String document, String number, String issuedBy, String issueDate) {
        waitForElementVisible(driver, ImmigrationPU.DYNAMIC_DATA_TABLE_IN_IMMIGRATION,index, document, number,issuedBy, issueDate);
        return isElementDisplay(driver, ImmigrationPU.DYNAMIC_DATA_TABLE_IN_IMMIGRATION,index, document, number,issuedBy, issueDate);
    }

    public boolean isDataRowImmigrationUndisplayed(String index, String document, String number, String issuedBy, String issueDate) {
        return isElementUnDisplay(driver, ImmigrationPU.DYNAMIC_DATA_TABLE_IN_IMMIGRATION,index, document, number,issuedBy, issueDate);

    }
}
