package liveguruUser;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsUser.UserAccountInformationPageObject;
import pageObjectsUser.UserHomePageObject;
import pageObjectsUser.UserMyDashboardPageObject;
import pageObjectsUser.UserRegisterPageObject;

public class AdminManageAccount extends BaseTest {
    @Parameters({"browser", "userUrl", "adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl){
        this.adminUrl = adminUrl;
        this.userUrl = userUrl;
        driver = getBrowserDriver(browserName, this.userUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        randomNumber = getRandomNumber();
        firstName = "Sa First " + randomNumber;
        lastName = "Sa Last " + randomNumber;
        emailAddress = "sa" + randomNumber + "@hotmail.net";
        password = "123456";
    }

    @Test
    public void ManagerAccount_01_User_Create(){
        log.info("User_Create - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, userUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("User_Create - Step 02: Click to Register link");
        userRegisterPage = userHomePage.clickToHearderAccountRegisterLink();

        log.info("User_Create - Step 03: Enter to First Name textbox with value = " + firstName);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("firstname", firstName);

        log.info("User_Create - Step 04: Enter to Last Name textbox with value = " + lastName);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("lastname", lastName);

        log.info("User_Create - Step 05: Enter to Email Address textbox with value = " + emailAddress);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("email_address", emailAddress);

        log.info("User_Create - Step 06: Enter to Password textbox with value = " + password);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("password", password);

        log.info("User_Create - Step 07: Enter to Confirm Password textbox with value = " + password);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("confirmation", password);

        log.info("User_Create - Step 08: Click To Register button");
        userMyDashboardPage = userRegisterPage.clickToRegisterButton();

        log.info("User_Create - Step 09: Verify register success");
        Assert.assertEquals(userMyDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");

        log.info("User_Create - Step 10: Click to Left Sidebar Account Information link");
        userAccountInformationPage = userMyDashboardPage.clickToLeftSidebarLinkByText(driver, "Account Information");

        log.info("User_Create - Step 11: Verify account info");
        Assert.assertEquals(userAccountInformationPage.getAttributeValueAtTextboxByIDAtAccountInformationPage("value", "firstname"), firstName);
        Assert.assertEquals(userAccountInformationPage.getAttributeValueAtTextboxByIDAtAccountInformationPage("value", "lastname"), lastName);
        Assert.assertEquals(userAccountInformationPage.getAttributeValueAtTextboxByIDAtAccountInformationPage("value", "email"), emailAddress);

        log.info("User_Create - Step 12: Click to Account link");
        userAccountInformationPage.clickToHearderAccountLink(driver);

        log.info("User_Create - Step 13: Click to Logout link");
        userHomePage = userAccountInformationPage.clickToHearderAccountLogoutLink(driver);
    }


    private String userUrl, adminUrl;
    private WebDriver driver;
    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserMyDashboardPageObject userMyDashboardPage;
    private UserAccountInformationPageObject userAccountInformationPage;
    private String firstName, lastName, emailAddress, password;
    private int randomNumber;
}
