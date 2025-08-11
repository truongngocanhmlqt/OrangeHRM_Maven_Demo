package PageObjects.pim.employee.employeeTabs;

import Commons.BasePages;
import PageObjects.PageGenerator;
import PageUIs.pim.employee.employeeTabs.EmployeeTabsPU;
import org.openqa.selenium.WebDriver;

public class EmployeeTabsPO extends BasePages {
    private WebDriver driver;

    public EmployeeTabsPO(WebDriver driver) {
        this.driver = driver;
    }



    public PersonalDetailPO openPersonalDetailsPage() {
        waitForElementVisible(driver, EmployeeTabsPU.PERSONAL_DETAIL_LINK);
        clickToElement(driver, EmployeeTabsPU.PERSONAL_DETAIL_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailPage(driver);
    }
    public ContactDetailsPO openContactDetailsPage() {
        waitForElementVisible(driver, EmployeeTabsPU.CONTACT_DETAIL_LINK);
        clickToElement(driver, EmployeeTabsPU.CONTACT_DETAIL_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getContactDetailPage(driver);
    }
    public EmergencyContactsPO openEmergencyContactPage() {
        waitForElementVisible(driver, EmployeeTabsPU.EMERGENCY_CONTACTS_LINK);
        clickToElement(driver, EmployeeTabsPU.EMERGENCY_CONTACTS_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmergencyContactsPage(driver);
    }
    public DependentsPO openDependentsPage() {
        waitForElementVisible(driver, EmployeeTabsPU.DEPENDENTS_LINK);
        clickToElement(driver, EmployeeTabsPU.DEPENDENTS_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getDependentsPage(driver);
    }
    public ImmigrationPO openImmigrationPage() {
        waitForElementVisible(driver, EmployeeTabsPU.IMMIGRATION_LINK);
        clickToElement(driver, EmployeeTabsPU.IMMIGRATION_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getImmigrationPage(driver);
    }
    public JobPO openJobDetailsPage() {
        waitForElementVisible(driver, EmployeeTabsPU.JOB_LINK);
        clickToElement(driver, EmployeeTabsPU.JOB_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getJobPage(driver);
    }
    public SalaryPO openSalaryPage() {
        waitForElementVisible(driver, EmployeeTabsPU.SALARY_LINK);
        clickToElement(driver, EmployeeTabsPU.SALARY_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getSalaryPage(driver);
    }
    public ReportToPO openReportToPage() {
        waitForElementVisible(driver, EmployeeTabsPU.REPORT_TO_LINK);
        clickToElement(driver, EmployeeTabsPU.REPORT_TO_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getReportToPage(driver);
    }




}

