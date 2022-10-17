package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserAccountInformationPageUI;

public class UserAccountInformationPageObject extends BasePage {
    private WebDriver driver;

    public UserAccountInformationPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getAttributeValueAtTextboxByIDAtAccountInformationPage(String attributeValue, String idValue) {
        waitForElementVisible(driver, UserAccountInformationPageUI.ACCOUNT_INFO_TEXTBOX_BY_ID, idValue);
        return getElementAttribute(driver, UserAccountInformationPageUI.ACCOUNT_INFO_TEXTBOX_BY_ID, attributeValue, idValue);
    }
}
