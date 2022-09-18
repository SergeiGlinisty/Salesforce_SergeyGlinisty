package utils;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListener implements ITestListener {
    @Step("Starting test")
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        log.debug("Test " + result.getName() + " started");
    }

    @Step("Success test")
    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        log.info("Test " + result.getName() + " finished");
    }

    @Step("Failure test")
    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        log.debug("Test " + result.getName() + " failed");
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        log.debug("Get Screenshot");
        AllureUtils.attachScreenshot(driver);
    }
}
