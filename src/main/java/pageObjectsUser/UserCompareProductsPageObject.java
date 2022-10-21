package pageObjectsUser;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIsUser.UserCompareProductsPageUI;

public class UserCompareProductsPageObject extends BasePage {
    private WebDriver driver;

    public UserCompareProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCompareProductsTitleDisplayed() {
        waitForElementVisible(driver, UserCompareProductsPageUI.COMPARE_PRODUCTS_TITLE);
        return isElementDisplayed(driver, UserCompareProductsPageUI.COMPARE_PRODUCTS_TITLE);
    }

    public boolean isMobileNameDisplayed(String mobileName) {
        waitForElementVisible(driver, UserCompareProductsPageUI.MOBILE_NAME_TEXT, mobileName);
        return isElementDisplayed(driver, UserCompareProductsPageUI.MOBILE_NAME_TEXT, mobileName);
    }

    public boolean isMobilePriceByMobileNameDisplayed(String mobileName, String price) {
        waitForElementVisible(driver, UserCompareProductsPageUI.MOBILE_PRICE_TEXT_BY_MOBILE_NAME, mobileName, price);
        return isElementDisplayed(driver, UserCompareProductsPageUI.MOBILE_PRICE_TEXT_BY_MOBILE_NAME, mobileName, price);
    }

    public boolean isMobileImageByMobileNameDisplayed(String mobileName, String imageName) {
        waitForElementVisible(driver, UserCompareProductsPageUI.MOBILE_IMAGE_TEXT_BY_MOBILE_NAME, mobileName, imageName);
        return isElementDisplayed(driver, UserCompareProductsPageUI.MOBILE_IMAGE_TEXT_BY_MOBILE_NAME, mobileName, imageName);
    }

    public boolean isMobileSkuByMobileNameDisplayed(String sku) {
        waitForElementVisible(driver, UserCompareProductsPageUI.MOBILE_SKU_TEXT, sku);
        return isElementDisplayed(driver, UserCompareProductsPageUI.MOBILE_SKU_TEXT, sku);
    }

    public UserMobilePageObject closeWindowCompareProducts(String parentWindowId) {
        closeAllTabWithoutParent(driver, parentWindowId);
        return PageGeneratorManager.getUserMobilePage(driver);
    }
}
