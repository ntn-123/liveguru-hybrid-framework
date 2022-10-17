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
        fName = "Sa First";
        lName = "Sa Last";
        emailAddress = "sa" + getRandomNumber() + "@hotmail.net";
        password = "123456";
    }

    @Test
    public void User_01_Register(){
        log.info("Register - Step 1: Click and hold Account link");
        userHomePage.clickToHearderAccountLink();

        log.info("Register - Step 2: Click to Register link");
        userRegisterPage = userHomePage.clickToHearderAccountRegisterLink();

        log.info("Register - Step 3: Enter to First Name textbox with value = " + fName);
        userRegisterPage.sendkeyToTextboxByID("firstname", fName);

        log.info("Register - Step 4: Enter to Last Name textbox with value = " + lName);
        userRegisterPage.sendkeyToTextboxByID("lastname", lName);

        log.info("Register - Step 5: Enter to Email Address textbox with value = " + emailAddress);
        userRegisterPage.sendkeyToTextboxByID("email_address", emailAddress);

        log.info("Register - Step 6: Enter to Password textbox with value = " + password);
        userRegisterPage.sendkeyToTextboxByID("password", password);

        log.info("Register - Step 7: Enter to Confirm Password textbox with value = " + password);
        userRegisterPage.sendkeyToTextboxByID("confirmation", password);

        log.info("Register - Step 8: Click To Register button");
        userMyDashboardPage = userRegisterPage.clickToRegisterButton();

        log.info("Register - Step 9: Verify register success");
        Assert.assertEquals(userMyDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store..");

        log.info("Register - Step 10: Click to Left Sidebar Account Information link");
        userAccountInformationPage = userMyDashboardPage.clickToLeftSidebarLinkByText(driver, "Account Information");
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
    private String fName, lName, emailAddress, password;
}
