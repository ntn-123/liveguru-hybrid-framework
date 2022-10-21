package pageObjectsUser;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIsUser.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
    private WebDriver driver;

    public UserRegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sendkeyToTextboxByIDAtRegisterPage(String textboxID, String textValue) {
        waitForElementVisible(driver, UserRegisterPageUI.TEXTBOX_BY_ID, textboxID);
        sendKeyToElement(driver, UserRegisterPageUI.TEXTBOX_BY_ID, textValue, textboxID);
    }

    public UserMyDashboardPageObject clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver,  UserRegisterPageUI.REGISTER_BUTTON);
        return PageGeneratorManager.getUserMyDashboardPage(driver);
    }
}
