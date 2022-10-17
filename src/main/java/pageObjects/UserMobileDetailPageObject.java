package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserHomePageUI;
import pageUIs.UserMobileDetailPageUI;
import pageUIs.UserMobilePageUI;

public class UserMobileDetailPageObject extends BasePage {
    private WebDriver driver;

    public UserMobileDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public String getMobileCostByMobileNameAtDetailPage(String mobileName) {
        waitForElementVisible(driver, UserMobileDetailPageUI.MOBILE_COST_BY_MOBILE_NAME, mobileName);
        return getElementText(driver, UserMobileDetailPageUI.MOBILE_COST_BY_MOBILE_NAME, mobileName);
    }
}
