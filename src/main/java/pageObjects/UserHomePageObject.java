package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserHomePageUI;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToHearderAccountLink() {
        waitForElementVisible(driver, UserHomePageUI.HEARDER_ACCOUNT_LINK);
       clickToElement(driver, UserHomePageUI.HEARDER_ACCOUNT_LINK);
    }

    public UserRegisterPageObject clickToHearderAccountRegisterLink() {
        waitForElementClickable(driver, UserHomePageUI.HEARDER_ACCOUNT_REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.HEARDER_ACCOUNT_REGISTER_LINK);
        return PageGeneratorManager.getUserRegisterPage(driver);
    }
}
