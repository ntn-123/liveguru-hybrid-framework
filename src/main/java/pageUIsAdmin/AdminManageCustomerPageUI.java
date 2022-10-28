package pageUIsAdmin;

public class AdminManageCustomerPageUI {
    public static final String CLOSE_BUTTON_AT_MESSAGE_POPUP = "xpath=//a[@title='close']";
    public static final String SEARCH_TEXTBOX_BY_NAME = "xpath=//input[@name='%s']";
    public static final String BUTTON_BY_TITLE = "xpath=//button[@title='%s']";
    public static final String TOTAL_RECORDS_FOUND_TEXT = "xpath=//td[@class='pager']";
    public static final String COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//span[text()='%s']/parent::a/parent::span/parent::th/preceding-sibling::th";
    public static final String ROW_VALUE_BY_COLUMN_INDEX = "xpath=//div[@class='grid']//tbody//td[%s]";
    public static final String CHECKBOX_AT_CUSTOMER_ROW = "xpath=//tbody//input[@class='massaction-checkbox']";
    public static final String DROPDOWN_BY_ID = "xpath=//select[@id='%s']";
    public static final String SUCCESS_MESSAGE = "xpath=//li[@class='success-msg']//span";
    public static final String NO_RECORDS_FOUND_MESSAGE = "xpath=//tbody//td[@class='empty-text a-center']";
}
