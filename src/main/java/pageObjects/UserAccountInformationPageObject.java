package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UserHomePageUI;

public class UserAccountInformationPageObject extends BasePage {
    private WebDriver driver;

    public UserAccountInformationPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
