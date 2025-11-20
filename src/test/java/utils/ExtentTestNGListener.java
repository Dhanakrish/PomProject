package utils;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestNGListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().log(Status.FAIL, result.getThrowable());

        try {
            BaseTest base = (BaseTest) result.getInstance();

            if (base.getDriver() != null) {           // ← FIXED HERE
                String screenshotPath = base.takeScreenshot(
                        result.getMethod().getMethodName()
                );

                test.get().addScreenCaptureFromPath(screenshotPath);

            } else {
                test.get().log(Status.WARNING, "Driver was null → Screenshot skipped");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
