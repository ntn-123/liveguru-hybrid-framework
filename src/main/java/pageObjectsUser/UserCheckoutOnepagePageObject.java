package pageObjectsUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsUser.UserCheckoutOnepagePageUI;

public class UserCheckoutOnepagePageObject extends BasePage {
    private WebDriver driver;

    public UserCheckoutOnepagePageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void sendkeyToTextboxByID(String idValue, String textValue) {
        waitForElementVisible(driver, UserCheckoutOnepagePageUI.TEXTBOX_BY_ID, idValue);
        sendKeyToElement(driver, UserCheckoutOnepagePageUI.TEXTBOX_BY_ID, textValue, idValue);
    }

    public void selectItemInDropdownByID(String idValue, String textValue) {
        waitForElementClickable(driver, UserCheckoutOnepagePageUI.DROPDOWN_BY_ID, idValue);
        selectItemInDefaultDropdown(driver, UserCheckoutOnepagePageUI.DROPDOWN_BY_ID, textValue, idValue);
    }

    public void clickToButtonByID(String idValue) {
        waitForElementClickable(driver, UserCheckoutOnepagePageUI.CONTINUE_BUTTON_BY_ID, idValue);
        clickToElement(driver, UserCheckoutOnepagePageUI.CONTINUE_BUTTON_BY_ID, idValue);
    }

    public void checkToRadiobuttonByID(String idValue) {
        waitForElementClickable(driver, UserCheckoutOnepagePageUI.RADIOBUTTON_BY_ID, idValue);
        checkToDefaultCheckboxOrRadio(driver, UserCheckoutOnepagePageUI.RADIOBUTTON_BY_ID, idValue);
    }

    public String getOrderSuccessMessage() {
        waitForElementVisible(driver, UserCheckoutOnepagePageUI.ORDER_SUCCESS_MESSAGE);
        return getElementText(driver, UserCheckoutOnepagePageUI.ORDER_SUCCESS_MESSAGE);
    }

    public boolean isOrderIdDisplayed() {
        waitForElementVisible(driver, UserCheckoutOnepagePageUI.ORDER_ID_LINK);
        return isElementDisplayed(driver, UserCheckoutOnepagePageUI.ORDER_ID_LINK);
    }
}
