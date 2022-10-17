package commons;

import java.io.File;

public class GlobalConstants {
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;
    public static final String USER_URL = "http://live.techpanda.org/";
    public static final String ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin";
    public static final long SHOTR_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;
}
