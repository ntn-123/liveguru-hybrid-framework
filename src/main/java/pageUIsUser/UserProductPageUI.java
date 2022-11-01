package pageUIsUser;

public class UserProductPageUI {
    public static final String PRODUCT_COST_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='price-box']//span[@class='price']";
    public static final String PRODUCT_NAME_TITLE = "xpath=//a[text()='%s']";
    public static final String ADD_TO_CART_BUTTON_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']/button";
    public static final String ADD_TO_COMPARE_LINK_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']";
    public static final String ADDED_TO_COMPARE_SUCCESS_MESSAGE = "xpath=//li[@class='success-msg']//span[text()='%s']";
    public static final String COMPARE_BUTTON = "xpath=//button[@title='Compare']";
    public static final String ADD_TO_WISHLIST_LINK_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-wishlist']";

}
