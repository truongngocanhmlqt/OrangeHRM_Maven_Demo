package PageObjects.pim.employee.employeeTabs;

import Commons.BasePages;
import PageUIs.pim.employee.employeeTabs.JobPU;
import org.openqa.selenium.WebDriver;

public class JobPO extends EmployeeTabsPO {
    private WebDriver driver;

    public JobPO(WebDriver driver)  {
        super(driver);
        this.driver = driver;
    }


    public void selectJobTitleDropdown(String jobTitle) {
        waitForElementVisible(driver, JobPU.JOB_TITLE_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, JobPU.JOB_TITLE_DROPDOWN_PARENT, JobPU.JOB_TITLE_DROPDOWN_CHILD, jobTitle);
    }

    public void selectJobCategoryDropdown(String JobCategory) {
        waitForElementVisible(driver, JobPU.JOB_CATEGORY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, JobPU.JOB_CATEGORY_DROPDOWN_PARENT, JobPU.JOB_CATEGORY_DROPDOWN_CHILD, JobCategory);
    }

    public void selectLocationDropdown(String Location) {
        waitForElementVisible(driver, JobPU.JOB_LOCATION_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, JobPU.JOB_LOCATION_DROPDOWN_PARENT, JobPU.JOB_LOCATION_DROPDOWN_CHILD, Location);
    }

    public void selectEmploymentStatusDropdown(String EmploymentStatus) {
        waitForElementVisible(driver, JobPU.EMPLOYMENT_STATUS_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, JobPU.EMPLOYMENT_STATUS_DROPDOWN_PARENT, JobPU.EMPLOYMENT_STATUS_DROPDOWN_CHILD, EmploymentStatus);
    }

    public void clickToSaveButtonAtJobDetail() {
        waitForElementVisible(driver, JobPU.SAVE_BUTTON_AT_JOB_CONTAINER);
        clickToElement(driver, JobPU.SAVE_BUTTON_AT_JOB_CONTAINER);
    }

    public String getJoinedDateTextboxValue() {
        waitForElementVisible(driver, JobPU.JOINED_DATE_TEXTBOX);
        return getElementAttribute(driver, JobPU.JOINED_DATE_TEXTBOX, "value");
    }

    public String getJobTitleTextboxValue() {
        waitForElementVisible(driver, JobPU.JOB_TITLE_DROPDOWN_TEXTBOX);
        return getElementText(driver, JobPU.JOB_TITLE_DROPDOWN_TEXTBOX);
    }

    public String getJobCategoryTextboxValue() {
        waitForElementVisible(driver, JobPU.JOB_CATEGORY_DROPDOWN_TEXTBOX);
        return getElementText(driver, JobPU.JOB_CATEGORY_DROPDOWN_TEXTBOX);
    }

    public String getEmploymentStatusTextboxValue() {
        waitForElementVisible(driver, JobPU.EMPLOYMENT_STATUS_DROPDOWN_TEXTBOX);
        return getElementText(driver, JobPU.EMPLOYMENT_STATUS_DROPDOWN_TEXTBOX);
    }

    public String getLocationTextboxValue() {
        waitForElementVisible(driver, JobPU.JOB_LOCATION_DROPDOWN_TEXTBOX);
        return getElementText(driver, JobPU.JOB_LOCATION_DROPDOWN_TEXTBOX);
    }
}
