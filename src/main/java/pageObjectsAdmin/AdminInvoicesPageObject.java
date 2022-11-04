package pageObjectsAdmin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIsAdmin.AdminInvoicesPageUI;
import pageUIsAdmin.AdminManageCustomerPageUI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminInvoicesPageObject extends BasePage {
    private WebDriver driver;

    public AdminInvoicesPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sortTableByClickToHeaderColumnName(String textValue) {
        waitForElementClickable(driver, AdminInvoicesPageUI.COLUMN_HEADER_BY_TEXT, textValue);
        clickToElement(driver, AdminInvoicesPageUI.COLUMN_HEADER_BY_TEXT, textValue);
    }

    public boolean isInvoicesSortAscendingByColumnName(String columnName) {
        int columnIndex = getElementsSize(driver, AdminInvoicesPageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        List<WebElement> invoiceValueByColumnIndex = getListWebElement(driver, AdminInvoicesPageUI.ROW_VALUE_BY_COLUMN_INDEX, String.valueOf(columnIndex));
        if(columnName == "Amount"){
            ArrayList<Float> invoiceList = new ArrayList<>();
            for (WebElement invoice : invoiceValueByColumnIndex){
                invoiceList.add(Float.parseFloat(invoice.getText().trim().replace("$", "").replace(",", "")));
            }
            ArrayList<Float> invoiceSortList = new ArrayList<>();
            for (Float invoice : invoiceList){
                invoiceSortList.add(invoice);
            }
            Collections.sort(invoiceSortList);
            return invoiceList.equals(invoiceSortList);
        } else if (columnName == "Invoice Date" || columnName == "Order Date"){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy hh:mm:ss a");
            ArrayList<LocalDateTime> invoiceList = new ArrayList<>();
            for (WebElement invoice : invoiceValueByColumnIndex){
                invoiceList.add(LocalDateTime.parse(invoice.getText(), formatter));
            }
            ArrayList<LocalDateTime> invoiceSortList = new ArrayList<>();
            for (LocalDateTime invoice : invoiceList){
                invoiceSortList.add(invoice);
            }
            Collections.sort(invoiceSortList);
            return invoiceSortList.equals(invoiceList);

        } else {
            ArrayList<String> invoiceList = new ArrayList<>();
            for (WebElement invoice : invoiceValueByColumnIndex){
                invoiceList.add(invoice.getText().trim());
                System.out.println(invoice.getText().trim());
            }
            ArrayList<String> invoiceSortList = new ArrayList<>();
            for (String invoice : invoiceList){
                invoiceSortList.add(invoice);
                System.out.println(invoice);
            }
            Collections.sort(invoiceSortList);
            return invoiceSortList.equals(invoiceList);
        }
    }

    public boolean isInvoicesSortDescendingByColumnName(String columnName) {
        int columnIndex = getElementsSize(driver, AdminInvoicesPageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        List<WebElement> invoiceValueByColumnIndex = getListWebElement(driver, AdminInvoicesPageUI.ROW_VALUE_BY_COLUMN_INDEX, String.valueOf(columnIndex));
        if(columnName == "Amount"){
            ArrayList<Float> invoiceList = new ArrayList<>();
            for (WebElement invoice : invoiceValueByColumnIndex){
                invoiceList.add(Float.parseFloat(invoice.getText().trim().replace("$", "").replace(",", "")));
            }
            ArrayList<Float> invoiceSortList = new ArrayList<>();
            for (Float invoice : invoiceList){
                invoiceSortList.add(invoice);
            }
            Collections.sort(invoiceSortList);
            Collections.reverse(invoiceSortList);
            return invoiceList.equals(invoiceSortList);
        } else {
            ArrayList<String> invoiceList = new ArrayList<>();
            for (WebElement invoice : invoiceValueByColumnIndex){
                invoiceList.add(invoice.getText().trim());
            }
            ArrayList<String> invoiceSortList = new ArrayList<>();
            for (String invoice : invoiceList){
                invoiceSortList.add(invoice);
            }
            Collections.sort(invoiceSortList);
            Collections.reverse(invoiceSortList);
            return invoiceList.equals(invoiceSortList);
        }
    }
}
