package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserHomePageUI;
import pageUIs.UserMobilePageUI;
import pageUIs.UserTVPageUI;

public class UserTVPageObject extends BasePage {
    private WebDriver driver;

    public UserTVPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public UserMyWishlistPageObject clickToAddToWishlistLinkByTVNameAtTVList(String tvName) {
        waitForElementVisible(driver, UserTVPageUI.ADD_TO_WISHLIST_LINK_BY_TV_NAME, tvName);
        clickToElement(driver, UserTVPageUI.ADD_TO_WISHLIST_LINK_BY_TV_NAME, tvName);
        return PageGeneratorManager.getUserMyWishlistPage(driver);
    }

    public UserTVDetailPageObject clickToTVNameTitle(String tvName) {
        waitForElementVisible(driver, UserTVPageUI.TV_NAME_TITLE, tvName);
        clickToElement(driver, UserTVPageUI.TV_NAME_TITLE, tvName);
        return PageGeneratorManager.getUserTVDetailPage(driver);
    }
}