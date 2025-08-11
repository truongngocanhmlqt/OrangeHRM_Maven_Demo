package reportConfigs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;
import Commons.GlobalConstant;

import java.util.HashMap;
import java.util.Map;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    static ExtentReports extent = ExtentManager.createExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstant.EXTENT_PATH + "ExtentReport.html");
        reporter.config().setReportName("Orange HRM Demo");
        reporter.config().setDocumentTitle("Orange HRM Demo");
        reporter.config().setTimelineEnabled(true);
        reporter.config().setEncoding("utf-8");
        reporter.config().setTheme(Theme.DARK);

        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Name", "AnhTruong");
        extentReports.setSystemInfo("Project", "Orange HRM");
        extentReports.setSystemInfo("JDK version", GlobalConstant.JAVA_VERSION);
        return extentReports;
    }

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }
}
