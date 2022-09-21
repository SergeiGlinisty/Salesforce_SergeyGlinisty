package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class AccountInput extends BaseElement {
    private final static String INPUT_ACCOUNT_LOCATOR = "//span[text()='%s']/parent::label/following-sibling::input";

    public AccountInput(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        log.debug("Go to %s input field",label);
        WebElement inputElement = driver.findElement(By.xpath(String.format(INPUT_ACCOUNT_LOCATOR, label)));

        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            log.info("Set %s input value = %s", label, value);
            inputElement.sendKeys(value);
        }


    }
}
