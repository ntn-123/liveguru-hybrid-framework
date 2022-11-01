package pageObjectsAdmin;

import commons.BasePage;
import commons.BasePageUI;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIsAdmin.AdminLoginPageUI;
import pageUIsAdmin.AdminManageCustomerPageUI;
import pageUIsAdmin.AdminOrdersPageUI;

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
}
