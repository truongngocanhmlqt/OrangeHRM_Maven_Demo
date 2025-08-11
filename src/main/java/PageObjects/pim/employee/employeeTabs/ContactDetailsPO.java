package PageObjects.pim.employee.employeeTabs;

import PageUIs.pim.employee.employeeTabs.ContactDetailPU;
import PageUIs.pim.employee.employeeTabs.PersonalDetailPU;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPO extends EmployeeTabsPO {
    private WebDriver driver;

    public ContactDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void clickToSaveButtonAtContactDetailContainer() {
        waitForElementVisible(driver, ContactDetailPU.SAVE_BUTTON_AT_CONTACT_DETAIL_CONTAINER);
        clickToElement(driver,ContactDetailPU.SAVE_BUTTON_AT_CONTACT_DETAIL_CONTAINER);
    }

    public void selectCountryDropdown(String country) {
        waitForElementVisible(driver, ContactDetailPU.COUNTRY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, ContactDetailPU.COUNTRY_DROPDOWN_PARENT, ContactDetailPU.COUNTRY_DROPDOWN_CHILD, country);
    }

    public String getCountryDropdownValue() {
        waitForElementVisible(driver, ContactDetailPU.COUNTRY_DROPDOWN_TEXTBOX);
        return getElementText(driver, ContactDetailPU.COUNTRY_DROPDOWN_TEXTBOX);
    }
}
