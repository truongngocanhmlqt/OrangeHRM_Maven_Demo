package Commons;

public class GlobalConstant {
    //system infor
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String SEPARATOR = System.getProperty("file.separator");

    //App Infor User
    public static final String DEV_USER_URL = "";
    public static final String STAGING_USER_URL = "";
    public static final String LIVE_USER_URL = "";

    //App Infor Admin
    public static final String ADMIN_USER_NAME = "anhtruong";
    public static final String PASSWORD_ADMIN = "Anh@113344!";
    public static final String LIVE_ADMIN_URL = "";

    //WAIT Infor

    public static final long SHORT_TIME = 5;
    public static final long LONG_TIME = 15;

    //Download/Upload file
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "UploadFiles"+ SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "DownloadFiles"+ SEPARATOR;


    //Retry Case Fail
    public static final int RETRY_NUMBER = 3;

    //Browser logs/ Extension
    public static final String BROWSER_LOG_PATH = PROJECT_PATH +SEPARATOR + "browserLogs" +SEPARATOR;
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH +SEPARATOR + "browserExtensions" +SEPARATOR;


    //HTML report folder
    public static final String REPORTING_PATH = PROJECT_PATH +SEPARATOR + "htmlReportNG" +SEPARATOR;
    public static final String EXTENT_PATH = PROJECT_PATH +SEPARATOR + "htmlExtent" +SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH +SEPARATOR + "htmlAllure" +SEPARATOR;

    //DataTest/Environment
    public static final String DATA_TEST_PATH = PROJECT_PATH +SEPARATOR + "dataTest" +SEPARATOR;
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH +SEPARATOR + "environmentConfig" +SEPARATOR;
    public class TestDataHolder {
        public static String employeeID;
    }
    public static final String employeeID = "0047";



}
