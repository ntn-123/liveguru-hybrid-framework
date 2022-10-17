package pageObjects;

import commons.BasePage;
import commons.BasePageUI;
import org.openqa.selenium.WebDriver;
import pageUIs.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
    private WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sendkeyToTextboxByIDAtLoginPage(String attributeId, String textValue) {
        waitForElementVisible(driver, UserLoginPageUI.TEXTBOX_BY_ID_AT_LOGIN_PAGE, attributeId);
        sendKeyToElement(driver, UserLoginPageUI.TEXTBOX_BY_ID_AT_LOGIN_PAGE, textValue, attributeId);
    }

    public UserMyDashboardPageObject clickToLoginButton() {
        waitForElementVisible(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getUserMyDashboardPage(driver);
    }
}
