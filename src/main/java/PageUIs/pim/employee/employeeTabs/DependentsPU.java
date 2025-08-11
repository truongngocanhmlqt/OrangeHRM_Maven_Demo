package PageUIs.pim.employee.employeeTabs;

public class DependentsPU {
    public static final String ADD_BUTTON_IN_ASSIGNED_DEPENDENTS= "xpath=//h6[text()='Assigned Dependents']/parent::div/button[contains(string(),'Add')]";
    public static final String SAVE_BUTTON_IN_ASSIGNED_DEPENDENTS_CONTAINER = "xpath=//h6[text()='Add Dependent']//following-sibling::form//div[@class='oxd-form-actions']//button[contains(string(),'Save')]";
    public static final String RELATIONSHIP_DROPDOWN_PARENT = "xpath=//label[text()='Relationship']//parent::div//following-sibling::div//i";
    public static final String RELATIONSHIP_DROPDOWN_CHILD = "xpath=//label[text()='Relationship']//parent::div//following-sibling::div//span";
    public static final String DYNAMIC_DATA_TABLE ="xpath=//div[@class='oxd-table-card'][%s]//div[text()='%s']" +
            "/parent::div/following-sibling::div/div[text()='%s']" +
            "/parent::div/following-sibling::div/div[text()='%s']";
}
