package utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AllureUtils {
    @Step("Creating the screenshot")
    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] attachScreenshot(WebDriver driver) {
        log.debug("Get screenshot");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
