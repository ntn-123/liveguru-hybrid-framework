package pageObjectsAdmin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIsAdmin.AdminCatalogProductReviewPageUI;
import pageUIsAdmin.AdminLoginPageUI;

public class AdminCatalogProductReviewPageObject extends BasePage {
    private WebDriver driver;

    public AdminCatalogProductReviewPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sortTableByClickToHeaderTitle(String textValue) {
        waitForElementClickable(driver, AdminCatalogProductReviewPageUI.COLUMN_HEADER_BY_TEXT, textValue);
        clickToElement(driver, AdminCatalogProductReviewPageUI.COLUMN_HEADER_BY_TEXT, textValue);
    }

    public AdminCatalogProductEditReviewPageObject clickToEditLinkAtRowNumber(String rowNumber) {
        waitForElementClickable(driver, AdminCatalogProductReviewPageUI.EDIT_LINK_BY_ROW_NUMBER, rowNumber);
        clickToElement(driver, AdminCatalogProductReviewPageUI.EDIT_LINK_BY_ROW_NUMBER, rowNumber);
        return PageGeneratorManager.getAdminCatalogProductEditReviewPage(driver);
    }

    public String getSuccessMessage() {
        waitForElementVisible(driver, AdminCatalogProductReviewPageUI.SUCCESS_MESSAGE);
        return getElementText(driver, AdminCatalogProductReviewPageUI.SUCCESS_MESSAGE);
    }
}
