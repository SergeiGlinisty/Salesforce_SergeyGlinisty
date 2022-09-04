package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;
@Log4j2
public class TaskTextarea extends BaseElement{
    private final static String TEXTAREA_ACCOUNT_LOCATOR = "//*[text()='%s']/parent::label/following-sibling::div//textarea";
    public TaskTextarea(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        log.debug("Go to the textarea input field");
        WebElement inputElement = driver.findElement(By.xpath(String.format(TEXTAREA_ACCOUNT_LOCATOR, label)));
        log.info("Setting %s input value = %s", label, value);

        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            log.info("Setting %s input value = %s", label, value);
            inputElement.sendKeys(value);
        }


    }

}
