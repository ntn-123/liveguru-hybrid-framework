package pageObjectsUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class UserAdvanceSearchResultPageObject extends BasePage {
    private WebDriver driver;

    public UserAdvanceSearchResultPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public Set<String> getProductNameAndPriceAtSearchResult() {
        Set<String> productInfo = null;
        //List<WebElement> productNames =
        return  productInfo;
    }
}
