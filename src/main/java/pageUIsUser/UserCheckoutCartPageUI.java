package pageUIsUser;

public class UserCheckoutCartPageUI {
    public static final String ADDED_TO_CART_SUCCESS_MESSAGE = "xpath=//li[@class='success-msg']//span";
    public static final String TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
    public static final String APPLY_BUTTON = "xpath=//button[@title='Apply']";
    public static final String DISCOUNT_PRICE_TEXT = "xpath=//td[contains(text(), 'Discount')]/parent::tr//span";
    public static final String GRAND_TOTAL_TEXT = "xpath=//strong[text()='Grand Total']/parent::td/following-sibling::td//span[@class='price']";
    public static final String QTY_TEXTBOX = "xpath=//input[@title='Qty']";
    public static final String UPDATE_BUTTON = "xpath=//button[@title='Update']";
    public static final String QTY_ERROR_MESSAGE = "xpath=//li[@class='error-msg']//span[text()='%s']";
    public static final String QTY_ITEM_ERROR_MESSAGE = "xpath=//p[@class='item-msg error' and contains(text(), '%s')]";
    public static final String EMPTY_CART_BUTTON = "xpath=//button[@id='empty_cart_button']";
    public static final String CART_EMPTY_TITLE_MESSAGE = "xpath=//div[@class='page-title']/h1[text()='%s']";
    public static final String CART_EMPTY_CONTENT_MESSAGE = "xpath=//div[@class='cart-empty']/p[text()='%s']";
    public static final String DROPDOWN_BY_ID = "xpath=//select[@id='%s']";
    public static final String ESTIMATE_BUTTON = "xpath=//button[@title='Estimate']";
    public static final String FLAT_RATE_COST_TEXT = "xpath=//form[@id='co-shipping-method-form']//span[@class='price']";
    public static final String FLAT_RATE_RADIO_BUTTON = "xpath=//input[@id='s_method_flatrate_flatrate']";
    public static final String UPDATE_TOTAL_BUTTON = "xpath=//button[@title='Update Total']";
    public static final String PROCEED_TO_CHECKOUT_BUTTON = "xpath=//button[@title='Proceed to Checkout']";
}
