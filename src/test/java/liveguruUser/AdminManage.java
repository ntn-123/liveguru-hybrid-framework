package liveguruUser;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsAdmin.*;
import pageObjectsUser.*;

public class AdminManage extends BaseTest {
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

    //@Test
    public void Admin_Manage_01_Create_Account(){
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
        adminLoginPage = adminManageCustomerPage.clickToLogoutLinkAtAdminPage(driver);
    }

    //@Test
    public void Admin_Manage_02_Update_Account(){
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
        adminLoginPage = adminManageCustomerPage.clickToLogoutLinkAtAdminPage(driver);
    }

    //@Test
    public void Admin_Manage_03_Delete_Account(){
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
        adminLoginPage = adminManageCustomerPage.clickToLogoutLinkAtAdminPage(driver);

    }

    //@Test
    public void Admin_Manage_04_Printed_Invoice() {
        log.info("Printed_Invoice - Step 01: Open LiveGuru99 admin site");
        userHomePage.openPageUrl(driver, adminUrl);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        log.info("Printed_Invoice - Step 02: Login admin system");
        adminManageCustomerPage = adminLoginPage.adminLoginToSystem(adminUserName, adminPassword);

        log.info("Printed_Invoice - Step 03: Close message popup");
        adminManageCustomerPage.clickToCloseButtonAtMessagePopup();

        log.info("Printed_Invoice - Step 04: Hover to header Sales menu link");
        adminManageCustomerPage.hoverMouseToHeaderLinkByTextAtAdminPage(driver, "Sales");

        log.info("Printed_Invoice - Step 05: Click to header Orders menu link");
        adminOrdersPage = (AdminOrdersPageObject) adminManageCustomerPage.clickToHeaderLinkByTextAtAdminPage(driver, "Orders");

        log.info("Printed_Invoice - Step 06: Search orders by status = Canceled");
        adminOrdersPage.selectItemInStatusDropdown("Canceled");
        adminOrdersPage.clickToButtonByTitle("Search");
        adminOrdersPage.sleepInSecond(2);

        log.info("Printed_Invoice - Step 07: Check to checkbox at first row order");
        adminOrdersPage.checkToCheckboxByRowNumber("1");

        log.info("Printed_Invoice - Step 08: Select item Print invoices at Actions dropdown");
        adminOrdersPage.selectItemInActionsDropdown("Print Invoices");

        log.info("Printed_Invoice - Step 09: Click to Submit button");
        adminOrdersPage.clickToButtonByTitle("Submit");

        log.info("Printed_Invoice - Step 10: Verify error message print displayed");
        Assert.assertEquals(adminOrdersPage.getErrorMessage(), "There are no printable documents related to selected orders.");

        log.info("Printed_Invoice - Step 11: Search orders by status = Complete");
        adminOrdersPage.selectItemInStatusDropdown("Complete");
        adminOrdersPage.clickToButtonByTitle("Search");
        adminOrdersPage.sleepInSecond(2);

        log.info("Printed_Invoice - Step 07: Check to checkbox at first row order");
        adminOrdersPage.checkToCheckboxByRowNumber("1");

        log.info("Printed_Invoice - Step 08: Select item Print invoices at Actions dropdown");
        adminOrdersPage.selectItemInActionsDropdown("Print Invoices");

        log.info("Printed_Invoice - Step 09: Click to Submit button");
        adminOrdersPage.clickToButtonByTitle("Submit");
        adminOrdersPage.sleepInSecond(10);

        log.info("Printed_Invoice - Step 10: Verify invoice downloaded");
        Assert.assertTrue(adminOrdersPage.isFileDownloaded("C:\\Users\\admin\\Downloads", "invoice2022-10-31"));
        adminOrdersPage.sleepInSecond(5);
    }

