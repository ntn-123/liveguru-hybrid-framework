package pageObjectsAdmin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIsAdmin.AdminOrdersPageUI;

import java.util.List;

public class AdminOrdersPageObject extends BasePage {
    private WebDriver driver;

    public AdminOrdersPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItemInStatusDropdown(String itemValue) {
        waitForElementVisible(driver, AdminOrdersPageUI.STATUS_DROPDOWN);
        selectItemInDefaultDropdown(driver, AdminOrdersPageUI.STATUS_DROPDOWN, itemValue);
    }

    public void clickToButtonByTitle(String titleValue){
        waitForElementClickable(driver, AdminOrdersPageUI.BUTTON_BY_TITLE, titleValue);
        clickToElement(driver, AdminOrdersPageUI.BUTTON_BY_TITLE, titleValue);
    }

    public void checkToCheckboxByRowNumber(String rowNumber) {
        waitForElementClickable(driver, AdminOrdersPageUI.CHECKBOX_BY_ROW_NUMBER, rowNumber);
        checkToDefaultCheckboxOrRadio(driver, AdminOrdersPageUI.CHECKBOX_BY_ROW_NUMBER, rowNumber);
    }

    public void selectItemInActionsDropdown(String itemValue) {
        waitForElementVisible(driver, AdminOrdersPageUI.ACTIONS_DROPDOWN);
        selectItemInDefaultDropdown(driver, AdminOrdersPageUI.ACTIONS_DROPDOWN, itemValue);
    }

    public String getErrorMessage() {
        waitForElementVisible(driver, AdminOrdersPageUI.ERROR_MESSAGE);
        return getElementText(driver, AdminOrdersPageUI.ERROR_MESSAGE);
    }

    public void selectItemInPaginationDropdown(String itemValue) {
        waitForElementVisible(driver, AdminOrdersPageUI.PAGINATION_DROPDOWN);
        selectItemInDefaultDropdown(driver, AdminOrdersPageUI.PAGINATION_DROPDOWN, itemValue);
    }

    public int getRowInTable() {
        waitForAllElementsVisible(driver, AdminOrdersPageUI.ROWS_IN_TABLE);
        return getElementsSize(driver, AdminOrdersPageUI.ROWS_IN_TABLE);
    }

    public void clickToLinkByText(String textValue) {
        waitForElementClickable(driver, AdminOrdersPageUI.LINK_BY_TEXT, textValue);
        clickToElement(driver, AdminOrdersPageUI.LINK_BY_TEXT, textValue);
    }

    public boolean isAllCheckboxesSelectedInTableDisplayed() {
        waitForAllElementsVisible(driver, AdminOrdersPageUI.ALL_CHECKBOXES_IN_TABLE);
        List<WebElement> allCheckboxes = getListWebElement(driver, AdminOrdersPageUI.ALL_CHECKBOXES_IN_TABLE);
        for (WebElement checkbox : allCheckboxes){
            if (checkbox.isSelected()) return true;
        }
        return false;
    }

    public boolean isAllCheckboxesUnselectedInTableDisplayed() {
        waitForAllElementsVisible(driver, AdminOrdersPageUI.ALL_CHECKBOXES_IN_TABLE);
        List<WebElement> allCheckboxes = getListWebElement(driver, AdminOrdersPageUI.ALL_CHECKBOXES_IN_TABLE);
        for (WebElement checkbox : allCheckboxes){
            if (!checkbox.isSelected()) return true;
        }
        return false;
    }
}
