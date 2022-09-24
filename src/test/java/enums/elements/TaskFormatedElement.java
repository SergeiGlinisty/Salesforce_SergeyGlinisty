package enums.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TaskFormatedElement extends BaseElement {

    String visibleTextLocator = "//span[text()='%s']/parent::div/following-sibling::div/span";


    public TaskFormatedElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getText() {
        log.debug("Get text from %s field", label);
        return driver.findElement(By.xpath(String.format(visibleTextLocator, label))).getText();
    }
}
