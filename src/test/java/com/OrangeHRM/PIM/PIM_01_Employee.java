package com.OrangeHRM.PIM;

import Commons.BaseTests;
import Commons.GlobalConstant;
import PageObjects.DashboardPO;
import PageObjects.LoginPO;
import PageObjects.PageGenerator;
import PageObjects.pim.employee.AddNewEmployeePO;
import PageObjects.pim.employee.EmployeeListPO;
import PageObjects.pim.employee.employeeTabs.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PIM_01_Employee extends BaseTests {

    private WebDriver driver;
    private LoginPO loginPage;
    public DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailPO personalDetailPage;
    private AddNewEmployeePO addNewEmployeePage;
    private DependentsPO dependentsPage;
    private EmergencyContactsPO emergencyContactsPage;
    private ContactDetailsPO contactDetailsPage;
    public String employeeID;
    private String firstName, middleName, lastName, editFirstName, editLastName, editMiddleName;
    private String driverLicense, licenseExpiryDate, dateOfBirth;
    private String street1, street2, city, province,zipCode,country,home, mobile, work, workEmail, otherEmail;
    private String emergencyName, emergencyRelationship, emergencyHomeTelephone, dependentsName, dependentDateOfBirth, dependentsRelationship;
    private String avatarImageName = "HoChiMinh.jpg";





    @Parameters({"browser", "userURL"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        firstName = "Ngo";
        middleName = "Si";
        lastName = "Lien";
        editFirstName = "Le";
        editMiddleName ="Quang";
        editLastName ="Chi";
        driverLicense ="VH112233";
        licenseExpiryDate = "2026-07-31";
        dateOfBirth = "2001-07-04";

        street1 = "Nguyen Hue";
        street2 = "Le Loi";
        city = "Dong Hoi";
        province = "Quang Binh";
        country = "Viet Nam";
        zipCode = "001122";

        home ="0123123";
        mobile ="0912999123";
        work ="0912456";
        workEmail = "Lien"+ generateRandomNumber() +"@gmail.com";
        otherEmail ="Lien"+ generateRandomNumber() +"@work.com";;
        //Emergency_Contact
        emergencyName = "Hoa";
        emergencyRelationship = "Vo";
        emergencyHomeTelephone = "01200918";
        dependentsName = "Hoang";
        dependentsRelationship = "Child";
        dependentDateOfBirth = "2025-01-01";

        driver = getBrowserDriver(browserName, url);
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.enterToUsernameTextbox(GlobalConstant.ADMIN_USER_NAME);
        loginPage.enterToPasswordTextbox(GlobalConstant.PASSWORD_ADMIN);
        dashboardPage = loginPage.clickToLoginButton();
    }
    @Test
    public void Employee_01_Add_New() {
        employeeListPage = dashboardPage.clickToPIMPage();
        addNewEmployeePage = employeeListPage.clickToAddEmployeeButton();
        addNewEmployeePage.enterToFirstNameTextbox(driver, firstName);
        addNewEmployeePage.enterToMidleNameTextbox(driver, middleName);
        addNewEmployeePage.enterToLastNameTextbox(driver, lastName);
        employeeID = addNewEmployeePage.getEmployeeID();
        GlobalConstant.TestDataHolder.employeeID = employeeID;
        personalDetailPage = addNewEmployeePage.clickToSaveButtonAtEmployeeContainer();
        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Saved");
        personalDetailPage.waitAllLoadingIconInvisible(driver);
    }
    @Test
    public void Employee_02_Upload_Avatar() {
        personalDetailPage.clickToEmployeeAvatarImage();
        Dimension beforeUpload = personalDetailPage.getAvatarSize();
        personalDetailPage.uploadMultipleFiles(driver, avatarImageName);
        personalDetailPage.clickToSaveButtonAtProfileContainer();
        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Updated");
        personalDetailPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(personalDetailPage.isProfileDataUpdateSuccess(beforeUpload));
    }
    @Test
    public void Employee_03_Personal_Details() {
        personalDetailPage.openPersonalDetailsPage();
        personalDetailPage.enterToFirstNameTextbox(editFirstName);
        personalDetailPage.enterToMiddleNameTextbox(editMiddleName);
        personalDetailPage.enterToLastNameTextbox(editLastName);
        Assert.assertEquals(personalDetailPage.getEmployeeID(), employeeID);
        personalDetailPage.enterToDriverLicenseTextbox(driverLicense);
        personalDetailPage.enterToLicenseExpiryDateTextbox(licenseExpiryDate);
        personalDetailPage.selectNationalityDropdown("Vietnamese");
        personalDetailPage.selectMaritalStatusDropdown("Single");
        personalDetailPage.enterToDateOfBirthTextbox(dateOfBirth);
        personalDetailPage.selectGenderMaleRadioButton("Male");
        personalDetailPage.clickToSaveButtonAtPersonalDetailContainer();
        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Updated");
        personalDetailPage.waitAllLoadingIconInvisible(driver);
        //verify
        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue(), editFirstName);
        Assert.assertEquals(personalDetailPage.getMiddleNameTextboxValue(), editMiddleName);
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue(), editLastName);
        Assert.assertEquals(personalDetailPage.getEmployeeID(), employeeID);
        Assert.assertEquals(personalDetailPage.getDriverLicenseTextboxValue(), driverLicense);
        Assert.assertEquals(personalDetailPage.getLicenseExpiryDateTextboxValue(), licenseExpiryDate);
        Assert.assertEquals(personalDetailPage.getNationalityDropdownValue(), "Vietnamese");
        Assert.assertEquals(personalDetailPage.getDateOfBirthTextboxValue(), dateOfBirth);
        Assert.assertEquals(personalDetailPage.getMaritalStatusDropdownValue(), "Single");
        Assert.assertTrue(personalDetailPage.isGenderMaleRadioSelected("Male"));
    }
    @Test
    public void Employee_04_Contact_Details() {
        contactDetailsPage = personalDetailPage.openContactDetailsPage();
        contactDetailsPage.enterTextboxByText(driver,"Street 1",street1);
        contactDetailsPage.enterTextboxByText(driver,"Street 2",street2);
        contactDetailsPage.enterTextboxByText(driver,"City",city);
        contactDetailsPage.enterTextboxByText(driver,"State/Province",province);
        contactDetailsPage.enterTextboxByText(driver,"Zip/Postal Code",zipCode);
        contactDetailsPage.selectCountryDropdown("Viet Nam");
        contactDetailsPage.enterTextboxByText(driver,"Home",home);
        contactDetailsPage.enterTextboxByText(driver,"Mobile",mobile);
        contactDetailsPage.enterTextboxByText(driver,"Work",work);
        contactDetailsPage.enterTextboxByText(driver,"Work Email",workEmail);
        contactDetailsPage.enterTextboxByText(driver,"Other Email",otherEmail);
        contactDetailsPage.clickToSaveButtonAtContactDetailContainer();
        Assert.assertEquals(personalDetailPage.getSuccesstext(driver), "Successfully Updated");
        personalDetailPage.waitAllLoadingIconInvisible(driver);
        //Verify
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver,"Street 1"), street1);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver, "Street 2"), street2);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver,"City"), city);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver,"State/Province"), province);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver,"Zip/Postal Code"), zipCode);
        Assert.assertEquals(contactDetailsPage.getCountryDropdownValue(), "Viet Nam");
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver,"Home"), home);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver,"Mobile"), mobile);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver,"Work"), work);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver,"Work Email"), workEmail);
        Assert.assertEquals(contactDetailsPage.getTextboxValueByText(driver,"Other Email"), otherEmail);
    }
    @Test
    public void Employee_05_Emergency_Contact() {
        //add data
        emergencyContactsPage = contactDetailsPage.openEmergencyContactPage();
        emergencyContactsPage.clickToAddButtonInEmergencyContacts();
        emergencyContactsPage.enterTextboxByText(driver, "Name", emergencyName);
        emergencyContactsPage.enterTextboxByText(driver, "Relationship", emergencyRelationship);
        emergencyContactsPage.enterTextboxByText(driver, "Home Telephone", emergencyHomeTelephone);
        emergencyContactsPage.clickToSaveButtonAtEmergencyContact();
        Assert.assertEquals(emergencyContactsPage.getSuccesstext(driver), "Successfully Saved");
        emergencyContactsPage.waitAllLoadingIconInvisible(driver);
        //Verify data row
        Assert.assertTrue(emergencyContactsPage.isDynamicDataRowEmergencyContactDisplay("1",emergencyName, emergencyRelationship, emergencyHomeTelephone));
        //delete row
        emergencyContactsPage.clickToDynamicDeleteIcon(driver,"1");
        emergencyContactsPage.clickToYesDeleteButton(driver);
        Assert.assertEquals(emergencyContactsPage.getSuccesstext(driver), "Successfully Deleted");
        emergencyContactsPage.waitAllLoadingIconInvisible(driver);
        //Verify deleted row
        Assert.assertTrue(emergencyContactsPage.isDataRowEmergencyContactUndisplayed("1",emergencyName, emergencyRelationship, emergencyHomeTelephone));
    }
    @Test
    public void Employee_06_Dependents() {
        dependentsPage = emergencyContactsPage.openDependentsPage();
        dependentsPage.clickToAddButtonInDependents();
        dependentsPage.enterTextboxByText(driver, "Name", dependentsName);
        dependentsPage.selectRelationshipDropdown(dependentsRelationship);
        dependentsPage.enterTextboxByText(driver, "Date of Birth", dependentDateOfBirth );
        dependentsPage.clickToSaveButtonAtDependents();
        Assert.assertEquals(dependentsPage.getSuccesstext(driver), "Successfully Saved");
        dependentsPage.waitAllLoadingIconInvisible(driver);
        //Verify data row
        Assert.assertTrue(dependentsPage.isDynamicDataRowDependentsDisplay("1",dependentsName, dependentsRelationship, dependentDateOfBirth));
        //delete row
        dependentsPage.clickToDynamicDeleteIcon(driver,"1");
        dependentsPage.clickToYesDeleteButton(driver);
        Assert.assertEquals(dependentsPage.getSuccesstext(driver), "Successfully Deleted");
        dependentsPage.waitAllLoadingIconInvisible(driver);
        //Verify deleted row
        Assert.assertTrue(dependentsPage.isDataRowDependentsUndisplayed("1",dependentsName, dependentsRelationship, dependentDateOfBirth));
    }

    @AfterClass

    public void afterClass() {
        driver.quit();
    }




}

