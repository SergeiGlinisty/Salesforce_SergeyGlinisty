package enums.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class OpportunityCombobox extends BaseElement {
    private final static String BUTTON_LOCATOR = "//label[text()='%s']/following-sibling::div//button";
    private final static String COMBOBOX_LOCATOR = "//lightning-base-combobox-item//*[@class='slds-truncate' and text()='%s']";

    public OpportunityCombobox(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectByVisibleText(String visibleText) {

        WebElement button = driver.findElement(By.xpath(String.format(BUTTON_LOCATOR, label)));
        if (Objects.nonNull(visibleText)) {
            scrollIntoView(button);
            log.debug("Go to %s dropdown", label);
            button.click();
        }

        WebElement option = driver.findElement(By.xpath(String.format(COMBOBOX_LOCATOR, visibleText)));
        log.info("Select %s input value = %s", label, visibleText);
            option.click();

    }
}
