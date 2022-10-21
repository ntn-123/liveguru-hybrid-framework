package pageObjectsUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsUser.UserTVDetailPageUI;

public class UserTVDetailPageObject extends BasePage {
    private WebDriver driver;

    public UserTVDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAddYourReviewLink() {
        waitForElementClickable(driver, UserTVDetailPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, UserTVDetailPageUI.ADD_YOUR_REVIEW_LINK);
    }

    public void clickToSubmitReviewButton() {
        waitForElementClickable(driver, UserTVDetailPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, UserTVDetailPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public String getErrorMessageReviewAtInputFieldByID(String idValue) {
        waitForElementVisible(driver, UserTVDetailPageUI.ERROR_MESSAGE_REVIEW_AT_INPUT_FIELD_BY_ID, idValue);
        return getElementText(driver, UserTVDetailPageUI.ERROR_MESSAGE_REVIEW_AT_INPUT_FIELD_BY_ID, idValue);
    }

    public void checkToRateRadioButtonByID(String rateId) {
        waitForElementClickable(driver, UserTVDetailPageUI.RATE_RADIO_BUTTON, rateId);
        checkToDefaultCheckboxOrRadio(driver, UserTVDetailPageUI.RATE_RADIO_BUTTON, rateId);
    }

    public void sendkeyToReviewFieldTextarea(String reviewText) {
        waitForElementVisible(driver, UserTVDetailPageUI.REVIEW_TEXTAREA);
        sendKeyToElement(driver, UserTVDetailPageUI.REVIEW_TEXTAREA, reviewText);
    }

    public void sendkeyToSummaryFieldTextbox(String sumaryText) {
        waitForElementVisible(driver, UserTVDetailPageUI.SUMMARY_TEXTBOX);
        sendKeyToElement(driver, UserTVDetailPageUI.SUMMARY_TEXTBOX, sumaryText);
    }

    public void sendkeyToNicknameFieldTextbox(String nicknameText) {
        waitForElementVisible(driver, UserTVDetailPageUI.NICKNAME_TEXTBOX);
        sendKeyToElement(driver, UserTVDetailPageUI.NICKNAME_TEXTBOX, nicknameText);
    }

    public String getReviewedSuccessMessage() {
        waitForElementVisible(driver, UserTVDetailPageUI.REVIEWED_SUCCESS_MESSAGE);
        return getElementText(driver, UserTVDetailPageUI.REVIEWED_SUCCESS_MESSAGE);
    }
}
