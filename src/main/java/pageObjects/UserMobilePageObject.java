package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserMobilePageUI;

public class UserMobilePageObject extends BasePage {
    private WebDriver driver;
    public UserMobilePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public String getMobileCostByMobileNameAtMobileList(String mobileName) {
        waitForElementVisible(driver, UserMobilePageUI.MOBILE_COST_BY_MOBILE_NAME, mobileName);
        return getElementText(driver, UserMobilePageUI.MOBILE_COST_BY_MOBILE_NAME, mobileName);
    }

    public UserMobileDetailPageObject clickToMobileNameTitle(String mobileName) {
        waitForElementVisible(driver, UserMobilePageUI.MOBILE_NAME_TITLE, mobileName);
        clickToElement(driver, UserMobilePageUI.MOBILE_NAME_TITLE, mobileName);
        return PageGeneratorManager.getUserMobileDetailPage(driver);
    }

    public UserCheckoutCartPageObject clickToAddToCartButtonAtMobileList(String mobileName) {
        waitForElementVisible(driver, UserMobilePageUI.ADD_TO_CART_BUTTON_BY_MOBILE_NAME, mobileName);
        clickToElement(driver, UserMobilePageUI.ADD_TO_CART_BUTTON_BY_MOBILE_NAME, mobileName);
        return PageGeneratorManager.getUserCheckoutCartPage(driver);
    }
}
