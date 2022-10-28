package pageObjectsAdmin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIsAdmin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    private WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sendkeyToUserNameTextbox(String userName){
        waitForElementVisible(driver, AdminLoginPageUI.USER_NAME_TEXTBOX);
        sendKeyToElement(driver, AdminLoginPageUI.USER_NAME_TEXTBOX, userName);
    }

    public void sendkeyToPasswordTextbox(String password){
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton(){
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
    }

    public AdminManageCustomerPageObject adminLoginToSystem(String userName, String password){
        sendkeyToUserNameTextbox(userName);
        sendkeyToPasswordTextbox(password);
        clickToLoginButton();
        return PageGeneratorManager.getAdminManageCustomerPage(driver);
    }
}