    @Test
    public void Admin_Manage_05_Product_Review() {
        log.info("Product_Review - Step 01: Open LiveGuru99 user site");
        userHomePage.openPageUrl(driver, userUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Product_Review - Step 02: Open review product");
        userHomePage.openPageUrl(driver, "http://live.techpanda.org/index.php/review/product/list/id/1/");
        userProductDetailPage = PageGeneratorManager.getUserProductDetailPage(driver);

        log.info("Product_Review - Step 03: Check to Rate Field");
        userProductDetailPage.checkToRateRadioButtonByID("Quality 1_3");

        log.info("Product_Review - Step 04: Enter to Review field");
        userProductDetailPage.sendkeyToReviewFieldTextarea("Review");

        log.info("Product_Review - Step 05: Enter to Review field");
        userProductDetailPage.sendkeyToSummaryFieldTextbox("Summary");

        log.info("Product_Review - Step 06: Enter to Review field");
        userProductDetailPage.sendkeyToNicknameFieldTextbox("Nickname");

        log.info("Product_Review - Step 07: Click to Submit review button");
        userProductDetailPage.clickToSubmitReviewButton();

        log.info("Product_Review - Step 08: Verify reviewed success message displayed");
        Assert.assertEquals(userProductDetailPage.getReviewedSuccessMessage(), "Your review has been accepted for moderation.");

        log.info("Product_Review - Step 09: Open LiveGuru99 admin site");
        userHomePage.openPageUrl(driver, adminUrl);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        log.info("Product_Review - Step 10: Login admin system");
        adminManageCustomerPage = adminLoginPage.adminLoginToSystem(adminUserName, adminPassword);

        log.info("Product_Review - Step 11: Close message popup");
        adminManageCustomerPage.clickToCloseButtonAtMessagePopup();

        log.info("Product_Review - Step 12: Hover to header Catalog menu link");
        adminManageCustomerPage.hoverMouseToHeaderLinkByTextAtAdminPage(driver, "Catalog");

        log.info("Product_Review - Step 13: Hover to header Reviews and Ratings sub-menu link");
        adminManageCustomerPage.hoverMouseToHeaderLinkByTextAtAdminPage(driver, "Reviews and Ratings");

        log.info("Product_Review - Step 14: Hover to header Customer Reviews sub-menu link");
        adminManageCustomerPage.hoverMouseToHeaderLinkByTextAtAdminPage(driver, "Customer Reviews");

        log.info("Product_Review - Step 15: Click to header Pending Reviews sub-menu link");
        adminCatalogProductReviewPage = (AdminCatalogProductReviewPageObject) adminManageCustomerPage.clickToHeaderLinkByTextAtAdminPage(driver, "Pending Reviews");

        log.info("Product_Review - Step 16: Sort table by Id");
        adminCatalogProductReviewPage.sortTableByClickToHeaderTitle("ID");
        adminCatalogProductReviewPage.sleepInSecond(2);

        log.info("Product_Review - Step 17: Click Edit link at first row");
        adminCatalogProductEditReviewPage = adminCatalogProductReviewPage.clickToEditLinkAtRowNumber("1");

        log.info("Product_Review - Step 18: Select item Approved at Status dropdown");
        adminCatalogProductEditReviewPage.selectItemAtStatusDropdown("Approved");

        log.info("Product_Review - Step 19: Click to Save Review button");
        adminCatalogProductReviewPage = adminCatalogProductEditReviewPage.clickToButtonByTitle("Save Review");

        log.info("Product_Review - Step 20: Verify The review has been saved message displayed");
        Assert.assertEquals(adminCatalogProductReviewPage.getSuccessMessage(), "The review has been saved.");

        log.info("Product_Review - Step 21: Open LiveGuru99 user site");
        userHomePage.openPageUrl(driver, userUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Product_Review - Step 22: Click to Mobile menu");
        userProductPage = userHomePage.clickToHearderProductMenuLinkByProductName(driver, "Mobile");

        log.info("Product_Review - Step 23: Click to Sony Xperia name title");
        userProductDetailPage = userProductPage.clickToProductNameTitle("Sony Xperia");

        log.info("Product_Review - Step 24: Click to Review tab at bottom of page");
        userProductDetailPage.clickToBottomTabByText("Reviews");


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
    private AdminOrdersPageObject adminOrdersPage;
    private UserProductDetailPageObject userProductDetailPage;
    private AdminCatalogProductReviewPageObject adminCatalogProductReviewPage;
    private AdminCatalogProductEditReviewPageObject adminCatalogProductEditReviewPage;
    private UserProductPageObject userProductPage;
    private String firstName, lastName, emailAddress, password;
    private String adminUserName, adminPassword;
    private String firstNameUpdate, lastNameUpdate, emailAddressUpdate, passwordUpdate;
    private int randomNumber;
}
