package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extend;

    public static ExtentReports getInstance() {
        if (extend == null) {

            String reporPath=System.getProperty("user.dir")+"/reports/ExtentReport.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reporPath);


            extend = new ExtentReports();
            extend.attachReporter(reporter);
        }
        return extend;
    }



}
