package PageObjects.pim.employee.employeeTabs;

import PageUIs.pim.employee.employeeTabs.PersonalDetailPU;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class PersonalDetailPO extends EmployeeTabsPO {
    private WebDriver driver;

    public PersonalDetailPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public Dimension getAvatarSize() {
        return getElementSize(driver, PersonalDetailPU.EMPLOYEE_AVATAR_IMAGE_LINK);
    }

    public void clickToEmployeeAvatarImage() {
        waitForElementClickable(driver, PersonalDetailPU.EMPLOYEE_AVATAR_IMAGE_LINK);
        clickToElement(driver,PersonalDetailPU.EMPLOYEE_AVATAR_IMAGE_LINK);
    }


    public void clickToSaveButtonAtProfileContainer() {
        waitForElementClickable(driver, PersonalDetailPU.SAVE_BUTTON_AT_CHANGE_PROFILE_PICTURE);
        clickToElement(driver,PersonalDetailPU.SAVE_BUTTON_AT_CHANGE_PROFILE_PICTURE);
    }

    public boolean isProfileDataUpdateSuccess(Dimension beforeUpload) {
        sleepInSecond(3);
        Dimension afterUpload = getAvatarSize();
        return !beforeUpload.equals(afterUpload);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, PersonalDetailPU.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailPU.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToMiddleNameTextbox(String middleName) {
        waitForElementVisible(driver, PersonalDetailPU.MIDDLE_NAME_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailPU.MIDDLE_NAME_TEXTBOX, middleName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, PersonalDetailPU.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailPU.LAST_NAME_TEXTBOX, lastName);

    }

    public String getEmployeeID() {
        waitForElementVisible(driver, PersonalDetailPU.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailPU.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public void enterToDriverLicenseTextbox(String driverLicense) {
        waitForElementVisible(driver, PersonalDetailPU.DRIVER_LICENSE_NUMBER_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailPU.DRIVER_LICENSE_NUMBER_TEXTBOX, driverLicense);

    }

    public void enterToLicenseExpiryDateTextbox(String licenseExpiryDate) {
        waitForElementVisible(driver, PersonalDetailPU.LICENSE_EXPIRY_DATE_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailPU.LICENSE_EXPIRY_DATE_TEXTBOX, licenseExpiryDate);
    }

    public void selectNationalityDropdown(String nationality) {
        waitForElementClickable(driver, PersonalDetailPU.NATIONALITY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailPU.NATIONALITY_DROPDOWN_PARENT, PersonalDetailPU.NATIONALITY_DROPDOWN_CHILD, nationality);
    }

    public void selectMaritalStatusDropdown(String maritalStatus) {
        waitForElementClickable(driver, PersonalDetailPU.MARITAL_STATUS_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailPU.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailPU.MARITAL_STATUS_DROPDOWN_CHILD, maritalStatus);
    }

    public void enterToDateOfBirthTextbox(String dateOfBirth) {
        waitForElementVisible(driver, PersonalDetailPU.DATE_OF_BIRTH_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailPU.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
    }

    public void selectGenderMaleRadioButton(String gender) {;
        clickToElementByJS(driver, PersonalDetailPU.GENDER_RADIO_BUTTON,gender);
    }

    public void clickToSaveButtonAtPersonalDetailContainer() {
        waitForElementVisible(driver, PersonalDetailPU.SAVE_BUTTON_AT_PERSONAL_DETAIL_CONTAINER);
        clickToElement(driver,PersonalDetailPU.SAVE_BUTTON_AT_PERSONAL_DETAIL_CONTAINER);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailPU.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailPU.FIRST_NAME_TEXTBOX, "value");
    }

    public String getMiddleNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailPU.MIDDLE_NAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailPU.MIDDLE_NAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailPU.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailPU.LAST_NAME_TEXTBOX, "value");
    }

    public String getDriverLicenseTextboxValue() {
        waitForElementVisible(driver, PersonalDetailPU.DRIVER_LICENSE_NUMBER_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailPU.DRIVER_LICENSE_NUMBER_TEXTBOX, "value");
    }

    public String getLicenseExpiryDateTextboxValue() {
        waitForElementVisible(driver, PersonalDetailPU.LICENSE_EXPIRY_DATE_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailPU.LICENSE_EXPIRY_DATE_TEXTBOX,"value" );
    }

    public String getNationalityDropdownValue() {
        waitForElementVisible(driver, PersonalDetailPU.NATIONALITY_DROPDOWN_TEXTBOX);
        return getElementText(driver, PersonalDetailPU.NATIONALITY_DROPDOWN_TEXTBOX);
    }

    public String getDateOfBirthTextboxValue() {
        waitForElementVisible(driver, PersonalDetailPU.DATE_OF_BIRTH_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailPU.DATE_OF_BIRTH_TEXTBOX, "value");
    }

    public String getMaritalStatusDropdownValue() {
        waitForElementVisible(driver, PersonalDetailPU.MARITAL_STATUS_DROPDOWN_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailPU.MARITAL_STATUS_DROPDOWN_TEXTBOX, "textContent");
    }

    public boolean isGenderMaleRadioSelected(String gender) {
        //waitForElementVisible(driver, PersonalDetailPU.GENDER_RADIO_BUTTON,gender);
        return isElementSelected(driver,PersonalDetailPU.GENDER_RADIO_BUTTON,gender);
    }


}
