package pageObjectsUser;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIsUser.UserMyWishlistPageUI;

public class UserMyWishlistPageObject extends BasePage {
    private WebDriver driver;

    public UserMyWishlistPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public String getAddedToWishlistSuccessMessage(String attributeValue) {
        waitForElementVisible(driver, UserMyWishlistPageUI.ADDED_TO_WISHLIST_SUCCESS_MESSAGE);
        return getElementAttribute(driver, UserMyWishlistPageUI.ADDED_TO_WISHLIST_SUCCESS_MESSAGE, attributeValue);
    }

    public UserShareWishlistPageObject clickToShareWishlistButtonAtMyWishlistPage() {
        waitForElementClickable(driver, UserMyWishlistPageUI.SHARE_WISHLIST_BUTTON);
        clickToElement(driver, UserMyWishlistPageUI.SHARE_WISHLIST_BUTTON);
        return PageGeneratorManager.getUserShareWishlistPage(driver);
    }

    public boolean isShareWishlistSuccessMessageDisplayed(String message) {
        waitForElementVisible(driver, UserMyWishlistPageUI.SHARED_WISHLIST_SUCCESS_MESSAGE, message);
        return isElementDisplayed(driver, UserMyWishlistPageUI.SHARED_WISHLIST_SUCCESS_MESSAGE, message);
    }

    public String getAllWishlistItems() {
        waitForElementVisible(driver, UserMyWishlistPageUI.WISHLIST_ITEM_NAME_TEXT);
        return String.valueOf(getElementsSize(driver, UserMyWishlistPageUI.WISHLIST_ITEM_NAME_TEXT));
    }

    public String getWishlistItemName() {
        waitForElementVisible(driver, UserMyWishlistPageUI.WISHLIST_ITEM_NAME_TEXT);
        return getElementText(driver, UserMyWishlistPageUI.WISHLIST_ITEM_NAME_TEXT);
    }

    public UserCheckoutCartPageObject clickToAddToCartButton() {
        waitForElementClickable(driver, UserMyWishlistPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, UserMyWishlistPageUI.ADD_TO_CART_BUTTON);
        return PageGeneratorManager.getUserCheckoutCartPage(driver);
    }
}
