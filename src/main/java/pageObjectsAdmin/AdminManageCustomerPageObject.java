package pageObjectsAdmin;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIsAdmin.AdminManageCustomerPageUI;

import java.util.ArrayList;
import java.util.List;

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

    public boolean isTableDisplayedMatchingWithDataSearchByColumn(String columnName, String dataSearch, String textboxName) {
        int columnIndex = getElementsSize(driver, AdminManageCustomerPageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        waitForAllElementsVisible(driver, AdminManageCustomerPageUI.ROW_VALUE_BY_COLUMN_INDEX, String.valueOf(columnIndex));
        List<WebElement> allRowByColumn = getListWebElement(driver, AdminManageCustomerPageUI.ROW_VALUE_BY_COLUMN_INDEX, String.valueOf(columnIndex));
        ArrayList<String> allRowValueByColumn = new ArrayList<>();
        for (WebElement row : allRowByColumn){
            allRowValueByColumn.add(row.getText());
        }
        if(columnName == "ID"){
            if (textboxName == "entity_id[from]"){
                for (int i = 0; i < allRowValueByColumn.size(); i++){
                    if (Integer.parseInt(allRowValueByColumn.get(i).trim()) <= Integer.parseInt(dataSearch)) return true;
                }
            } else if (textboxName == "entity_id[to]"){
                for (int i = 0; i < allRowValueByColumn.size(); i++){
                    if (Integer.parseInt(allRowValueByColumn.get(i).trim()) >= Integer.parseInt(dataSearch)) return true;
                }
            }
            return false;

        } else {
            for (int i = 0; i < allRowValueByColumn.size(); i++){
                if (allRowValueByColumn.get(i).trim().equals(dataSearch)) return true;
            }
            return false;
        }

    }
}
