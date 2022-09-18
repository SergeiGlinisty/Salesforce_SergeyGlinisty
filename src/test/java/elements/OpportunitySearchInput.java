package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class OpportunitySearchInput extends BaseElement {

    WebElement DROPDOWN_LOCATOR = driver.findElement(By.xpath("//label[text()='Account Name']/following-sibling::div//input"));

    public OpportunitySearchInput(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        log.debug("Go to the search input field");
        Actions action = new Actions(driver);
        action.moveToElement(DROPDOWN_LOCATOR).click().build().perform();

        WebElement element = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@role='group']")));
        element.click();
        log.info("The user Account Name has been set");
    }

}