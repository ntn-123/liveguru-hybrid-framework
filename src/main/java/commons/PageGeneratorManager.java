package commons;

import org.openqa.selenium.WebDriver;
import pageObjectsUser.*;

public class PageGeneratorManager {
    public static UserHomePageObject getUserHomePage(WebDriver driver){
        return new UserHomePageObject(driver);
    }
    public static UserRegisterPageObject getUserRegisterPage(WebDriver driver){
        return new UserRegisterPageObject(driver);
    }
    public static UserLoginPageObject getUserLoginPage(WebDriver driver){
        return new UserLoginPageObject(driver);
    }
    public static UserMyDashboardPageObject getUserMyDashboardPage(WebDriver driver){
        return new UserMyDashboardPageObject(driver);
    }
    public static UserAccountInformationPageObject getUserAccountInformationPage(WebDriver driver){
        return new UserAccountInformationPageObject(driver);
    }
    public static UserMobilePageObject getUserMobilePage(WebDriver driver){
        return new UserMobilePageObject(driver);
    }
    public static UserMobileDetailPageObject getUserMobileDetailPage(WebDriver driver){
        return new UserMobileDetailPageObject(driver);
    }
    public static UserCheckoutCartPageObject getUserCheckoutCartPage(WebDriver driver){
        return new UserCheckoutCartPageObject(driver);
    }public static UserCompareProductsPageObject getUserCompareProductsPage(WebDriver driver){
        return new UserCompareProductsPageObject(driver);
    }
    public static UserTVPageObject getUserTVPage(WebDriver driver){
        return new UserTVPageObject(driver);
    }
    public static UserMyWishlistPageObject getUserMyWishlistPage(WebDriver driver){
        return new UserMyWishlistPageObject(driver);
    }
    public static UserShareWishlistPageObject getUserShareWishlistPage(WebDriver driver){
        return new UserShareWishlistPageObject(driver);
    }
    public static UserTVDetailPageObject getUserTVDetailPage(WebDriver driver){
        return new UserTVDetailPageObject(driver);
    }
    public static UserCheckoutOnepagePageObject getUserCheckoutOnepagePage(WebDriver driver){
        return new UserCheckoutOnepagePageObject(driver);
    }
    public static UserCatalogAdvancedSearchPageObject getUserCatalogAdvancedSearchPage(WebDriver driver){
        return new UserCatalogAdvancedSearchPageObject(driver);
    }
    public static UserAdvanceSearchResultPageObject getUserAdvanceSearchResultPage(WebDriver driver){
        return new UserAdvanceSearchResultPageObject(driver);
    }
}
