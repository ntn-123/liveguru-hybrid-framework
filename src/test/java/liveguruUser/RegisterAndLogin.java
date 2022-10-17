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
        Assert.assertEquals(userMyDashboardPage.getMyDashboardTitle(), "My Dashboard");
        Assert.assertEquals(userMyDashboardPage.getAccountNameText(), "Hello, " + fName + " " + lName + "!");
    }
    @Test
    public void User_03_Cost_Of_Product(){
        log.info("Cost - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, homePageUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Cost - Step 02: Click to Mobile menu");
        userMobilePage = userHomePage.clickToMobileMenu(driver);

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
    public void User_03_Coupon(){
        log.info("Coupon - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, homePageUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Coupon - Step 02: Click to Mobile menu");
        userMobilePage = userHomePage.clickToMobileMenu(driver);

        log.info("Coupon - Step 03: Click to Add to cart button at Sony Xperia");
        userCheckoutCartPage = userMobilePage.clickToAddToCartButtonAtMobileList("Sony Xperia");

        log.info("Coupon - Step 04: Verify add mobile to cart success");
        Assert.assertEquals(userCheckoutCartPage.getAddedToCartSuccessMessage(), "Sony Xperia was added to your shopping cart.");

        log.info("Coupon - Step 05: Enter to coupon code to Discount codes text box");
        userCheckoutCartPage.sendkeyToDiscountCodesTextbox("GURU50");

        log.info("Coupon - Step 06: Click to Apply button");
        userCheckoutCartPage.clickToApplyButton();

        log.info("Coupon - Step 07: Verify coupon apply success");
        //Assert.assertEquals(userCheckoutCartPage.getDiscountPrice(), "-$5.00");
       // Assert.assertEquals(userCheckoutCartPage.getGrandTotalPrice(), "$95.00");
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
    private String fName, lName, emailAddress, password;
    private String homePageUrl;
}
