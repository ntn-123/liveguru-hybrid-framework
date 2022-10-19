package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserCheckoutCartPageUI;
import pageUIs.UserHomePageUI;
import pageUIs.UserMobilePageUI;

public class UserCheckoutCartPageObject extends BasePage {
    private WebDriver driver;
    public UserCheckoutCartPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public String getAddedToCartSuccessMessage() {
        waitForElementVisible(driver, UserCheckoutCartPageUI.ADDED_TO_CART_SUCCESS_MESSAGE);
        return getElementText(driver, UserCheckoutCartPageUI.ADDED_TO_CART_SUCCESS_MESSAGE);
    }
    public void sendkeyToDiscountCodesTextbox(String couponCode) {
        waitForElementVisible(driver, UserCheckoutCartPageUI.DISCOUNT_CODES_TEXTBOX);
        sendKeyToElement(driver, UserCheckoutCartPageUI.DISCOUNT_CODES_TEXTBOX, couponCode);
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
}
