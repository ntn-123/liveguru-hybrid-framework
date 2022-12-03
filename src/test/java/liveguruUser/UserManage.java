package liveguruUser;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsUser.*;

import java.util.Set;

public class UserManage extends BaseTest {
    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl){
        driver = getBrowserDriver(browserName, appUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        homePageUrl = userHomePage.getPageUrl(driver);

        firstName = "Sa First";
        lastName = "Sa Last";
        emailAddress = "sa" + getRandomNumber() + "@hotmail.net";
        emailShareWishlist = "sa" + getRandomNumber() + "@hotmail.net";
        password = "123456";

        billFirstName = "Bill Sa First";
        billLastName = "Bill Sa Last";
        billAddress = "Bill Address";
        billCity = "Bill City";
        billStateProvince = "New York";
        billZip = "123456";
        billCountry = "United States";
        billTelephone = "0987654321";

        shipFirstName = "Ship Sa First";
        shipLastName = "Ship Sa Last";
        shipAddress = "Ship Address";
        shipCity = "Ship City";
        shipStateProvince = "New York";
        shipZip = "123456";
        shipCountry = "United States";
        shipTelephone = "0987654321";

    }

    //@Test
    public void User_01_Register(){
        log.info("Register - Step 01: Click to Account link");
        userHomePage.clickToHearderAccountLink(driver);

        log.info("Register - Step 02: Click to Register link");
        userRegisterPage = userHomePage.clickToHearderAccountRegisterLink();

        log.info("Register - Step 03: Enter to First Name textbox with value = " + firstName);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("firstname", firstName);

        log.info("Register - Step 04: Enter to Last Name textbox with value = " + lastName);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("lastname", lastName);

        log.info("Register - Step 05: Enter to Email Address textbox with value = " + emailAddress);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("email_address", emailAddress);

        log.info("Register - Step 06: Enter to Password textbox with value = " + password);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("password", password);

        log.info("Register - Step 07: Enter to Confirm Password textbox with value = " + password);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("confirmation", password);

        log.info("Register - Step 08: Click To Register button");
        userMyDashboardPage = userRegisterPage.clickToRegisterButton();

        log.info("Register - Step 09: Verify register success");
        Assert.assertEquals(userMyDashboardPage.getSuccessMessage(), "Thank you for registering with Main Website Store.");

        log.info("Register - Step 10: Click to Left Sidebar Account Information link");
        userAccountInformationPage = (UserAccountInformationPageObject) userMyDashboardPage.clickToLeftSidebarLinkByText(driver, "Account Information");

        log.info("Register - Step 11: Verify account info");
        Assert.assertEquals(userAccountInformationPage.getAttributeValueAtTextboxByIDAtAccountInformationPage("value", "firstname"), firstName);
        Assert.assertEquals(userAccountInformationPage.getAttributeValueAtTextboxByIDAtAccountInformationPage("value", "lastname"), lastName);
        Assert.assertEquals(userAccountInformationPage.getAttributeValueAtTextboxByIDAtAccountInformationPage("value", "email"), emailAddress);

        log.info("Register - Step 12: Click to Account link");
        userAccountInformationPage.clickToHearderAccountLink(driver);

        log.info("Register - Step 13: Click to Logout link");
        userHomePage = userAccountInformationPage.clickToHearderAccountLogoutLink(driver);
    }

    //@Test
    public void User_02_Login(){
        log.info("Login - Step 01: Click to hearder Account link");
        userHomePage.clickToHearderAccountLink(driver);

        log.info("Login - Step 02: Click to herder Login link");
        userLoginPage = userHomePage.clickToHearderAccountLoginLink(driver);

        log.info("Login - Step 03: User login to system with Email Address = " + emailAddress + "and Password = " + password);
        userMyDashboardPage = userLoginPage.userLoginToSystem(emailAddress, password);

        log.info("Login - Step 04: Verify login success");
        Assert.assertEquals(userMyDashboardPage.getMyDashboardTitle(), "MY DASHBOARD");
        Assert.assertEquals(userMyDashboardPage.getAccountNameText(), "Hello, " + firstName + " " + lastName + "!");
    }
    //@Test
    public void User_03_Cost_Of_Product(){
        log.info("Cost - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, homePageUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Cost - Step 02: Click to Mobile menu");
        userProductPage = userHomePage.clickToHearderProductMenuLinkByProductName(driver, "Mobile");

        log.info("Cost - Step 03: Get cost Sony Xperia mobile in the list of all mobiles");
        String costAtListPage = userProductPage.getProductCostByProductName("Sony Xperia");

        log.info("Cost - Step 04: Click to Sony Xperia detail");
        userProductDetailPage = userProductPage.clickToProductNameTitle("Sony Xperia");

        log.info("Cost - Step 05: Get cost Sony Xperia mobile in detail page");
        String costAtDetailPage = userProductDetailPage.getProductCostByProductNameAtDetailPage("Sony Xperia");

        log.info("Cost - Step 06: Compare cost");
        Assert.assertEquals(costAtListPage, costAtDetailPage);
    }

    //@Test
    public void User_04_Coupon(){
        log.info("Coupon - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, homePageUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Coupon - Step 02: Click to Mobile menu");
        userProductPage = userHomePage.clickToHearderProductMenuLinkByProductName(driver, "Mobile");

        log.info("Coupon - Step 03: Click to Add to cart button at Sony Xperia");
        userCheckoutCartPage = userProductPage.clickToAddToCartButtonAtMobileList("Sony Xperia");

        log.info("Coupon - Step 04: Verify add mobile to cart success");
        Assert.assertEquals(userCheckoutCartPage.getAddedToCartSuccessMessage(), "Sony Xperia was added to your shopping cart.");

        log.info("Coupon - Step 05: Enter to coupon code to Discount codes text box");
        userCheckoutCartPage.sendkeyToTextboxByID("coupon_code", "GURU50");

        log.info("Coupon - Step 06: Click to Apply button");
        userCheckoutCartPage.clickToApplyButton();

        log.info("Coupon - Step 07: Verify coupon apply success");
        Assert.assertEquals(userCheckoutCartPage.getDiscountPrice(), "-$5.00");
        Assert.assertEquals(userCheckoutCartPage.getGrandTotalPrice(), "$95.00");
    }

    //@Test
    public void User_05_Add_More_Products(){
        log.info("Add - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, homePageUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Add - Step 02: Click to Mobile menu");
        userProductPage = userHomePage.clickToHearderProductMenuLinkByProductName(driver, "Mobile");

        log.info("Add - Step 03: Click to Add to cart button at Sony Xperia");
        userCheckoutCartPage = userProductPage.clickToAddToCartButtonAtMobileList("Sony Xperia");

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

    //@Test
    public void User_06_Compare(){
        log.info("Compare - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, homePageUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Compare - Step 02: Click to Mobile menu");
        userProductPage = userHomePage.clickToHearderProductMenuLinkByProductName(driver, "Mobile");

        log.info("Compare - Step 03: Click to Add to compare link at Sony Xperia");
        userProductPage.clickToAddToCompareLinkByMobileNameAtMobileList("Sony Xperia");

        log.info("Compare - Step 04: Verify Sony Xperia added to compare success");
        Assert.assertTrue(userProductPage.isAddedToCompareSuccessMessageDisplayed("The product Sony Xperia has been added to comparison list."));

        log.info("Compare - Step 05: Click to Add to compare link at Iphone");
        userProductPage.clickToAddToCompareLinkByMobileNameAtMobileList("IPhone");

        log.info("Compare - Step 06: Verify Iphone added to compare success");
        Assert.assertTrue(userProductPage.isAddedToCompareSuccessMessageDisplayed("The product IPhone has been added to comparison list."));

        log.info("Compare - Step 07: Get WindowID at Mobile page");
        String windowIdAtMobile = userProductPage.getWindowIdAtCurrentPage(driver);

        log.info("Compare - Step 08: Click to Compare button");
        userCompareProductsPage = userProductPage.clickToCompareButton();

        log.info("Compare - Step 09: Get WindowID at Mobile page");
        String windowIdAtCompareProducts = userProductPage.getWindowIdAtCurrentPage(driver);

        log.info("Compare - Step 10: Verify Compare product title displayed in new wimdow");
        Assert.assertTrue(userCompareProductsPage.isCompareProductsHeadingDisplayed());

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
        userProductPage = userCompareProductsPage.closeWindowCompareProducts(windowIdAtMobile);
        userProductPage.sleepInSecond(2);

        log.info("Compare - Step 14: Verify Compare products window closed");
        Assert.assertTrue(userProductPage.isWindowClosed(driver, windowIdAtCompareProducts));
        
    }

    //@Test
    public void User_07_Wishlist() {
        log.info("Wishlist - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, homePageUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Wishlist - Step 02: Click to TV menu");
        userProductPage = userHomePage.clickToHearderProductMenuLinkByProductName(driver, "TV");

        log.info("Wishlist - Step 03: Click to Add to wishlist link at LG LCD");
        userMyWishlistPage = userProductPage.clickToAddToWishlistLinkByProductName("LG LCD");

        log.info("Wishlist - Step 04: Verify LG LCD added to wishlist success displayed");
        Assert.assertEquals(userMyWishlistPage.getAddedToWishlistSuccessMessage("innerText"),"LG LCD has been added to your wishlist. Click here to continue shopping.");

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

    //@Test
    public void User_08_Add_Your_Review(){
        log.info("Review - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, homePageUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Review - Step 02: Click to TV menu");
        userProductPage = userHomePage.clickToHearderProductMenuLinkByProductName(driver, "TV");

        log.info("Review - Step 03: Click to Samsung LCD name title");
        userProductDetailPage = userProductPage.clickToProductNameTitle("Samsung LCD");

        log.info("Review - Step 04: Click to Add your review link");
        userProductDetailPage.clickToAddYourReviewLink();

        log.info("Review - Step 05: Click to Submit review button");
        userProductDetailPage.clickToSubmitReviewButton();

        log.info("Review - Step 06: Verify required error message at Rate field displayed");
        Assert.assertEquals(userProductDetailPage.getErrorMessageReviewAtInputFieldByID("advice-validate-rating-validate_rating"), "Please select one of each of the ratings above");

        log.info("Review - Step 07: Verify required error message at Review field displayed");
        Assert.assertEquals(userProductDetailPage.getErrorMessageReviewAtInputFieldByID("advice-required-entry-review_field"), "THIS IS A REQUIRED FIELD.");

        log.info("Review - Step 08: Verify required error message at Summary field displayed");
        Assert.assertEquals(userProductDetailPage.getErrorMessageReviewAtInputFieldByID("advice-required-entry-summary_field"), "THIS IS A REQUIRED FIELD.");

        log.info("Review - Step 09: Check to Rate Field");
        userProductDetailPage.checkToRateRadioButtonByID("Quality 1_3");

        log.info("Review - Step 10: Enter to Review field");
        userProductDetailPage.sendkeyToReviewFieldTextarea("Review");

        log.info("Review - Step 11: Enter to Summary field");
        userProductDetailPage.sendkeyToSummaryFieldTextbox("Summary");

        log.info("Review - Step 12: Enter to Nickname field");
        userProductDetailPage.sendkeyToNicknameFieldTextbox("Nickname");

        log.info("Review - Step 13: Click to Submit review button");
        userProductDetailPage.clickToSubmitReviewButton();

        log.info("Review - Step 14: Verify reviewed success message displayed");
        Assert.assertEquals(userProductDetailPage.getReviewedSuccessMessage(), "Your review has been accepted for moderation.");
    }

    //@Test
    public void User_09_Purchase_Product() {
        log.info("Purchase - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, homePageUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Purchase - Step 02: Click to Go to wishlist link");
        userMyWishlistPage = userHomePage.clickToGoTOWishlistLink(driver);

        log.info("Purchase - Step 03: Click to Add to cart button");
        userCheckoutCartPage = userMyWishlistPage.clickToAddToCartButton();

        log.info("Purchase - Step 04: Select Country from dropdown Country");
        userCheckoutCartPage.selectItemInDropdownByID("country", "United States");

        log.info("Purchase - Step 05: Select State/ Province from dropdown State/ Province");
        userCheckoutCartPage.selectItemInDropdownByID("region_id", "New York");

        log.info("Purchase - Step 06: Enter zipcode to Zip textbox");
        userCheckoutCartPage.sendkeyToTextboxByID("postcode", "123456");

        log.info("Purchase - Step 07: Click to Estimate button");
        userCheckoutCartPage.clickToEstimateButton();
        userCheckoutCartPage.sleepInSecond(3);

        log.info("Purchase - Step 08: Verify Flat rate cost displayed");
        Assert.assertEquals(userCheckoutCartPage.getFlatRatePriceText(), "$5.00");

        log.info("Purchase - Step 09: Select Flat rate cost");
        userCheckoutCartPage.checkToFlatRateRadioButton();
        userCheckoutCartPage.sleepInSecond(2);

        log.info("Purchase - Step 10: Click to Update total button");
        userCheckoutCartPage.clickToUpdateTotalButton();
        userCheckoutCartPage.sleepInSecond(3);

        log.info("Purchase - Step 11: Verify Flat rate cost is added to grand total");
        Assert.assertEquals(userCheckoutCartPage.getGrandTotalPrice(), "$620.00");

        log.info("Purchase - Step 12: Click to Proceed to checkout button");
        userCheckoutOnepagePage = userCheckoutCartPage.clickToProceedToCheckoutButton();

        log.info("Purchase - Step 13: Enter to Billing Information and click Continue button");
        userCheckoutOnepagePage.sendkeyToTextboxByID("billing:firstname", billFirstName);
        userCheckoutOnepagePage.sendkeyToTextboxByID("billing:lastname", billLastName);
        userCheckoutOnepagePage.sendkeyToTextboxByID("billing:street1", billAddress);
        userCheckoutOnepagePage.sendkeyToTextboxByID("billing:city", billCity);
        userCheckoutOnepagePage.selectItemInDropdownByID("billing:country_id", billCountry);
        userCheckoutOnepagePage.sendkeyToTextboxByID("billing:postcode", billZip);
        userCheckoutOnepagePage.selectItemInDropdownByID("billing:region_id", billStateProvince);
        userCheckoutOnepagePage.sendkeyToTextboxByID("billing:telephone", billTelephone);
        userCheckoutOnepagePage.checkToRadiobuttonByID("billing:use_for_shipping_no");
        userCheckoutOnepagePage.clickToButtonByID("billing-buttons-container");

        log.info("Purchase - Step 14: Enter to Shipping Information and click Continue button");
        userCheckoutOnepagePage.sendkeyToTextboxByID("shipping:firstname", shipFirstName);
        userCheckoutOnepagePage.sendkeyToTextboxByID("shipping:lastname", shipLastName);
        userCheckoutOnepagePage.sendkeyToTextboxByID("shipping:street1", shipAddress);
        userCheckoutOnepagePage.sendkeyToTextboxByID("shipping:city", shipCity);
        userCheckoutOnepagePage.selectItemInDropdownByID("shipping:country_id", shipCountry);
        userCheckoutOnepagePage.sendkeyToTextboxByID("shipping:postcode", shipZip);
        userCheckoutOnepagePage.selectItemInDropdownByID("shipping:region_id", shipStateProvince);
        userCheckoutOnepagePage.sendkeyToTextboxByID("shipping:telephone", shipTelephone);
        userCheckoutOnepagePage.clickToButtonByID("shipping-buttons-container");

        log.info("Purchase - Step 15: Click to Continue button at Shipping Method");
        userCheckoutOnepagePage.clickToButtonByID("shipping-method-buttons-container");

        log.info("Purchase - Step 16: Check to Check/ Money order radio button and click to Continue button at Payment Information");
        userCheckoutOnepagePage.checkToRadiobuttonByID("p_method_checkmo");
        userCheckoutOnepagePage.clickToButtonByID("payment-buttons-container");

        log.info("Purchase - Step 17: Click to Place order button at Order Review");
        userCheckoutOnepagePage.clickToButtonByID("review-buttons-container");
        userCheckoutOnepagePage.sleepInSecond(3);

        log.info("Purchase - Step 18: Verify order success message display");
        Assert.assertEquals(userCheckoutOnepagePage.getOrderSuccessMessage(), "YOUR ORDER HAS BEEN RECEIVED.");

        log.info("Purchase - Step 19: Verify order id display");
        Assert.assertTrue(userCheckoutOnepagePage.isOrderIdDisplayed());
    }

    @Test
    public void User_10_Advance_Search(){
        log.info("Advance_Search - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, homePageUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Advance_Search - Step 02: Click to Advanced search link at footer page");
        userCatalogAdvancedSearchPage = (UserCatalogAdvancedSearchPageObject) userHomePage.clickToFooterMenuLinkByText(driver, "Advanced Search");

        log.info("Advance_Search - Step 03: Input to Price textbox");
        userCatalogAdvancedSearchPage.sendkeyToTextBoxByID("price", "100");
        userCatalogAdvancedSearchPage.sendkeyToTextBoxByID("price_to", "140");

        log.info("Advance_Search - Step 04: Click to Search button");
        userAdvanceSearchResultPage = userCatalogAdvancedSearchPage.clickToSearchButton();

        log.info("Advance_Search - Step 05: Verify price of items is fetched with data search");
        Assert.assertTrue(userAdvanceSearchResultPage.isPriceOfItemsFetchedWithDataSearch("100", "140"));

        log.info("Advance_Search - Step 06: Click to Advanced search link at footer page");
        userCatalogAdvancedSearchPage = (UserCatalogAdvancedSearchPageObject) userAdvanceSearchResultPage.clickToFooterMenuLinkByText(driver, "Advanced Search");

        log.info("Advance_Search - Step 07: Input to Price textbox");
        userCatalogAdvancedSearchPage.sendkeyToTextBoxByID("price", "141");
        userCatalogAdvancedSearchPage.sendkeyToTextBoxByID("price_to", "1000");

        log.info("Advance_Search - Step 08: Click to Search button");
        userAdvanceSearchResultPage = userCatalogAdvancedSearchPage.clickToSearchButton();

        log.info("Advance_Search - Step 09: Verify price of items is fetched with data search");
        Assert.assertTrue(userAdvanceSearchResultPage.isPriceOfItemsFetchedWithDataSearch("141", "1000"));
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
    private UserProductPageObject userProductPage;
    private UserProductDetailPageObject userProductDetailPage;
    private UserCheckoutCartPageObject userCheckoutCartPage;
    private UserCompareProductsPageObject userCompareProductsPage;
    private UserMyWishlistPageObject userMyWishlistPage;
    private UserShareWishlistPageObject userShareWishlistPage;
    private UserCheckoutOnepagePageObject userCheckoutOnepagePage;
    private UserCatalogAdvancedSearchPageObject userCatalogAdvancedSearchPage;
    private UserAdvanceSearchResultPageObject userAdvanceSearchResultPage;
    private String firstName, lastName, emailAddress, password;
    private String billFirstName, billLastName, billAddress, billCity, billStateProvince, billZip, billCountry, billTelephone;
    private String shipFirstName, shipLastName, shipAddress, shipCity, shipStateProvince, shipZip, shipCountry, shipTelephone;
    private String emailShareWishlist;
    private String homePageUrl;
}
