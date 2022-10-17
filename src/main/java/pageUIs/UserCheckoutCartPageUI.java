package pageUIs;

public class UserCheckoutCartPageUI {
    public static final String ADDED_TO_CART_SUCCESS_MESSAGE = "xpath=//li[@class='success-msg']//span";
    public static final String DISCOUNT_CODES_TEXTBOX = "xpath=//input[@id='coupon_code']";
    public static final String APPLY_BUTTON = "xpath=//button[@title='Apply']";
    public static final String DISCOUNT_PRICE_TEXT = "xpath=//td[contains(text(), 'Discount')]/parent::tr//span";
    public static final String GRAND_TOTAL_TEXT = "xpath=//button[@title='Apply']";
}
