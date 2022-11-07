package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected final Log log;

    protected BaseTest() {
        log = LogFactory.getLog(getClass());
    }
    protected WebDriver getBrowserDriver(String browserName) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        if(browserList == BrowserList.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if(browserList == BrowserList.H_FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(options);
        } else if(browserList == BrowserList.CHROME) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browserList == BrowserList.H_CHROME) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
        } else if(browserList == BrowserList.EDGE) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if(browserList == BrowserList.SAFARI) {
            driver = new SafariDriver();
        } else if(browserList == BrowserList.IE) {
            WebDriverManager.iedriver().arch32().setup();
            driver = new InternetExplorerDriver();
        } else if(browserList == BrowserList.OPERA) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else {
            throw new RuntimeException("Browser name invalid");
        }
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);

        driver.get(GlobalConstants.USER_URL);
        //driver.get("http://live.techpanda.org/");
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String appUrl) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        if(browserList == BrowserList.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if(browserList == BrowserList.H_FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(options);
        } else if(browserList == BrowserList.CHROME) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browserList == BrowserList.H_CHROME) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
        } else if(browserList == BrowserList.EDGE) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if(browserList == BrowserList.SAFARI) {
            driver = new SafariDriver();
        } else if(browserList == BrowserList.IE) {
            WebDriverManager.iedriver().arch32().setup();
            driver = new InternetExplorerDriver();
        } else if(browserList == BrowserList.OPERA) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else {
            throw new RuntimeException("Browser name invalid");
        }
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.get(appUrl);
        return driver;
    }

    public WebDriver getDriverInstance() {
        return this.driver;
    }


    protected int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            log.info(" -------------------------- FAILED -------------------------- ");
            pass = false;

            // Add l盻擁 vﾃ�o ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            log.info(" -------------------------- FAILED -------------------------- ");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            log.info(" -------------------------- FAILED -------------------------- ");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected void closeBrowserAndDriver() {
        String cmd = "";
        try {
            String osName = GlobalConstants.OS_NAME.toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            if (driverInstanceName.contains("chrome")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                } else {
                    cmd = "pkill chromedriver";
                }
            } else if (driverInstanceName.contains("internet explorer")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (driverInstanceName.contains("firefox")) {
                if (osName.contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                } else {
                    cmd = "pkill geckodriver";
                }
            } else if (driverInstanceName.contains("edge")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
                } else {
                    cmd = "pkill msedgedriver";
                }
            } else if (driverInstanceName.contains("opera")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
                } else {
                    cmd = "pkill operadriver";
                }
            } else if (driverInstanceName.contains("safari")) {
                if (osName.contains("mac")) {
                    cmd = "pkill safaridriver";
                }
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected String getCurrentDate() {
        DateTime nowUTC = new DateTime(DateTimeZone.UTC);
        int day = nowUTC.getDayOfMonth();
        if(day < 10) {
            String dayValue = "0" + day;
            return dayValue;
        }
        return String.valueOf(day);
    }

    protected String getCurrentMonth() {
        DateTime now = new DateTime();
        int month = now.getMonthOfYear();
        if(month < 10) {
            String monthValue = "0" + month;
            return monthValue;
        }
        return String.valueOf(month);
    }

    protected String getCurrentYear() {
        DateTime now = new DateTime();
        return String.valueOf(now.getYear());
    }

    protected String getCurrentDay() {
        return getCurrentDate() + "/" + getCurrentMonth() + "/" + getCurrentYear();
    }
}
