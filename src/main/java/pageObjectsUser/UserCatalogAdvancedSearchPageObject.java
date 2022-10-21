package pageObjectsUser;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIsUser.UserCatalogAdvancedSearchPageUI;

public class UserCatalogAdvancedSearchPageObject extends BasePage {
    private WebDriver driver;

    public UserCatalogAdvancedSearchPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void sendkeyToTextBoxByID(String idValue, String textValue) {
        waitForElementVisible(driver, UserCatalogAdvancedSearchPageUI.TEXTBOX_BY_ID, idValue);
        sendKeyToElement(driver, UserCatalogAdvancedSearchPageUI.TEXTBOX_BY_ID, textValue, idValue);
    }

    public UserAdvanceSearchResultPageObject clickToSearchButton() {
        waitForElementClickable(driver, UserCatalogAdvancedSearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, UserCatalogAdvancedSearchPageUI.SEARCH_BUTTON);
        return  PageGeneratorManager.getUserAdvanceSearchResultPage(driver);
    }
}
