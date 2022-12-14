package pageObjectsUser;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIsUser.UserShareWishlistPageUI;

public class UserShareWishlistPageObject extends BasePage {
    private WebDriver driver;

    public UserShareWishlistPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void sendkeyToEmailTextarea(String emailAddress) {
        waitForElementVisible(driver, UserShareWishlistPageUI.EMAIL_TEXTAREA);
        sendKeyToElement(driver, UserShareWishlistPageUI.EMAIL_TEXTAREA, emailAddress);
    }

    public void sendkeyToMessageTextarea(String message) {
        waitForElementVisible(driver, UserShareWishlistPageUI.MESSAGE_TEXTAREA);
        sendKeyToElement(driver, UserShareWishlistPageUI.MESSAGE_TEXTAREA, message);
    }

    public UserMyWishlistPageObject clickToShareWishlistButtonAtShareWishlistPage() {
        waitForElementClickable(driver, UserShareWishlistPageUI.SHARE_WISHLIST_BUTTON);
        clickToElement(driver, UserShareWishlistPageUI.SHARE_WISHLIST_BUTTON);
        return PageGeneratorManager.getUserMyWishlistPage(driver);
    }
}
