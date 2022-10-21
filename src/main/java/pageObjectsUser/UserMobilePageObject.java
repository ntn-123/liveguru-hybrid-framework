package pageObjectsUser;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIsUser.UserMobilePageUI;

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

    public void clickToAddToCompareLinkByMobileNameAtMobileList(String mobileName) {
        waitForElementVisible(driver, UserMobilePageUI.ADD_TO_COMPARE_LINK_BY_MOBILE_NAME, mobileName);
        clickToElement(driver, UserMobilePageUI.ADD_TO_COMPARE_LINK_BY_MOBILE_NAME, mobileName);
    }

    public boolean isAddedToCompareSuccessMessageDisplayed(String message) {
        waitForElementVisible(driver, UserMobilePageUI.ADDED_TO_COMPARE_SUCCESS_MESSAGE, message);
        return isElementDisplayed(driver, UserMobilePageUI.ADDED_TO_COMPARE_SUCCESS_MESSAGE, message);
    }

    public UserCompareProductsPageObject clickToCompareButton() {
        waitForElementVisible(driver, UserMobilePageUI.COMPARE_BUTTON);
        clickToElement(driver, UserMobilePageUI.COMPARE_BUTTON);
        switchToWindowByTitle(driver, "Products Comparison List - Magento Commerce");
        return PageGeneratorManager.getUserCompareProductsPage(driver);
    }
}
