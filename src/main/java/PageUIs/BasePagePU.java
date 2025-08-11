package PageUIs;

public class BasePagePU {
    public static final String LOADING_ICON= "xpath=//div[@class='oxd-loading-spinner']";
    public static final String SUCCESS_TEXT ="xpath=//p[contains(@class,'oxd-text--toast-message')]";
    public static final String UPLOAD_FILE_TYPE ="css=input[type='file']";

    //Pattern Object
    public static final String TEXTBOX_BY_TEXT ="xpath=//label[text()='%s']//parent::div//following-sibling::div//input";
    public static final String DYNAMIC_DELETE_DATA_BUTTON_BY_INDEX ="xpath=//div[@class='oxd-table-card'][%s]//button//i[@class='oxd-icon bi-trash']";
    public static final String YES_DELETE_BUTTON ="xpath=//button[text()=' Yes, Delete ']";

}
