package pageObjectsUser;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIsUser.UserHomePageUI;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPageObject clickToHearderAccountRegisterLink() {
        waitForElementClickable(driver, UserHomePageUI.HEARDER_ACCOUNT_REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.HEARDER_ACCOUNT_REGISTER_LINK);
        return PageGeneratorManager.getUserRegisterPage(driver);
    }


}
