package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserHomePageUI;
import pageUIs.UserMyDashboardPageUI;

public class UserMyDashboardPageObject extends BasePage {
    private WebDriver driver;

    public UserMyDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, UserMyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, UserMyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
    }
}
