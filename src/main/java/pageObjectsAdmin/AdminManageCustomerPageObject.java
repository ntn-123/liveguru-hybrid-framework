package pageObjectsAdmin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsAdmin.AdminManageCustomerPageUI;

public class AdminManageCustomerPageObject extends BasePage {
    private WebDriver driver;

    public AdminManageCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCloseButtonAtMessagePopup(){
        waitForElementClickable(driver, AdminManageCustomerPageUI.CLOSE_BUTTON_AT_MESSAGE_POPUP);
        clickToElement(driver, AdminManageCustomerPageUI.CLOSE_BUTTON_AT_MESSAGE_POPUP);
    }

    public void sendkeyToSearchTextboxByName(String nameValue, String dataSearch){
        waitForElementVisible(driver, AdminManageCustomerPageUI.SEARCH_TEXTBOX_BY_NAME, nameValue);
        sendKeyToElement(driver, AdminManageCustomerPageUI.SEARCH_TEXTBOX_BY_NAME, dataSearch, nameValue);
    }

    public void clickToButtonByTitle(String titleValue){
        waitForElementClickable(driver, AdminManageCustomerPageUI.BUTTON_BY_TITLE, titleValue);
        clickToElement(driver, AdminManageCustomerPageUI.BUTTON_BY_TITLE, titleValue);
    }

    public boolean isTotalRecordsDisplayed(String textValue) {
        waitForElementVisible(driver, AdminManageCustomerPageUI.TOTAL_RECORDS_FOUND_TEXT);
        String totalText = getElementAttribute(driver, AdminManageCustomerPageUI.TOTAL_RECORDS_FOUND_TEXT, "innerText");
        if (totalText.contains(textValue)){
            return true;
        } else {
            return false;
        }
    }

    public String getRowValueByColumnName(String columnName) {
        int columnIndex = getElementsSize(driver, AdminManageCustomerPageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        waitForElementVisible(driver, AdminManageCustomerPageUI.ROW_VALUE_BY_COLUMN_INDEX, String.valueOf(columnIndex));
        return getElementText(driver, AdminManageCustomerPageUI.ROW_VALUE_BY_COLUMN_INDEX, String.valueOf(columnIndex)).trim();
    }

    public void checkToCheckboxAtCustomerRow() {
        waitForElementClickable(driver, AdminManageCustomerPageUI.CHECKBOX_AT_CUSTOMER_ROW);
        hoverMouseToElement(driver, AdminManageCustomerPageUI.CHECKBOX_AT_CUSTOMER_ROW);
        checkToDefaultCheckboxOrRadio(driver, AdminManageCustomerPageUI.CHECKBOX_AT_CUSTOMER_ROW);
    }

    public void selectItemInDropdownByID(String idValue, String itemValue) {
        waitForElementClickable(driver, AdminManageCustomerPageUI.DROPDOWN_BY_ID, idValue);
        selectItemInDefaultDropdown(driver, AdminManageCustomerPageUI.DROPDOWN_BY_ID, itemValue, idValue);
    }

    public String getSuccessMessage() {
        waitForElementVisible(driver, AdminManageCustomerPageUI.SUCCESS_MESSAGE);
        return getElementText(driver, AdminManageCustomerPageUI.SUCCESS_MESSAGE);
    }

    public String getNoRecordsFoundMessage() {
        waitForElementVisible(driver, AdminManageCustomerPageUI.NO_RECORDS_FOUND_MESSAGE);
        return getElementText(driver, AdminManageCustomerPageUI.NO_RECORDS_FOUND_MESSAGE);
    }

}
