package liveguruUser;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsAdmin.AdminLoginPageObject;
import pageObjectsAdmin.AdminManageCustomerPageObject;
import pageObjectsUser.*;

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

        adminUserName = "user01";
        adminPassword = "guru99com";

        firstNameUpdate = "Sa First Update " + randomNumber;
        lastNameUpdate = "Sa Last Update " + randomNumber;
        emailAddressUpdate = "sa.update" + randomNumber + "@hotmail.net";
        passwordUpdate = "1234567";
    }

    @Test
    public void ManagerAccount_01_Create_Account(){
        log.info("Create_Account - Step 01: Open LiveGuru99 user site");
        userHomePage.openPageUrl(driver, userUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("User_Update - Step 02: Click to hearder Account link");
        userHomePage.clickToHearderAccountLink(driver);

        log.info("Create_Account - Step 03: Click to Register link");
        userRegisterPage = userHomePage.clickToHearderAccountRegisterLink();

        log.info("Create_Account - Step 04: Enter to First Name textbox with value = " + firstName);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("firstname", firstName);

        log.info("Create_Account - Step 05: Enter to Last Name textbox with value = " + lastName);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("lastname", lastName);

        log.info("Create_Account - Step 06: Enter to Email Address textbox with value = " + emailAddress);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("email_address", emailAddress);

        log.info("Create_Account - Step 07: Enter to Password textbox with value = " + password);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("password", password);

        log.info("Create_Account - Step 08: Enter to Confirm Password textbox with value = " + password);
        userRegisterPage.sendkeyToTextboxByIDAtRegisterPage("confirmation", password);

        log.info("Create_Account - Step 09: Click To Register button");
        userMyDashboardPage = userRegisterPage.clickToRegisterButton();

        log.info("Create_Account - Step 10: Verify register success");
        Assert.assertEquals(userMyDashboardPage.getSuccessMessage(), "Thank you for registering with Main Website Store.");

        log.info("Create_Account - Step 11: Click to Left Sidebar Account Information link");
        userAccountInformationPage = (UserAccountInformationPageObject) userMyDashboardPage.clickToLeftSidebarLinkByText(driver, "Account Information");

        log.info("Create_Account - Step 12: Verify account info");
        Assert.assertEquals(userAccountInformationPage.getAttributeValueAtTextboxByIDAtAccountInformationPage("value", "firstname"), firstName);
        Assert.assertEquals(userAccountInformationPage.getAttributeValueAtTextboxByIDAtAccountInformationPage("value", "lastname"), lastName);
        Assert.assertEquals(userAccountInformationPage.getAttributeValueAtTextboxByIDAtAccountInformationPage("value", "email"), emailAddress);

        log.info("Create_Account - Step 13: Click to Account link");
        userAccountInformationPage.clickToHearderAccountLink(driver);

        log.info("Create_Account - Step 14: Click to Logout link");
        userHomePage = userAccountInformationPage.clickToHearderAccountLogoutLink(driver);

        log.info("Create_Account - Step 15: Open LiveGuru99 admin site");
        userHomePage.openPageUrl(driver, adminUrl);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        log.info("Create_Account - Step 16: Login admin system");
        adminManageCustomerPage = adminLoginPage.adminLoginToSystem(adminUserName, adminPassword);

        log.info("Create_Account - Step 17: Close message popup");
        adminManageCustomerPage.clickToCloseButtonAtMessagePopup();

        log.info("Create_Account - Step 18: Seach customer account by email = " + emailAddress);
        adminManageCustomerPage.sendkeyToSearchTextboxByName("email", emailAddress);
        adminManageCustomerPage.clickToButtonByTitle("Search");

        //log.info("Create_Account - Step 19: Verify total records found text displayed");
        //Assert.assertTrue(adminManageCustomerPage.isTotalRecordsDisplayed("Total 1 records found "));

        log.info("Create_Account - Step 20: Verify Name Customer searched");
        Assert.assertEquals(adminManageCustomerPage.getRowValueByColumnName("Name"), firstName + " " + lastName);

        log.info("Create_Account - Step 21: Verify Email Customer searched");
        Assert.assertEquals(adminManageCustomerPage.getRowValueByColumnName("Email"), emailAddress);

        log.info("Create_Account - Step 22: Click to Log Out link");
        adminLoginPage = adminManageCustomerPage.clickToLogoutLink(driver);
    }

    //@Test
    public void ManagerAccount_02_Update_Account(){
        log.info("User_Update - Step 01: Open LiveGuru99 site");
        userHomePage.openPageUrl(driver, userUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("User_Update - Step 02: Click to hearder Account link");
        userHomePage.clickToHearderAccountLink(driver);

        log.info("User_Update - Step 03: Click to herder Login link");
        userLoginPage = userHomePage.clickToHearderAccountLoginLink(driver);

        log.info("User_Update - Step 04: User login to system with Email Address = " + emailAddress + "and Password = " + password);
        userMyDashboardPage = userLoginPage.userLoginToSystem(emailAddress, password);

        log.info("User_Update - Step 05: Verify login success");
        Assert.assertEquals(userMyDashboardPage.getMyDashboardTitle(), "MY DASHBOARD");
        Assert.assertEquals(userMyDashboardPage.getAccountNameText(), "Hello, " + firstName + " " + lastName + "!");

        log.info("User_Update - Step 06: Click to Left Sidebar Account Information link");
        userAccountInformationPage = (UserAccountInformationPageObject) userMyDashboardPage.clickToLeftSidebarLinkByText(driver, "Account Information");

        log.info("User_Update - Step 07: Update account information: First Name");
        userAccountInformationPage.sendkeyToTextboxByID("firstname", firstNameUpdate);

        log.info("User_Update - Step 08 Update account information: Last Name");
        userAccountInformationPage.sendkeyToTextboxByID("lastname", lastNameUpdate);

        log.info("User_Update - Step 09: Update account information: Email Address");
        userAccountInformationPage.sendkeyToTextboxByID("email", emailAddressUpdate);

        log.info("User_Update - Step 10: Enter to Current Password textbox with current password");
        userAccountInformationPage.sendkeyToTextboxByID("current_password", password);

        log.info("User_Update - Step 11: Check to Chang Password checkbox");
        userAccountInformationPage.checkToChangePasswordCheckbox();

        log.info("User_Update - Step 12: Enter to New Password textbox");
        userAccountInformationPage.sendkeyToTextboxByID("password", passwordUpdate);

        log.info("User_Update - Step 13: Enter to Confirm New Password textbox");
        userAccountInformationPage.sendkeyToTextboxByID("confirmation", passwordUpdate);

        log.info("User_Update - Step 14: Click to Save button");
        userMyDashboardPage = userAccountInformationPage.clickToSaveButton();

        log.info("User_Update - Step 15: Verify change account info success");
        Assert.assertEquals(userMyDashboardPage.getSuccessMessage(), "The account information has been saved.");
        Assert.assertEquals(userMyDashboardPage.getAccountNameText(), "Hello, " + firstNameUpdate + " " + lastNameUpdate + "!");

        log.info("User_Update - Step 16: Click to Account link");
        userAccountInformationPage.clickToHearderAccountLink(driver);

        log.info("User_Update - Step 17: Click to Logout link");
        userHomePage = userAccountInformationPage.clickToHearderAccountLogoutLink(driver);

        log.info("User_Update - Step 18: Click to hearder Account link");
        userHomePage.clickToHearderAccountLink(driver);

        log.info("User_Update - Step 19: Click to herder Login link");
        userLoginPage = userHomePage.clickToHearderAccountLoginLink(driver);

        log.info("User_Update - Step 20: User login to system with Email Address = " + emailAddressUpdate + "and Password = " + passwordUpdate);
        userMyDashboardPage = userLoginPage.userLoginToSystem(emailAddressUpdate, passwordUpdate);

        log.info("User_Update - Step 21: Verify login success");
        Assert.assertEquals(userMyDashboardPage.getMyDashboardTitle(), "MY DASHBOARD");
        Assert.assertEquals(userMyDashboardPage.getAccountNameText(), "Hello, " + firstNameUpdate + " " + lastNameUpdate + "!");

        log.info("User_Update - Step 22: Open LiveGuru99 admin site");
        userHomePage.openPageUrl(driver, adminUrl);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        log.info("User_Update - Step 23: Login admin system");
        adminManageCustomerPage = adminLoginPage.adminLoginToSystem(adminUserName, adminPassword);

        log.info("User_Update - Step 24: Close message popup");
        adminManageCustomerPage.clickToCloseButtonAtMessagePopup();

        log.info("User_Update - Step 25: Seach customer account by email = " + emailAddressUpdate);
        adminManageCustomerPage.sendkeyToSearchTextboxByName("email", emailAddressUpdate);
        adminManageCustomerPage.clickToButtonByTitle("Search");

        //log.info("User_Update - Step 19: Verify total records found text displayed");
        //Assert.assertTrue(adminManageCustomerPage.isTotalRecordsDisplayed("Total 1 records found "));

        log.info("User_Update - Step 26: Verify Name Customer searched");
        Assert.assertEquals(adminManageCustomerPage.getRowValueByColumnName("Name"), firstNameUpdate + " " + lastNameUpdate);

        log.info("User_Update - Step 27: Verify Email Customer searched");
        Assert.assertEquals(adminManageCustomerPage.getRowValueByColumnName("Email"), emailAddressUpdate);

        log.info("User_Update - Step 28: Click to Log Out link");
        adminLoginPage = adminManageCustomerPage.clickToLogoutLink(driver);
    }

    @Test
    public void ManagerAccount_02_Delete_Account(){
        log.info("Delete_Account - Step 01: Open LiveGuru99 admin site");
        userHomePage.openPageUrl(driver, adminUrl);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        log.info("Delete_Account - Step 02: Login admin system");
        adminManageCustomerPage = adminLoginPage.adminLoginToSystem(adminUserName, adminPassword);

        log.info("Delete_Account - Step 03: Close message popup");
        adminManageCustomerPage.clickToCloseButtonAtMessagePopup();

        log.info("Delete_Account - Step 04: Seach customer account by email = " + emailAddress);
        adminManageCustomerPage.sendkeyToSearchTextboxByName("email", emailAddress);
        adminManageCustomerPage.clickToButtonByTitle("Search");

        log.info("Delete_Account - Step 05: Check to checkbox at customer row");
        adminManageCustomerPage.checkToCheckboxAtCustomerRow();

        log.info("Delete_Account - Step 06: Select item Delete in dropdown Actions");
        adminManageCustomerPage.selectItemInDropdownByID("customerGrid_massaction-select", "Delete");

        log.info("Delete_Account - Step 07: Click to button Submit");
        adminManageCustomerPage.clickToButtonByTitle("Submit");

        log.info("Delete_Account - Step 08: Click to button OK on Alert");
        adminManageCustomerPage.acceptAlert(driver);

        log.info("Delete_Account - Step 09: Verify delete success message displayed");
        Assert.assertEquals(adminManageCustomerPage.getSuccessMessage(), "Total of 1 record(s) were deleted.");

        log.info("Delete_Account - Step 10: Verify No records found message displayed");
        Assert.assertEquals(adminManageCustomerPage.getNoRecordsFoundMessage(), "No records found.");

        log.info("Delete_Account - Step 11: Click to Log Out link");
        adminLoginPage = adminManageCustomerPage.clickToLogoutLink(driver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        //closeBrowserAndDriver();
    }
    private String userUrl, adminUrl;
    private WebDriver driver;
    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserMyDashboardPageObject userMyDashboardPage;
    private UserAccountInformationPageObject userAccountInformationPage;
    private UserLoginPageObject userLoginPage;
    private AdminLoginPageObject adminLoginPage;
    private AdminManageCustomerPageObject adminManageCustomerPage;
    private String firstName, lastName, emailAddress, password;
    private String adminUserName, adminPassword;
    private String firstNameUpdate, lastNameUpdate, emailAddressUpdate, passwordUpdate;
    private int randomNumber;
}
