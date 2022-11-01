package commons;

import org.openqa.selenium.WebDriver;
import pageObjectsAdmin.*;
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
    public static UserProductPageObject getUserProductPage(WebDriver driver){
        return new UserProductPageObject(driver);
    }
    public static UserProductDetailPageObject getUserProductDetailPage(WebDriver driver){
        return new UserProductDetailPageObject(driver);
    }
    public static UserCheckoutCartPageObject getUserCheckoutCartPage(WebDriver driver){
        return new UserCheckoutCartPageObject(driver);
    }public static UserCompareProductsPageObject getUserCompareProductsPage(WebDriver driver){
        return new UserCompareProductsPageObject(driver);
    }

    public static UserMyWishlistPageObject getUserMyWishlistPage(WebDriver driver){
        return new UserMyWishlistPageObject(driver);
    }
    public static UserShareWishlistPageObject getUserShareWishlistPage(WebDriver driver){
        return new UserShareWishlistPageObject(driver);
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
    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver){
        return new AdminLoginPageObject(driver);
    }

    public static AdminManageCustomerPageObject getAdminManageCustomerPage(WebDriver driver){
        return new AdminManageCustomerPageObject(driver);
    }

    public static AdminOrdersPageObject getAdminOrdersPage(WebDriver driver){
        return new AdminOrdersPageObject(driver);
    }

    public static AdminCatalogProductReviewPageObject getAdminCatalogProductReviewPage(WebDriver driver){
        return new AdminCatalogProductReviewPageObject(driver);
    }

    public static AdminCatalogProductEditReviewPageObject getAdminCatalogProductEditReviewPage(WebDriver driver){
        return new AdminCatalogProductEditReviewPageObject(driver);
    }
}
