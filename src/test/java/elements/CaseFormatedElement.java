package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CaseFormatedElement extends BaseElement{
    String visibleTextLocator = "//div[@class='container VIEW forceQuickActionLayout inlineEditEnabled']//span[text()='%s']/parent::div/following-sibling::div/span/span";


    public CaseFormatedElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getText() {
        log.debug("Get text from CaseFormatedElement field");
        return driver.findElement(By.xpath(String.format(visibleTextLocator, label))).getText();
    }
}
