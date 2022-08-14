package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class AccountTextarea extends BaseElement {

    private final static String TEXTAREA_ACCOUNT_LOCATOR = "//span[text()='%s']/parent::label/following-sibling::textarea";

    public AccountTextarea(WebDriver driver, String label) {
        super(driver, label);
    }


    public void setValue(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(TEXTAREA_ACCOUNT_LOCATOR, label)));
        System.out.printf("Setting %s input value = %s", label, value);
        scrollIntoView(inputElement);
        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            System.out.printf("Setting %s input value = %s", label, value);
        }
        inputElement.sendKeys(value);

    }

}
