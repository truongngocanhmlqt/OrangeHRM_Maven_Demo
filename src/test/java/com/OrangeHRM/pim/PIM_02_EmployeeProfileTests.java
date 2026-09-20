package com.OrangeHRM.pim;

import PageObjects.pim.employee.employeeTabs.ContactDetailsPO;
import PageObjects.pim.employee.employeeTabs.DependentsPO;
import PageObjects.pim.employee.employeeTabs.EmergencyContactsPO;
import PageObjects.pim.employee.employeeTabs.PersonalDetailPO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Orange HRM Demo")
@Feature("Employee Management")
public class PIM_02_EmployeeProfileTests extends BaseEmployeeTests {

    @Story("Upload Avatar")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "Upload employee avatar")
    public void Employee_02_Upload_Avatar() {
        PersonalDetailPO personalDetailPage = createEmployeeAndOpenPersonalDetails();
        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Saved");

        personalDetailPage.clickToEmployeeAvatarImage();
        Dimension beforeUpload = personalDetailPage.getAvatarSize();
        personalDetailPage.uploadMultipleFiles(driver, avatarImageName);
        personalDetailPage.clickToSaveButtonAtProfileContainer();

        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Updated");
        personalDetailPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(personalDetailPage.isProfileDataUpdateSuccess(beforeUpload));
    }

    @Story("Personal Details")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Update personal details")
    public void Employee_03_Personal_Details() {
        PersonalDetailPO personalDetailPage = createEmployeeAndOpenPersonalDetails();
        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Saved");

        personalDetailPage.openPersonalDetailsPage();
        personalDetailPage.enterToFirstNameTextbox(editFirstName);
        personalDetailPage.enterToMiddleNameTextbox(editMiddleName);
        personalDetailPage.enterToLastNameTextbox(editLastName);
        personalDetailPage.enterToDriverLicenseTextbox(driverLicense);
        personalDetailPage.enterToLicenseExpiryDateTextbox(licenseExpiryDate);
        personalDetailPage.selectNationalityDropdown("Vietnamese");
        personalDetailPage.selectMaritalStatusDropdown("Single");
        personalDetailPage.enterToDateOfBirthTextbox(dateOfBirth);
        personalDetailPage.selectGenderMaleRadioButton("Male");
        personalDetailPage.clickToSaveButtonAtPersonalDetailContainer();

        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Updated");
        personalDetailPage.waitAllLoadingIconInvisible(driver);
        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue(), editFirstName);
        Assert.assertEquals(personalDetailPage.getMiddleNameTextboxValue(), editMiddleName);
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue(), editLastName);
        Assert.assertEquals(personalDetailPage.getEmployeeID(), employeeId);
        Assert.assertEquals(personalDetailPage.getDriverLicenseTextboxValue(), driverLicense);
        Assert.assertEquals(personalDetailPage.getLicenseExpiryDateTextboxValue(), licenseExpiryDate);
        Assert.assertEquals(personalDetailPage.getNationalityDropdownValue(), "Vietnamese");
        Assert.assertEquals(personalDetailPage.getDateOfBirthTextboxValue(), dateOfBirth);
        Assert.assertEquals(personalDetailPage.getMaritalStatusDropdownValue(), "Single");
        Assert.assertTrue(personalDetailPage.isGenderMaleRadioSelected("Male"));
    }

    @Story("Contact Details")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Update contact details")
    public void Employee_04_Contact_Details() {
        PersonalDetailPO personalDetailPage = createEmployeeAndOpenPersonalDetails();
        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Saved");

        ContactDetailsPO contactDetailsPage = personalDetailPage.openContactDetailsPage();
        contactDetailsPage.enterTextboxByText(driver, "Street 1", street1);
        contactDetailsPage.enterTextboxByText(driver, "Street 2", street2);
        contactDetailsPage.enterTextboxByText(driver, "City", city);
        contactDetailsPage.enterTextboxByText(driver, "State/Province", province);
        contactDetailsPage.enterTextboxByText(driver, "Zip/Postal Code", zipCode);
        contactDetailsPage.selectCountryDropdown(country);
        contactDetailsPage.enterTextboxByText(driver, "Home", home);
        contactDetailsPage.enterTextboxByText(driver, "Mobile", mobile);
        contactDetailsPage.enterTextboxByText(driver, "Work", work);
        contactDetailsPage.enterTextboxByText(driver, "Work Email", workEmail);
        contactDetailsPage.enterTextboxByText(driver, "Other Email", otherEmail);
        contactDetailsPage.clickToSaveButtonAtContactDetailContainer();

        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Updated");
        personalDetailPage.waitAllLoadingIconInvisible(driver);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver, "Street 1"), street1);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver, "Street 2"), street2);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver, "City"), city);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver, "State/Province"), province);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver, "Zip/Postal Code"), zipCode);
        Assert.assertEquals(contactDetailsPage.getCountryDropdownValue(), country);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver, "Home"), home);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver, "Mobile"), mobile);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver, "Work"), work);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver, "Work Email"), workEmail);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver, "Other Email"), otherEmail);
    }

    @Story("Emergency Contact")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Add and delete emergency contact")
    public void Employee_05_Emergency_Contact() {
        PersonalDetailPO personalDetailPage = createEmployeeAndOpenPersonalDetails();
        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Saved");

        EmergencyContactsPO emergencyContactsPage = personalDetailPage.openEmergencyContactPage();
        emergencyContactsPage.clickToAddButtonInEmergencyContacts();
        emergencyContactsPage.enterTextboxByText(driver, "Name", emergencyName);
        emergencyContactsPage.enterTextboxByText(driver, "Relationship", emergencyRelationship);
        emergencyContactsPage.enterTextboxByText(driver, "Home Telephone", emergencyHomeTelephone);
        emergencyContactsPage.clickToSaveButtonAtEmergencyContact();

        Assert.assertEquals(emergencyContactsPage.getSuccesstext(driver), "Successfully Saved");
        emergencyContactsPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(emergencyContactsPage.isDynamicDataRowEmergencyContactDisplay("1", emergencyName, emergencyRelationship, emergencyHomeTelephone));

        emergencyContactsPage.clickToDynamicDeleteIcon(driver, "1");
        emergencyContactsPage.clickToYesDeleteButton(driver);
        Assert.assertEquals(emergencyContactsPage.getSuccesstext(driver), "Successfully Deleted");
        emergencyContactsPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(emergencyContactsPage.isDataRowEmergencyContactUndisplayed("1", emergencyName, emergencyRelationship, emergencyHomeTelephone));
    }

    @Story("Dependents")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Add and delete dependent")
    public void Employee_06_Dependents() {
        PersonalDetailPO personalDetailPage = createEmployeeAndOpenPersonalDetails();
        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Saved");

        DependentsPO dependentsPage = personalDetailPage.openDependentsPage();
        dependentsPage.clickToAddButtonInDependents();
        dependentsPage.enterTextboxByText(driver, "Name", dependentsName);
        dependentsPage.selectRelationshipDropdown(dependentsRelationship);
        dependentsPage.enterTextboxByText(driver, "Date of Birth", dependentDateOfBirth);
        dependentsPage.clickToSaveButtonAtDependents();

        Assert.assertEquals(dependentsPage.getSuccesstext(driver), "Successfully Saved");
        dependentsPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(dependentsPage.isDynamicDataRowDependentsDisplay("1", dependentsName, dependentsRelationship, dependentDateOfBirth));

        dependentsPage.clickToDynamicDeleteIcon(driver, "1");
        dependentsPage.clickToYesDeleteButton(driver);
        Assert.assertEquals(dependentsPage.getSuccesstext(driver), "Successfully Deleted");
        dependentsPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(dependentsPage.isDataRowDependentsUndisplayed("1", dependentsName, dependentsRelationship, dependentDateOfBirth));
    }
}
