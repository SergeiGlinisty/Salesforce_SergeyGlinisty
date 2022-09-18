package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LightningFormatedElement extends BaseElement {


    String visibleTextLocator = "//div[contains(@class,'active')]//span[text() = '%s' and @class='test-id__field-label']/ancestor::div[contains(@class,'test-id__output-root')]//*[@data-output-element-id='output-field']";

    public LightningFormatedElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getText() {
        log.debug("Get text from LightningFormatedElement field");
        return driver.findElement(By.xpath(String.format(visibleTextLocator, label))).getText();
    }
}
