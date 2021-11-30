package com.ostapiuk.core.listener;

import com.ostapiuk.core.driver.DriverProvider;
import com.ostapiuk.core.logger.Log;
import com.ostapiuk.core.utils.ScreenshotUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.testng.*;

public class TestListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

    @Override
    public void onStart(ISuite arg0) {

    }

    @Override
    public void onFinish(ISuite arg0) {

    }

    @Override
    public void onStart(ITestContext arg0) {

    }

    @Override
    public void onFinish(ITestContext arg0) {

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        String temp = String.format("\r%n %s has passed on %s \r%n", arg0.getMethod().getMethodName(), DateFormatUtils.format(arg0.getEndMillis(), "yyyy-MM-dd hh:mm"));
        Log.log(temp);
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        String temp = String.format("\r%n %s has failed on %s \r%n %s \r%n", arg0.getMethod().getMethodName(), DateFormatUtils.format(arg0.getEndMillis(), "yyyy-MM-dd hh:mm"), arg0.getThrowable().getMessage());
        Log.log(temp);
        AllureAttachment.takeScreenshotPNG();
        AllureAttachment.saveTextLog(temp);
    }

    @Override
    public void onTestStart(ITestResult arg0) {
        String temp = String.format("\r%n %s has started on %s \r%n", arg0.getMethod().getMethodName(), DateFormatUtils.format(arg0.getEndMillis(), "yyyy-MM-dd hh:mm"));
        Log.log(temp);
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        String temp = String.format("\r%n %s has skipped on %s \r%n", arg0.getMethod().getMethodName(), DateFormatUtils.format(arg0.getEndMillis(), "yyyy-MM-dd hh:mm"));
        Log.log(temp);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

    }

    @Override
    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
        String testName = returnMethodName(arg0.getTestMethod());
        Log.setName(testName);
    }

    @Override
    public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {

    }

    private String returnMethodName(ITestNGMethod method) {
        return method.getRealClass().getSimpleName() + "." + method.getMethodName();

    }
}
