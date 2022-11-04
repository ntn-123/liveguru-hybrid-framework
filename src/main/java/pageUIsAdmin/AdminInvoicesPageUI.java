package pageUIsAdmin;

public class AdminInvoicesPageUI {
    public static final String COLUMN_HEADER_BY_TEXT = "xpath=//span[text()='%s']";
    public static final String COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//span[text()='%s']/parent::a/parent::span/parent::th/preceding-sibling::th";
    public static final String ROW_VALUE_BY_COLUMN_INDEX = "xpath=//div[@class='grid']//tbody//td[%s]";
}
