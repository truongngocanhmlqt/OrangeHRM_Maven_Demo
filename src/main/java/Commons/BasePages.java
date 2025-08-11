package Commons;

import PageUIs.BasePagePU;
import PageUIs.pim.employee.employeeTabs.EmergencyContactsPU;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePages {

    //tuan theo nguyen tac cua tinh dong goi (encapsulation)
    //ham static co the truy cap truc tiep tu pham vi class

    public static BasePages getBasePages() {
        return new BasePages();
    }

    public void openPageURL(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }
//Alert

    public Alert waitAlertPresent(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.SHORT_TIME))
                .until(ExpectedConditions.alertIsPresent());

    }

    public void acceptAlert(WebDriver driver) {
        waitAlertPresent(driver).accept();

    }

    public void cancelAlert(WebDriver driver) {
        waitAlertPresent(driver).dismiss();
    }

    public String getTextAlert(WebDriver driver, String keysToSend) {
        return waitAlertPresent(driver).getText();
    }

    public void sendKeyAlert(WebDriver driver, String keysToSend) {
        waitAlertPresent(driver).sendKeys(keysToSend);
    }
//Window:
    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }
//element//

    protected WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));

    }
    protected List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));

    }
    protected List<WebElement> getListElement(WebDriver driver, String locator, String... restParameter) {
        return driver.findElements(getByLocator(castParameter(locator, restParameter)));

    }
    private String castParameter(String locator, String... restParameter) {
        return String.format(locator, (Object[]) restParameter);
    }

    private By getByLocator(String prefixLocator) {
        By by = null;
        if (prefixLocator.startsWith("id") || prefixLocator.startsWith("ID") || prefixLocator.startsWith("Id")) {
            by = By.id(prefixLocator.substring(3));
        } else if (prefixLocator.startsWith("class") || prefixLocator.startsWith("Class") || prefixLocator.startsWith("CLASS")) {
            by = By.className(prefixLocator.substring(6));
        } else if (prefixLocator.startsWith("name") || prefixLocator.startsWith("Name") || prefixLocator.startsWith("NAME")) {
            by = By.name(prefixLocator.substring(5));
        }else if (prefixLocator.startsWith("tagname") || prefixLocator.startsWith("TagName") || prefixLocator.startsWith("Tagname")) {
            by = By.tagName(prefixLocator.substring(8));
        }else if (prefixLocator.startsWith("css") || prefixLocator.startsWith("CSS") || prefixLocator.startsWith("Css")) {
            by = By.cssSelector(prefixLocator.substring(4));
        }else if (prefixLocator.startsWith("xpath") || prefixLocator.startsWith("Xpath") || prefixLocator.startsWith("XPath")) {
            by = By.xpath(prefixLocator.substring(6));
        } else {
            throw new RuntimeException("Locator type is not support!");
        }
        return by;
    }

    private By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }
    public void clickToElement(WebDriver driver, String locator, String... resParameter) {
        getElement(driver, castParameter(locator, resParameter)).click();
    }
    public Set<Cookie> getAllCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public void setCookies(WebDriver driver, Set<Cookie> cookies ) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        sleepInSecond(3);
    }

    public void sendKeyToElement(WebDriver driver, String locator, String keysToSend) {
        //getElement(driver,locator).clear();
        getElement(driver,locator).sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
        sleepInSecond(1);
        getElement(driver, locator).sendKeys(keysToSend);
    }

    public void sendKeyToElement(WebDriver driver, String locator, String valueToSendKey, String... resParameter) {
        getElement(driver,castParameter(locator, resParameter)).sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
        sleepInSecond(1);
        getElement(driver, castParameter(locator, resParameter)).sendKeys(valueToSendKey);
    }

    public void selectItemDropdown(WebDriver driver, String locator, String text ) {
        new Select(getElement(driver, locator)).selectByVisibleText(text);
    }

    public void selectItemDropdown(WebDriver driver, String locator, String text, String... resParameter) {
        new Select(getElement(driver, castParameter(locator,resParameter))).selectByVisibleText(text);
    }


    public String getSelectItemInDropDown(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSecond(1);
        List<WebElement> allItems = new WebDriverWait(driver,Duration.ofSeconds(GlobalConstant.SHORT_TIME))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

        sleepInSecond(1);
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }
    }

    public void sleepInSecond(long timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getElementAttribute(WebDriver driver, String locator, String name) {
        return getElement(driver, locator).getAttribute(name);
    }
    public String getElementAttribute(WebDriver driver, String locator, String name, String... restParameter) {
        return getElement(driver, castParameter(locator,restParameter)).getAttribute(name);
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }
    public String getElementText(WebDriver driver, String locator, String restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).getText();
    }


    public String getElementCSSValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getCssValue(propertyName);
    }

    public String getHexColorRGVA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();

    }

    public int getListElementNumber(WebDriver driver, String locator) {
        return getListElement(driver,locator).size();

    }

    public void checkToCheckBoxRadio(WebDriver driver, String locator) {
        if (!getElement(driver,locator).isSelected()) {
            getElement(driver,locator).click();
        }
    }
    public void checkToCheckBoxRadio(WebDriver driver, String locator, String... restParameter) {
        if (!getElement(driver,castParameter(locator, restParameter)).isSelected()) {
            getElement(driver,castParameter(locator, restParameter)).click();
        }
    }


    public void unCheckToCheckBoxRadio(WebDriver driver, String locator) {
        if (getElement(driver,locator).isSelected()) {
            getElement(driver,locator).click();
        }
    }
    public void unCheckToCheckBoxRadio(WebDriver driver, String locator, String... restParameter) {
        if (getElement(driver,castParameter(locator,restParameter)).isSelected()) {
            getElement(driver,castParameter(locator,restParameter)).click();
        }
    }

    public boolean isElementDisplay(WebDriver driver, String locator) {
        return getElement(driver,locator).isDisplayed();
    }

    public boolean isElementDisplay(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver,castParameter(locator, restParameter)).isDisplayed();
    }
    public boolean isElementUnDisplay(WebDriver driver, String locator) {
        List<WebElement> elements = getListElement(driver,locator);
        sleepInSecond(2);
        if (elements.size() == 0) { //case: Un-visible and non-present
            return true;
        } else if (elements.size() >0 && !elements.get(0).isDisplayed()) { //present, un-visible
            return true;
        } else { //visible and present
            return false;
        }
    }
    public boolean isElementUnDisplay(WebDriver driver, String locator, String... restParameter) {
        List<WebElement> elements = getListElement(driver,castParameter(locator, restParameter));
        if (elements.size() == 0) { //case: Un-visible and non-present
            return true;
        } else if (elements.size() >0 && !elements.get(0).isDisplayed()) { //present, un-visible
            return true;
        } else { //visible and present
            return false;
        }
    }
    public boolean isElementEnable(WebDriver driver, String locator) {
        return getElement(driver,locator).isEnabled();
    }
    public boolean isElementEnable(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver,castParameter(locator, restParameter)).isEnabled();
    }
    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver,locator).isSelected();
    }


    public boolean isElementSelected(WebDriver driver,String locator, String... restParameter) {
        return getElement(driver,castParameter(locator, restParameter)).isSelected();
    }

    public void switchToIframe(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }

    public void switchToDefaultPage(WebDriver driver, String locator) {
        driver.switchTo().defaultContent();
    }

    public void hoverToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver,locator)).perform();
    }

    public void clickAndHoldToElement(WebDriver driver, String locator) {
        new Actions(driver).clickAndHold(getElement(driver,locator)).perform();
    }
    public void releaseLeftMouse(WebDriver driver) {
        new Actions(driver).release();
    }
    public void clickToElementByAction(WebDriver driver, String locator) {
        new Actions(driver).click(getElement(driver,locator)).perform();
    }
    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getElement(driver,locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver,locator)).perform();
    }

    public void dragAndDropClickToElement(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getElement(driver,sourceLocator),getElement(driver, targetLocator)).perform();
    }

    public void pressIntoToElement(WebDriver driver, String locator, Keys keys) {
        new Actions(driver).sendKeys(getElement(driver,locator), keys).perform();
    }
    public void pressIntoToElement(WebDriver driver, String locator, Keys keys, String... restParameter) {
        new Actions(driver).sendKeys(getElement(driver,castParameter(locator, restParameter)), keys).perform();
    }


    public void scrollToElement(WebDriver driver, String locator) {
        new Actions(driver).scrollToElement(getElement(driver, locator)).perform();
    }
