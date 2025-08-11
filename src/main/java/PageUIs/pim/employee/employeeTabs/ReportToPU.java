package PageUIs.pim.employee.employeeTabs;

public class ReportToPU {
    public static final String ADD_BUTTON_IN_ASSIGNED_SUPERVISORS = "xpath=//h6[text()='Assigned Supervisors']/parent::div/button[contains(string(),'Add')]";
    public static final String SAVE_BUTTON_AT_ASSIGNED_SUPERVISORS_CONTAINER = "xpath=//h6[text()='Add Supervisor']//following-sibling::form//div[@class='oxd-form-actions']//button[contains(string(),'Save')]";
    public static final String REQUIRED_TEXT_IN_NAME = "xpath=//span[text()='Required']/preceding-sibling::div//label[contains(string(),'Name')]";
    public static final String REQUIRED_TEXT_IN_REPORTING_METHOD = "xpath=//span[text()='Required']/preceding-sibling::div//label[contains(string(),'Reporting Method')]";
    public static final String CANCEL_BUTTON_AT_ASSIGNED_SUPERVISORS_CONTAINER = "xpath=//h6[text()='Add Supervisor']//following-sibling::form//div[@class='oxd-form-actions']//button[contains(string(),'Cancel')]";
}
