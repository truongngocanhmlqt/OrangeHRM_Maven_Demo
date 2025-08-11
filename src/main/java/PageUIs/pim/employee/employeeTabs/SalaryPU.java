package PageUIs.pim.employee.employeeTabs;

public class SalaryPU {
    public static final String ADD_BUTTON_IN_SALARY = "xpath=//h6[text()='Assigned Salary Components']/parent::div/button[contains(string(),'Add')]";
    public static final String SAVE_BUTTON_AT_SALARY_COMPONENT_CONTAINER = "xpath=//h6[text()=' Add Salary Component ']//following-sibling::form//div[@class='oxd-form-actions']//button[contains(string(),'Save')]";
    public static final String REQUIRED_TEXT_IN_SALARY_COMPONENT = "xpath=//span[text()='Required']/preceding-sibling::div//label[contains(string(),'Salary Component')]";
    public static final String REQUIRED_TEXT_IN_CURRENCY = "xpath=//span[text()='Required']/preceding-sibling::div//label[contains(string(),'Currency')]";
    public static final String REQUIRED_TEXT_IN_AMOUNT = "xpath=//span[text()='Required']/preceding-sibling::div//label[contains(string(),'Amount')]";



}
