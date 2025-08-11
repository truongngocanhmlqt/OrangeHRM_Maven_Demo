package PageObjects;

import Commons.BasePages;
import PageObjects.pim.employee.EmployeeListPO;
import PageUIs.DashboardPU;
import org.openqa.selenium.WebDriver;

public class DashboardPO extends BasePages {
    private WebDriver driver;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }


    public EmployeeListPO clickToPIMPage() {
        waitForElementClickable(driver, DashboardPU.PIM_LINK);
        clickToElement(driver, DashboardPU.PIM_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmployeeListPage(driver);
    }
}
