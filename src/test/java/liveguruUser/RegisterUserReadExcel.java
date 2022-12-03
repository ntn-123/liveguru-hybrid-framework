package liveguruUser;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsUser.UserHomePageObject;
import pageObjectsUser.UserMyDashboardPageObject;
import pageObjectsUser.UserRegisterPageObject;
import utils.ExcelUtil;

public class RegisterUserReadExcel extends BaseTest {
    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl){
        driver = getBrowserDriver(browserName, appUrl);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        ExcelUtil.setExcelFileSheet("Sheet1");
        firstName = ExcelUtil.getCellData(2,0);
        lastName = ExcelUtil.getCellData(2,1);
        emailAddress = ExcelUtil.getCellData(2,2);
        password = ExcelUtil.getCellData(2,3);
    }

    @Test
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
        if (userMyDashboardPage.isSuccessMessageDisplayed()){
            ExcelUtil.setCellData("Pass", 2, 5);
        } else {
            ExcelUtil.setCellData("Fail", 2, 5);
        }
        Assert.assertEquals(userMyDashboardPage.getSuccessMessage(), "Thank you for registering with Main Website Store.");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserAndDriver();
    }

    private WebDriver driver;
    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserMyDashboardPageObject userMyDashboardPage;
    private String firstName, lastName, emailAddress, password;
}
