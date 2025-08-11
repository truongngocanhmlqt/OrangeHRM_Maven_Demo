package PageUIs.pim.employee;

public class AddNewEmployeePU {
    public static final String FIRST_NAME_TEXTBOX = "xpath= //input[@name='firstName']";
    public static final String MIDDLE_NAME_TEXTBOX = "xpath= //input[@name='middleName']";
    public static final String LAST_NAME_TEXTBOX = "xpath= //input[@name='lastName']";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div//input";
    public static final String SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER = "xpath= //h6[text()='Add Employee']//following-sibling::form//div[@class='oxd-form-actions']//button[contains(string(),'Save')]";
}
