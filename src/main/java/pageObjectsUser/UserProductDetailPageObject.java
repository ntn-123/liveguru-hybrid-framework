package pageObjectsUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsUser.UserProductDetailPageUI;

public class UserProductDetailPageObject extends BasePage {
    private WebDriver driver;

    public UserProductDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public String getProductCostByProductNameAtDetailPage(String productName) {
        waitForElementVisible(driver, UserProductDetailPageUI.PRODUCT_COST_BY_PRODUCT_NAME, productName);
        return getElementText(driver, UserProductDetailPageUI.PRODUCT_COST_BY_PRODUCT_NAME, productName);
    }

    public void clickToAddYourReviewLink() {
        waitForElementClickable(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
    }

    public void clickToSubmitReviewButton() {
        waitForElementClickable(driver, UserProductDetailPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, UserProductDetailPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public String getErrorMessageReviewAtInputFieldByID(String idValue) {
        waitForElementVisible(driver, UserProductDetailPageUI.ERROR_MESSAGE_REVIEW_AT_INPUT_FIELD_BY_ID, idValue);
        return getElementText(driver, UserProductDetailPageUI.ERROR_MESSAGE_REVIEW_AT_INPUT_FIELD_BY_ID, idValue);
    }

    public void checkToRateRadioButtonByID(String rateId) {
        waitForElementClickable(driver, UserProductDetailPageUI.RATE_RADIO_BUTTON, rateId);
        checkToDefaultCheckboxOrRadio(driver, UserProductDetailPageUI.RATE_RADIO_BUTTON, rateId);
    }

    public void sendkeyToReviewFieldTextarea(String reviewText) {
        waitForElementVisible(driver, UserProductDetailPageUI.REVIEW_TEXTAREA);
        sendKeyToElement(driver, UserProductDetailPageUI.REVIEW_TEXTAREA, reviewText);
    }

    public void sendkeyToSummaryFieldTextbox(String sumaryText) {
        waitForElementVisible(driver, UserProductDetailPageUI.SUMMARY_TEXTBOX);
        sendKeyToElement(driver, UserProductDetailPageUI.SUMMARY_TEXTBOX, sumaryText);
    }

    public void sendkeyToNicknameFieldTextbox(String nicknameText) {
        waitForElementVisible(driver, UserProductDetailPageUI.NICKNAME_TEXTBOX);
        sendKeyToElement(driver, UserProductDetailPageUI.NICKNAME_TEXTBOX, nicknameText);
    }

    public String getReviewedSuccessMessage() {
        waitForElementVisible(driver, UserProductDetailPageUI.REVIEWED_SUCCESS_MESSAGE);
        return getElementText(driver, UserProductDetailPageUI.REVIEWED_SUCCESS_MESSAGE);
    }

    public void clickToBottomTabByText(String tabValue) {
        waitForElementClickable(driver, UserProductDetailPageUI.BOTTOM_TAB_BY_TEXT, tabValue);
        clickToElement(driver, UserProductDetailPageUI.BOTTOM_TAB_BY_TEXT, tabValue);
    }
}
