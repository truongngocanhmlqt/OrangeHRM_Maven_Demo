package PageUIs.pim.employee.employeeTabs;

public class ImmigrationPU {
    public static final String ADD_BUTTON_IN_IMMIGRATION = "xpath=//h6[text()='Assigned Immigration Records']/parent::div/button[contains(string(),'Add')]";
    public static final String SAVE_BUTTON_AT_IMMIGRATION_CONTAINER = "xpath=//h6[text()='Add Immigration']//following-sibling::form//div[@class='oxd-form-actions']//button[contains(string(),'Save')]";
    public static final String ISSUED_BY_DROPDOWN_PARENT = "xpath=//label[text()='Issued By']//parent::div//following-sibling::div//i";
    public static final String ISSUED_BY_DROPDOWN_CHILD = "xpath=//label[text()='Issued By']//parent::div//following-sibling::div//span";
    public static final String DOCUMENT_RADIO_BUTTON = "xpath=//label[text()='Document']//parent::div//following-sibling::div//label[contains(string(),'%s')]/input";
    public static final String DYNAMIC_DATA_TABLE_IN_IMMIGRATION ="xpath=//div[@class='oxd-table-card'][%s]" +
            "//div[text()='%s']/parent::div/following-sibling::div/div[text()='%s']" +
            "/parent::div/following-sibling::div/div[text()='%s']" +
            "/parent::div/following-sibling::div/div[text()='%s']";




}
