package pageObjects;

import org.openqa.selenium.WebDriver;

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
    }
}