//Java scripExecutor

    public void highLightElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator, String... restParameter) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, castParameter(locator,restParameter)));
        sleepInSecond(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public void sendKeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, locator));
    }

//Wait
    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.LONG_TIME))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }
    public void waitForElementVisible(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.LONG_TIME))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParameter(locator,restParameter))));
    }

    public void waitForElementSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.LONG_TIME))
                .until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }

    public void waitForElementSelected(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.LONG_TIME))
                .until(ExpectedConditions.elementToBeSelected(getByLocator(castParameter(locator,restParameter))));
    }

    public void waitForElementPresent(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.LONG_TIME))
                .until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementPresent(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.LONG_TIME))
                .until(ExpectedConditions.presenceOfElementLocated(getByLocator(castParameter(locator,restParameter))));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.LONG_TIME))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }
    public void waitForElementInvisible(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.LONG_TIME))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castParameter(locator, restParameter))));
    }

    public boolean waitForListElementInvisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.LONG_TIME))
                .until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver,locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.LONG_TIME))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));

    }
    public Dimension getElementSize(WebDriver driver, String locator) {
        return getElement(driver, locator).getSize();
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.LONG_TIME))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(castParameter(locator,restParameter))));
    }

    public void waitAllLoadingIconInvisible(WebDriver driver) {
        waitForListElementInvisible(driver, BasePagePU.LOADING_ICON);
    }

    public String getSuccesstext(WebDriver driver) {
        waitForElementVisible(driver, BasePagePU.SUCCESS_TEXT);
        return getElementText(driver, BasePagePU.SUCCESS_TEXT);
    }
    public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
        String filePath = GlobalConstant.UPLOAD_PATH;
        String fullFileName = "";
        for (String file: fileNames) {
            fullFileName += filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getElement(driver, BasePagePU.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
    }
    public void enterTextboxByText(WebDriver driver, String textName, String keyToSend) {
        waitForElementVisible(driver, BasePagePU.TEXTBOX_BY_TEXT, textName);
        sendKeyToElement(driver, BasePagePU.TEXTBOX_BY_TEXT, keyToSend, textName);

    }

    public String getTextboxValueByText(WebDriver driver, String textName) {
        waitForElementVisible(driver, BasePagePU.TEXTBOX_BY_TEXT, textName);
        return getElementAttribute(driver, BasePagePU.TEXTBOX_BY_TEXT, "value", textName);
    }
    public void clickToDynamicDeleteIcon(WebDriver driver, String inDex) {
        waitForElementClickable(driver, BasePagePU.DYNAMIC_DELETE_DATA_BUTTON_BY_INDEX, inDex);
        clickToElement(driver, BasePagePU.DYNAMIC_DELETE_DATA_BUTTON_BY_INDEX, inDex);
    }
    public void clickToYesDeleteButton(WebDriver driver) {
        waitForElementClickable(driver, BasePagePU.YES_DELETE_BUTTON);
        clickToElement(driver,BasePagePU.YES_DELETE_BUTTON);
        sleepInSecond(1);
    }

}
