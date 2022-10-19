package pageUIs;

public class UserCompareProductsPageUI {
    public static final String COMPARE_PRODUCTS_TITLE = "xpath=//h1[text()='Compare Products']";
    public static final String MOBILE_NAME_TEXT = "xpath=//a[text()='%s']";
    public static final String MOBILE_PRICE_TEXT_BY_MOBILE_NAME = "xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='price-box']//span[text()='%s']";
    public static final String MOBILE_IMAGE_TEXT_BY_MOBILE_NAME = "xpath=//a[text()='%s']/parent::h2/preceding-sibling::a/img[contains(@src, '%s')]";
    public static final String MOBILE_SKU_TEXT = "xpath=//div[contains(text(), 'MOB001')]";

}
