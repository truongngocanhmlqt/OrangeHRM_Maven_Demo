package PageUIs.pim.employee;

public class EmployeeListPU {
    public static final String ADD_EMPLOYEE_NAV_BUTTON = "xpath=//a[contains(@class,'nav-tab') and text()='Add Employee']";
    public static final String DYNAMIC_EDIT_EMPLOYEE ="xpath=//div[text()='%s']/parent::div/following-sibling::div//button/i[contains(@class,'bi-pencil-fill')]";
}
