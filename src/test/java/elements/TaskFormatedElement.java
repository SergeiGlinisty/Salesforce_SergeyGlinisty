package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskFormatedElement extends BaseElement {

    String visibleTextLocator = "//span[text()='%s']/parent::div/following-sibling::div/span";


    public TaskFormatedElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getText() {
        return driver.findElement(By.xpath(String.format(visibleTextLocator, label))).getText();
    }
}
