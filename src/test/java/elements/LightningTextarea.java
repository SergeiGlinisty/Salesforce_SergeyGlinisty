package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class LightningTextarea extends BaseElement {
    private final static String TEXTAREA_LOCATOR = "//label[text()='%s']/following-sibling::div/textarea";

    public LightningTextarea(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        log.debug("Go to the LightningTextarea field");
        WebElement inputElement = driver.findElement(By.xpath(String.format(TEXTAREA_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            log.info("Setting %s input value = %s", label, value);
            scrollIntoView(inputElement);
            log.info("Setting %s input value = %s", label, value);
            inputElement.sendKeys(value);
        }


    }
}
