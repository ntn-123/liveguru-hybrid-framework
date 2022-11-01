package pageObjectsUser;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIsUser.UserProductPageUI;

public class UserProductPageObject extends BasePage {
    private WebDriver driver;
    public UserProductPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public String getProductCostByProductName(String productName) {
        waitForElementVisible(driver, UserProductPageUI.PRODUCT_COST_BY_PRODUCT_NAME, productName);
        return getElementText(driver, UserProductPageUI.PRODUCT_COST_BY_PRODUCT_NAME, productName);
    }

    public UserProductDetailPageObject clickToProductNameTitle(String productName) {
        waitForElementVisible(driver, UserProductPageUI.PRODUCT_NAME_TITLE, productName);
        clickToElement(driver, UserProductPageUI.PRODUCT_NAME_TITLE, productName);
        return PageGeneratorManager.getUserProductDetailPage(driver);
    }

    public UserCheckoutCartPageObject clickToAddToCartButtonAtMobileList(String mobileName) {
        waitForElementVisible(driver, UserProductPageUI.ADD_TO_CART_BUTTON_BY_PRODUCT_NAME, mobileName);
        clickToElement(driver, UserProductPageUI.ADD_TO_CART_BUTTON_BY_PRODUCT_NAME, mobileName);
        return PageGeneratorManager.getUserCheckoutCartPage(driver);
    }

    public void clickToAddToCompareLinkByMobileNameAtMobileList(String mobileName) {
        waitForElementVisible(driver, UserProductPageUI.ADD_TO_COMPARE_LINK_BY_PRODUCT_NAME, mobileName);
        clickToElement(driver, UserProductPageUI.ADD_TO_COMPARE_LINK_BY_PRODUCT_NAME, mobileName);
    }

    public boolean isAddedToCompareSuccessMessageDisplayed(String message) {
        waitForElementVisible(driver, UserProductPageUI.ADDED_TO_COMPARE_SUCCESS_MESSAGE, message);
        return isElementDisplayed(driver, UserProductPageUI.ADDED_TO_COMPARE_SUCCESS_MESSAGE, message);
    }

    public UserCompareProductsPageObject clickToCompareButton() {
        waitForElementVisible(driver, UserProductPageUI.COMPARE_BUTTON);
        clickToElement(driver, UserProductPageUI.COMPARE_BUTTON);
        switchToWindowByTitle(driver, "Products Comparison List - Magento Commerce");
        return PageGeneratorManager.getUserCompareProductsPage(driver);
    }

    public UserMyWishlistPageObject clickToAddToWishlistLinkByProductName(String productName) {
        waitForElementVisible(driver, UserProductPageUI.ADD_TO_WISHLIST_LINK_BY_PRODUCT_NAME, productName);
        clickToElement(driver, UserProductPageUI.ADD_TO_WISHLIST_LINK_BY_PRODUCT_NAME, productName);
        return PageGeneratorManager.getUserMyWishlistPage(driver);
    }

}
