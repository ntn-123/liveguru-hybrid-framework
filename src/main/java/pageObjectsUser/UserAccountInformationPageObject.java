package pageObjectsUser;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIsUser.UserAccountInformationPageUI;

public class UserAccountInformationPageObject extends BasePage {
    private WebDriver driver;

    public UserAccountInformationPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getAttributeValueAtTextboxByIDAtAccountInformationPage(String attributeValue, String idValue) {
        waitForElementVisible(driver, UserAccountInformationPageUI.ACCOUNT_INFO_TEXTBOX_BY_ID, idValue);
        return getElementAttribute(driver, UserAccountInformationPageUI.ACCOUNT_INFO_TEXTBOX_BY_ID, attributeValue, idValue);
    }

    public void sendkeyToTextboxByID(String idValue, String textValue) {
        waitForElementVisible(driver, UserAccountInformationPageUI.ACCOUNT_INFO_TEXTBOX_BY_ID, idValue);
        sendKeyToElement(driver, UserAccountInformationPageUI.ACCOUNT_INFO_TEXTBOX_BY_ID, textValue, idValue);
    }

    public void checkToChangePasswordCheckbox() {
        waitForElementClickable(driver, UserAccountInformationPageUI.CHANGE_PASSWORD_CHECKBOX);
        checkToDefaultCheckboxOrRadio(driver, UserAccountInformationPageUI.CHANGE_PASSWORD_CHECKBOX);
    }

    public UserMyDashboardPageObject clickToSaveButton() {
        waitForElementClickable(driver, UserAccountInformationPageUI.SAVE_BUTTON);
        clickToElement(driver, UserAccountInformationPageUI.SAVE_BUTTON);
        return PageGeneratorManager.getUserMyDashboardPage(driver);
    }
}
