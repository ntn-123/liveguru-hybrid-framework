package pageUIsAdmin;

public class AdminOrdersPageUI {
    public static final String STATUS_DROPDOWN = "xpath=//select[@name='status']";
    public static final String BUTTON_BY_TITLE = "xpath=//button[@title='%s']";
    public static final String CHECKBOX_BY_ROW_NUMBER = "xpath=//tr[%s]//input[@class='massaction-checkbox']";
    public static final String ACTIONS_DROPDOWN = "xpath=//select[@id='sales_order_grid_massaction-select']";
    public static final String ERROR_MESSAGE = "xpath=//li[@class='error-msg']//span";
    public static final String PAGINATION_DROPDOWN = "xpath=//table[@class='actions']//select[@name='limit']";
    public static final String ROWS_IN_TABLE = "xpath=//table[@id='sales_order_grid_table']/tbody/tr";
    public static final String LINK_BY_TEXT = "xpath=//a[text()='%s']";
    public static final String ALL_CHECKBOXES_IN_TABLE = "xpath=//input[@class='massaction-checkbox']";
}
