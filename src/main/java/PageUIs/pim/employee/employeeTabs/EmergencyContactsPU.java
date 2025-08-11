package PageUIs.pim.employee.employeeTabs;

public class EmergencyContactsPU {
    public static final String ADD_BUTTON_IN_EMERGENCY_CONTACTS = "xpath=//h6[text()='Assigned Emergency Contacts']/parent::div/button[contains(string(),'Add')]";
    public static final String SAVE_BUTTON_AT_EMERGENCY_CONTACT_CONTAINER = "xpath=//h6[text()='Save Emergency Contact']//following-sibling::form//div[@class='oxd-form-actions']//button[contains(string(),'Save')]";
    public static final String DYNAMIC_DATA_TABLE ="xpath=//div[@class='oxd-table-card'][%s]//div[text()='%s']" +
            "/parent::div/following-sibling::div/div[text()='%s']" +
            "/parent::div/following-sibling::div/div[text()='%s']";

    }