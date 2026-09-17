package Commons;

public class GlobalConstant {
    // system info
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String SEPARATOR = System.getProperty("file.separator");

    // app info
    public static final String APP_URL = ConfigReader.getProperty("app.url");

    // admin info from config
    public static final String ADMIN_USER_NAME = ConfigReader.getProperty("admin.username");
    public static final String PASSWORD_ADMIN = ConfigReader.getProperty("admin.password");

    // wait info
    public static final long SHORT_TIME = Long.parseLong(ConfigReader.getProperty("wait.short", "5"));
    public static final long LONG_TIME = Long.parseLong(ConfigReader.getProperty("wait.long", "15"));

    // upload/download file paths
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "UploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "DownloadFiles" + SEPARATOR;

    // retry case fail
    public static final int RETRY_NUMBER = Integer.parseInt(ConfigReader.getProperty("retry.count", "3"));

    // browser logs / extension
    public static final String BROWSER_LOG_PATH = PROJECT_PATH + SEPARATOR + "browserLogs" + SEPARATOR;
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + SEPARATOR + "browserExtensions" + SEPARATOR;

    // HTML report folder
    public static final String REPORTING_PATH = PROJECT_PATH + SEPARATOR + "htmlReportNG" + SEPARATOR;
    public static final String EXTENT_PATH = PROJECT_PATH + SEPARATOR + "htmlExtent" + SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH + SEPARATOR + "htmlAllure" + SEPARATOR;

    // data test / environment
    public static final String DATA_TEST_PATH = PROJECT_PATH + SEPARATOR + "src" + SEPARATOR + "test" + SEPARATOR + "resources" + SEPARATOR + "testdata" + SEPARATOR;
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + SEPARATOR + "environmentConfig" + SEPARATOR;

    public static class TestDataHolder {
        public static String employeeID;
    }
}
