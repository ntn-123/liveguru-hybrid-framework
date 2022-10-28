package pageObjectsUser;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIsUser.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
    private WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sendkeyToEmailAddressTextbox(String emailAddress) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
    }

    public void sendkeyToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public UserMyDashboardPageObject clickToLoginButton() {
        waitForElementVisible(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getUserMyDashboardPage(driver);
    }

    public UserMyDashboardPageObject userLoginToSystem(String emailAddress, String password){
        sendkeyToEmailAddressTextbox(emailAddress);
        sendkeyToPasswordTextbox(password);
        return clickToLoginButton();
    }
}
