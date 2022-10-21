package pageObjectsUser;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIsUser.UserCheckoutCartPageUI;

public class UserCheckoutCartPageObject extends BasePage {
    private WebDriver driver;
    public UserCheckoutCartPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public String getAddedToCartSuccessMessage() {
        waitForElementVisible(driver, UserCheckoutCartPageUI.ADDED_TO_CART_SUCCESS_MESSAGE);
        return getElementText(driver, UserCheckoutCartPageUI.ADDED_TO_CART_SUCCESS_MESSAGE);
    }
    public void sendkeyToTextboxByID(String idTextbox, String itemvalue) {
        waitForElementVisible(driver, UserCheckoutCartPageUI.TEXTBOX_BY_ID, idTextbox);
        sendKeyToElement(driver, UserCheckoutCartPageUI.TEXTBOX_BY_ID, itemvalue, idTextbox);
    }
    public void clickToApplyButton() {
        waitForElementClickable(driver, UserCheckoutCartPageUI.APPLY_BUTTON);
        clickToElement(driver, UserCheckoutCartPageUI.APPLY_BUTTON);
    }

    public String getDiscountPrice() {
        waitForElementVisible(driver, UserCheckoutCartPageUI.DISCOUNT_PRICE_TEXT);
        return getElementText(driver, UserCheckoutCartPageUI.DISCOUNT_PRICE_TEXT);
    }

    public String getGrandTotalPrice() {
        waitForElementVisible(driver, UserCheckoutCartPageUI.GRAND_TOTAL_TEXT);
        return getElementText(driver, UserCheckoutCartPageUI.GRAND_TOTAL_TEXT);
    }

    public void sendkeyToQTYTextbox(String productQty) {
        waitForElementVisible(driver, UserCheckoutCartPageUI.QTY_TEXTBOX);
        sendKeyToElement(driver, UserCheckoutCartPageUI.QTY_TEXTBOX, productQty);
    }

    public void clickToUpdateButton() {
        waitForElementClickable(driver, UserCheckoutCartPageUI.UPDATE_BUTTON);
        clickToElement(driver, UserCheckoutCartPageUI.UPDATE_BUTTON);
    }

    public boolean isQtyErrorMessageDisplayed(String errorMessage) {
        waitForElementVisible(driver, UserCheckoutCartPageUI.QTY_ERROR_MESSAGE, errorMessage);
        return isElementDisplayed(driver, UserCheckoutCartPageUI.QTY_ERROR_MESSAGE, errorMessage);
    }

    public boolean isQtyItemErrorMessageDisplayed(String errorMessage) {
        waitForElementVisible(driver, UserCheckoutCartPageUI.QTY_ITEM_ERROR_MESSAGE, errorMessage);
        return isElementDisplayed(driver, UserCheckoutCartPageUI.QTY_ITEM_ERROR_MESSAGE, errorMessage);
    }

    public void clickToEmptyCartButton() {
        waitForElementClickable(driver, UserCheckoutCartPageUI.EMPTY_CART_BUTTON);
        clickToElement(driver, UserCheckoutCartPageUI.EMPTY_CART_BUTTON);
    }

    public boolean isCartEmptyTitleMessageDisplayed(String message) {
        waitForElementVisible(driver, UserCheckoutCartPageUI.CART_EMPTY_TITLE_MESSAGE, message);
        return isElementDisplayed(driver, UserCheckoutCartPageUI.CART_EMPTY_TITLE_MESSAGE, message);
    }

    public boolean isCartEmptyContentMessageDisplayed(String message) {
        waitForElementVisible(driver, UserCheckoutCartPageUI.CART_EMPTY_CONTENT_MESSAGE, message);
        return isElementDisplayed(driver, UserCheckoutCartPageUI.CART_EMPTY_CONTENT_MESSAGE, message);
    }

    public void selectItemInDropdownByID(String dropdownId, String itemValue) {
        waitForElementVisible(driver, UserCheckoutCartPageUI.DROPDOWN_BY_ID, dropdownId);
        selectItemInDefaultDropdown(driver, UserCheckoutCartPageUI.DROPDOWN_BY_ID, itemValue, dropdownId);
    }

    public void clickToEstimateButton() {
        waitForElementClickable(driver, UserCheckoutCartPageUI.ESTIMATE_BUTTON);
        clickToElement(driver, UserCheckoutCartPageUI.ESTIMATE_BUTTON);
    }

    public String getFlatRatePriceText() {
        waitForElementClickable(driver, UserCheckoutCartPageUI.FLAT_RATE_COST_TEXT);
        return getElementText(driver, UserCheckoutCartPageUI.FLAT_RATE_COST_TEXT);
    }

    public void checkToFlatRateRadioButton() {
        waitForElementClickable(driver, UserCheckoutCartPageUI.FLAT_RATE_RADIO_BUTTON);
        checkToDefaultCheckboxOrRadio(driver, UserCheckoutCartPageUI.FLAT_RATE_RADIO_BUTTON);
    }

    public void clickToUpdateTotalButton() {
        waitForElementClickable(driver, UserCheckoutCartPageUI.UPDATE_TOTAL_BUTTON);
        clickToElement(driver, UserCheckoutCartPageUI.UPDATE_TOTAL_BUTTON);
    }

    public UserCheckoutOnepagePageObject clickToProceedToCheckoutButton() {
        waitForElementClickable(driver, UserCheckoutCartPageUI.PROCEED_TO_CHECKOUT_BUTTON);
        clickToElement(driver, UserCheckoutCartPageUI.PROCEED_TO_CHECKOUT_BUTTON);
        return PageGeneratorManager.getUserCheckoutOnepagePage(driver);
    }


}
