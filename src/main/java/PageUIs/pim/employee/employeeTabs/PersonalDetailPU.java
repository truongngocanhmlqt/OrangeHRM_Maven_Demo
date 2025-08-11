package PageUIs.pim.employee.employeeTabs;

public class PersonalDetailPU {
    public static final String EMPLOYEE_AVATAR_IMAGE_LINK ="xpath= //div[@class='orangehrm-edit-employee-navigation']//img[@alt='profile picture']";
    public static final String SAVE_BUTTON_AT_CHANGE_PROFILE_PICTURE ="xpath=//h6[text()='Change Profile Picture']//following-sibling::form//div[@class='oxd-form-actions']//button[contains(string(),'Save')]";
    public static final String FIRST_NAME_TEXTBOX = "css=input[name=firstName]";
    public static final String MIDDLE_NAME_TEXTBOX = "css=input[name=middleName]";
    public static final String LAST_NAME_TEXTBOX = "css=input[name=lastName]";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']//parent::div//following-sibling::div//input";
    public static final String DRIVER_LICENSE_NUMBER_TEXTBOX = "xpath=//label[text()=\"Driver's License Number\"]//parent::div//following-sibling::div//input";
    public static final String LICENSE_EXPIRY_DATE_TEXTBOX = "xpath=//label[text()='License Expiry Date']//parent::div//following-sibling::div//input";
    public static final String NATIONALITY_DROPDOWN_PARENT = "xpath=//label[text()='Nationality']//parent::div//following-sibling::div//i";
    public static final String NATIONALITY_DROPDOWN_CHILD = "xpath=//label[text()='Nationality']//parent::div//following-sibling::div//span";
    public static final String NATIONALITY_DROPDOWN_TEXTBOX = "xpath=//label[text()='Nationality']//parent::div//following-sibling::div";
    public static final String MARITAL_STATUS_DROPDOWN_PARENT = "xpath=//label[text()='Marital Status']//parent::div//following-sibling::div//i";
    public static final String MARITAL_STATUS_DROPDOWN_CHILD = "xpath=//label[text()='Marital Status']//parent::div//following-sibling::div//span";
    public static final String MARITAL_STATUS_DROPDOWN_TEXTBOX = "xpath=//label[text()='Marital Status']//parent::div//following-sibling::div";
    public static final String DATE_OF_BIRTH_TEXTBOX = "xpath=//label[text()='Date of Birth']//parent::div//following-sibling::div//input";
    public static final String GENDER_RADIO_BUTTON = "xpath=//label[text()='Gender']//parent::div//following-sibling::div//label[contains(string(),'%s')]/input";
    public static final String SAVE_BUTTON_AT_PERSONAL_DETAIL_CONTAINER = "xpath=//h6[text()='Personal Details']//following-sibling::form//div[@class='oxd-form-actions']//button[contains(string(),'Save')]";



}
