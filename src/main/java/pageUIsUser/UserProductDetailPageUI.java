package pageUIsUser;

public class UserProductDetailPageUI {
    public static final String PRODUCT_COST_BY_PRODUCT_NAME = "xpath=//span[text()='%s']/parent::div/following-sibling::div[@class='price-info']//span[@class='price']";
    public static final String ADD_YOUR_REVIEW_LINK = "xpath=//a[text()='Add Your Review']";
    public static final String SUBMIT_REVIEW_BUTTON = "xpath=//button[@title='Submit Review']";
    public static final String ERROR_MESSAGE_REVIEW_AT_INPUT_FIELD_BY_ID = "xpath=//div[@id='%s']";
    public static final String RATE_RADIO_BUTTON = "xpath=//input[@id='%s']";
    public static final String REVIEW_TEXTAREA = "xpath=//textarea[@id='review_field']";
    public static final String SUMMARY_TEXTBOX = "xpath=//input[@id='summary_field']";
    public static final String NICKNAME_TEXTBOX = "xpath=//input[@id='nickname_field']";
    public static final String REVIEWED_SUCCESS_MESSAGE = "xpath=//li[@class='success-msg']//span";
    public static final String BOTTOM_TAB_BY_TEXT = "xpath=//ul[@class='toggle-tabs']//span[text()='%s']";
}
