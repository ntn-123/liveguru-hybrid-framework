package pageObjectsUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIsUser.UserAdvanceSearchResultPageUI;

import java.util.List;
import java.util.Set;

public class UserAdvanceSearchResultPageObject extends BasePage {
    private WebDriver driver;

    public UserAdvanceSearchResultPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPriceOfItemsFetchedWithDataSearch(String priceFrom, String priceTo) {
        waitForAllElementsVisible(driver, UserAdvanceSearchResultPageUI.PRODUCT_PRICE_TEXT);
        List<WebElement> priceOfItems = getListWebElement(driver, UserAdvanceSearchResultPageUI.PRODUCT_PRICE_TEXT);
        for (WebElement priceOfItem : priceOfItems){
            String price = priceOfItem.getAttribute("innerText").replace("$","").replace(",","");
            if(Float.parseFloat(price) < Float.parseFloat(priceFrom) || Float.parseFloat(price) > Float.parseFloat(priceTo)){
                return false;
            }
        }
        return true;
    }
}
