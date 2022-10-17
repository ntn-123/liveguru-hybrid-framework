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
}
