package pageObjectsAdmin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIsAdmin.AdminCatalogProductReviewPageUI;

public class AdminCatalogProductReviewPageObject extends BasePage {
    private WebDriver driver;

    public AdminCatalogProductReviewPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sortTableByClickToHeaderColumnName(String textValue) {
        waitForElementClickable(driver, AdminCatalogProductReviewPageUI.HEADER_COLUMN_NAME, textValue);
        clickToElement(driver, AdminCatalogProductReviewPageUI.HEADER_COLUMN_NAME, textValue);
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
