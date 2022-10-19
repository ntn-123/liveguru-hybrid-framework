package liveguruUser;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class RegisterAndLogin extends BaseTest {
    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl){
        driver = getBrowserDriver(browserName, appUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        homePageUrl = userHomePage.getPageUrl(driver);
        fName = "Sa First";
        lName = "Sa Last";
        emailAddress = "sa" + getRandomNumber() + "@hotmail.net";
        emailShareWishlist = "sa" + getRandomNumber() + "@hotmail.net";
        password = "123456";
    }

    @Test
    public void User_01_Register(){
        log.info("Register - Step 01: Click to Account link");
        userHomePage.clickToHearderAccountLink(driver);

        log.info("Register - Step 02: Click to Register link");
        userRegisterPage = userHomePage.clickToHearderAccountRegisterLink();

        log.info("Register - Step 03: Enter to First Name textbox with value = " + fName);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("firstname", fName);

        log.info("Register - Step 04: Enter to Last Name textbox with value = " + lName);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("lastname", lName);

        log.info("Register - Step 05: Enter to Email Address textbox with value = " + emailAddress);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("email_address", emailAddress);

        log.info("Register - Step 06: Enter to Password textbox with value = " + password);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("password", password);

        log.info("Register - Step 07: Enter to Confirm Password textbox with value = " + password);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("confirmation", password);

        log.info("Register - Step 08: Click To Register button");
        userMyDashboardPage = userRegisterPage.clickToRegisterButton();

        log.info("Register - Step 09: Verify register success");
        Assert.assertEquals(userMyDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");

        log.info("Register - Step 10: Click to Left Sidebar Account Information link");
        userAccountInformationPage = userMyDashboardPage.clickToLeftSidebarLinkByText(driver, "Account Information");

        log.info("Register - Step 11: Verify account info");
        Assert.assertEquals(userAccountInformationPage.getAttributeValueAtTextboxByIDAtAccountInformationPage("value", "firstname"), fName);
        Assert.assertEquals(userAccountInformationPage.getAttributeValueAtTextboxByIDAtAccountInformationPage("value", "lastname"), lName);
        Assert.assertEquals(userAccountInformationPage.getAttributeValueAtTextboxByIDAtAccountInformationPage("value", "email"), emailAddress);

        log.info("Register - Step 12: Click to Account link");
        userAccountInformationPage.clickToHearderAccountLink(driver);

        log.info("Register - Step 13: Click to Logout link");
        userHomePage = userAccountInformationPage.clickToHearderAccountLogoutLink(driver);
    }

    @Test
    public void User_02_Login(){
        log.info("Login - Step 01: Click to hearder Account link");
        userHomePage.clickToHearderAccountLink(driver);

        log.info("Login - Step 02: Click to herder Login link");
        userLoginPage = userHomePage.clickToHearderAccountLoginLink(driver);

        log.info("Login - Step 03: Enter to Email Address textbox with value = " + emailAddress);
        userLoginPage.sendkeyToTextboxByIDAtLoginPage("email", emailAddress);

        log.info("Login - Step 04: Enter to Password textbox with value = " + emailAddress);
        userLoginPage.sendkeyToTextboxByIDAtLoginPage("pass", password);

        log.info("Login - Step 05: Click to Login button");
        userMyDashboardPage = userLoginPage.clickToLoginButton();

        log.info("Login - Step 06: Verify login success");
        Assert.assertEquals(userMyDashboardPage.getMyDashboardTitle(), "MY DASHBOARD");
        Assert.assertEquals(userMyDashboardPage.getAccountNameText(), "Hello, " + fName + " " + lName + "!");
    }
    @Test
    public void User_03_Cost_Of_Product(){
        log.info("Cost - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, homePageUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Cost - Step 02: Click to Mobile menu");
        userMobilePage = userHomePage.clickToHearderMobileMenuLink(driver);

        log.info("Cost - Step 03: Get cost Sony Xperia mobile in the list of all mobiles");
        String costAtListPage = userMobilePage.getMobileCostByMobileNameAtMobileList("Sony Xperia");

        log.info("Cost - Step 04: Click to Sony Xperia detail");
        userMobileDetailPage = userMobilePage.clickToMobileNameTitle("Sony Xperia");

        log.info("Cost - Step 05: Get cost Sony Xperia mobile in detail page");
        String costAtDetailPage = userMobileDetailPage.getMobileCostByMobileNameAtDetailPage("Sony Xperia");

        log.info("Cost - Step 06: Compare cost");
        Assert.assertEquals(costAtListPage, costAtDetailPage);
    }

    @Test
    public void User_04_Coupon(){
        log.info("Coupon - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, homePageUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Coupon - Step 02: Click to Mobile menu");
        userMobilePage = userHomePage.clickToHearderMobileMenuLink(driver);

        log.info("Coupon - Step 03: Click to Add to cart button at Sony Xperia");
        userCheckoutCartPage = userMobilePage.clickToAddToCartButtonAtMobileList("Sony Xperia");

        log.info("Coupon - Step 04: Verify add mobile to cart success");
        Assert.assertEquals(userCheckoutCartPage.getAddedToCartSuccessMessage(), "Sony Xperia was added to your shopping cart.");

        log.info("Coupon - Step 05: Enter to coupon code to Discount codes text box");
        userCheckoutCartPage.sendkeyToDiscountCodesTextbox("GURU50");

        log.info("Coupon - Step 06: Click to Apply button");
        userCheckoutCartPage.clickToApplyButton();

        log.info("Coupon - Step 07: Verify coupon apply success");
        Assert.assertEquals(userCheckoutCartPage.getDiscountPrice(), "-$5.00");
        Assert.assertEquals(userCheckoutCartPage.getGrandTotalPrice(), "$95.00");
    }

    @Test
    public void User_05_Add_More_Products(){
        log.info("Add - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, homePageUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Add - Step 02: Click to Mobile menu");
        userMobilePage = userHomePage.clickToHearderMobileMenuLink(driver);

        log.info("Add - Step 03: Click to Add to cart button at Sony Xperia");
        userCheckoutCartPage = userMobilePage.clickToAddToCartButtonAtMobileList("Sony Xperia");

        log.info("Add - Step 04: Verify add mobile to cart success");
        Assert.assertEquals(userCheckoutCartPage.getAddedToCartSuccessMessage(), "Sony Xperia was added to your shopping cart.");

        log.info("Add - Step 05: Enter to QTY text box");
        userCheckoutCartPage.sendkeyToQTYTextbox("501");

        log.info("Add - Step 06: Click to Update button");
        userCheckoutCartPage.clickToUpdateButton();

        log.info("Add - Step 07: Verify quantity error message dispalyed");
        Assert.assertTrue(userCheckoutCartPage.isQtyErrorMessageDisplayed("Some of the products cannot be ordered in requested quantity."));

        log.info("Add - Step 08: Verify quantity item error message dispalyed");
        Assert.assertTrue(userCheckoutCartPage.isQtyItemErrorMessageDisplayed("* The maximum quantity allowed for purchase is 500."));

        log.info("Add - Step 09: Click to Empty cart button");
        userCheckoutCartPage.clickToEmptyCartButton();

        log.info("Add - Step 10: Verify cart empty title message dispalyed");
        Assert.assertTrue(userCheckoutCartPage.isCartEmptyTitleMessageDisplayed("Shopping Cart is Empty"));

        log.info("Add - Step 11: Verify cart empty content message dispalyed");
        Assert.assertTrue(userCheckoutCartPage.isCartEmptyContentMessageDisplayed("You have no items in your shopping cart."));
    }

    @Test
    public void User_06_Compare(){
        log.info("Compare - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, homePageUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Compare - Step 02: Click to Mobile menu");
        userMobilePage = userHomePage.clickToHearderMobileMenuLink(driver);

        log.info("Compare - Step 03: Click to Add to compare link at Sony Xperia");
        userMobilePage.clickToAddToCompareLinkByMobileNameAtMobileList("Sony Xperia");

        log.info("Compare - Step 04: Verify Sony Xperia added to compare success");
        Assert.assertTrue(userMobilePage.isAddedToCompareSuccessMessageDisplayed("The product Sony Xperia has been added to comparison list."));

        log.info("Compare - Step 05: Click to Add to compare link at Iphone");
        userMobilePage.clickToAddToCompareLinkByMobileNameAtMobileList("IPhone");

        log.info("Compare - Step 06: Verify Iphone added to compare success");
        Assert.assertTrue(userMobilePage.isAddedToCompareSuccessMessageDisplayed("The product IPhone has been added to comparison list."));

        log.info("Compare - Step 07: Get WindowID at Mobile page");
        String windowIdAtMobile = userMobilePage.getWindowIdAtCurrentPage(driver);

        log.info("Compare - Step 08: Click to Compare button");
        userCompareProductsPage = userMobilePage.clickToCompareButton();

        log.info("Compare - Step 09: Get WindowID at Mobile page");
        String windowIdAtCompareProducts = userMobilePage.getWindowIdAtCurrentPage(driver);

        log.info("Compare - Step 10: Verify Compare product title displayed in new wimdow");
        Assert.assertTrue(userCompareProductsPage.isCompareProductsTitleDisplayed());

        log.info("Compare - Step 11: Verify selected Sony Xperia dislayed");
        Assert.assertTrue(userCompareProductsPage.isMobileNameDisplayed("Sony Xperia"));
        Assert.assertTrue(userCompareProductsPage.isMobilePriceByMobileNameDisplayed("Sony Xperia", "$100.00"));
        Assert.assertTrue(userCompareProductsPage.isMobileImageByMobileNameDisplayed("Sony Xperia", "xperia.jpg"));
        Assert.assertTrue(userCompareProductsPage.isMobileSkuByMobileNameDisplayed("MOB001"));

        log.info("Compare - Step 12: Verify selected Iphone dislayed");
        Assert.assertTrue(userCompareProductsPage.isMobileNameDisplayed("IPhone"));
        Assert.assertTrue(userCompareProductsPage.isMobilePriceByMobileNameDisplayed("IPhone", "$500.00"));
        Assert.assertTrue(userCompareProductsPage.isMobileImageByMobileNameDisplayed("IPhone", "iphone.png"));
        Assert.assertTrue(userCompareProductsPage.isMobileSkuByMobileNameDisplayed("MOB0002"));

        log.info("Compare - Step 13: Close Compare products window");
        userMobilePage = userCompareProductsPage.closeWindowCompareProducts(windowIdAtMobile);
        userMobilePage.sleepInSecond(2);

        log.info("Compare - Step 14: Verify Compare products window closed");
        Assert.assertTrue(userMobilePage.isWindowClosed(driver, windowIdAtCompareProducts));
    }

    @Test
    public void User_07_Wishlist() {
        log.info("Wishlist - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, homePageUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Wishlist - Step 02: Click to TV menu");
        userTVPage = userHomePage.clickToHearderTVMenuLink(driver);

        log.info("Wishlist - Step 03: Click to Add to wishlist link at LG LCD");
        userMyWishlistPage = userTVPage.clickToAddToWishlistLinkByTVNameAtTVList("LG LCD");

        log.info("Wishlist - Step 04: Verify LG LCD added to wishlist success displayed");
        Assert.assertTrue(userMyWishlistPage.isAddedToWishlistSuccessMessageDisplayed("LG LCD has been added to your wishlist. Click here to continue shopping."));

        log.info("Wishlist - Step 05: Click to Share wishlist button");
        userShareWishlistPage = userMyWishlistPage.clickToShareWishlistButtonAtMyWishlistPage();

        log.info("Wishlist - Step 06: Enter to Email textarea with email " + emailShareWishlist);
        userShareWishlistPage.sendkeyToEmailTextarea(emailShareWishlist);

        log.info("Wishlist - Step 07: Enter to Message textarea");
        userShareWishlistPage.sendkeyToMessageTextarea("Share wishlist");

        log.info("Wishlist - Step 08: Click to Share wishlist button");
        userMyWishlistPage = userShareWishlistPage.clickToShareWishlistButtonAtShareWishlistPage();

        log.info("Wishlist - Step 09: Verify share wishlist success message displayed");
        Assert.assertTrue(userMyWishlistPage.isShareWishlistSuccessMessageDisplayed("Your Wishlist has been shared."));

        log.info("Wishlist - Step 09: Verify My wishlist page has 1 item: LG LCD");
        Assert.assertEquals(userMyWishlistPage.getAllWishlistItems(), "1");
        Assert.assertEquals(userMyWishlistPage.getWishlistItemName(), "LG LCD");
    }

    @Test
    public void User_08_Add_Your_Review(){
        log.info("Review - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, homePageUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Review - Step 02: Click to TV menu");
        userTVPage = userHomePage.clickToHearderTVMenuLink(driver);

        log.info("Review - Step 03: Click to Sony Xperia detail");
        userTVDetailPage = userTVPage.clickToTVNameTitle("Samsung LCD");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserAndDriver();
    }
    private WebDriver driver;
    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserMyDashboardPageObject userMyDashboardPage;
    private UserAccountInformationPageObject userAccountInformationPage;
    private  UserLoginPageObject userLoginPage;
    private UserMobilePageObject userMobilePage;
    private UserMobileDetailPageObject userMobileDetailPage;
    private UserCheckoutCartPageObject userCheckoutCartPage;
    private UserCompareProductsPageObject userCompareProductsPage;
    private UserTVPageObject userTVPage;
    private UserMyWishlistPageObject userMyWishlistPage;
    private UserShareWishlistPageObject userShareWishlistPage;
    private UserTVDetailPageObject userTVDetailPage;
    private String fName, lName, emailAddress, password;
    private String emailShareWishlist;
    private String homePageUrl;
}
