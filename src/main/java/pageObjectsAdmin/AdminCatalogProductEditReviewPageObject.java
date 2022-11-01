package pageObjectsAdmin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIsAdmin.AdminCatalogProductEditReviewPageUI;
import pageUIsAdmin.AdminLoginPageUI;

public class AdminCatalogProductEditReviewPageObject extends BasePage {
    private WebDriver driver;

    public AdminCatalogProductEditReviewPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItemAtStatusDropdown(String itemValue) {
        waitForElementClickable(driver, AdminCatalogProductEditReviewPageUI.STATUS_DROPDOWN);
        selectItemInDefaultDropdown(driver, AdminCatalogProductEditReviewPageUI.STATUS_DROPDOWN, itemValue);
    }

    public AdminCatalogProductReviewPageObject clickToButtonByTitle(String titleValue) {
        waitForElementClickable(driver, AdminCatalogProductEditReviewPageUI.BUTTON_BY_TITLE, titleValue);
        clickToElement(driver, AdminCatalogProductEditReviewPageUI.BUTTON_BY_TITLE, titleValue);
        return PageGeneratorManager.getAdminCatalogProductReviewPage(driver);
    }
}
