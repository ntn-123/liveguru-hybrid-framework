package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserMyWishlistPageUI;

public class UserMyWishlistPageObject extends BasePage {
    private WebDriver driver;

    public UserMyWishlistPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isAddedToWishlistSuccessMessageDisplayed(String message) {
        waitForElementVisible(driver, UserMyWishlistPageUI.ADDED_TO_WISHLIST_SUCCESS_MESSAGE, message);
        return isElementDisplayed(driver, UserMyWishlistPageUI.ADDED_TO_WISHLIST_SUCCESS_MESSAGE, message);
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
}
