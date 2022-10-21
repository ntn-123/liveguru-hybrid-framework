package pageObjectsUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsUser.UserMyDashboardPageUI;

public class UserMyDashboardPageObject extends BasePage {
    private WebDriver driver;

    public UserMyDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, UserMyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, UserMyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public String getMyDashboardTitle() {
        waitForElementVisible(driver, UserMyDashboardPageUI.MY_DASHBOARD_TITLE);
        return getElementText(driver, UserMyDashboardPageUI.MY_DASHBOARD_TITLE);
    }

    public String getAccountNameText() {
        waitForElementVisible(driver, UserMyDashboardPageUI.ACCOUNT_NAME_TEXT);
        return getElementText(driver, UserMyDashboardPageUI.ACCOUNT_NAME_TEXT);
    }
}
