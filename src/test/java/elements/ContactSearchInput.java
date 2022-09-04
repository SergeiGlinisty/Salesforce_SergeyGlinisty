package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactSearchInput extends BaseElement {
    WebElement DROPDOWN_LOCATOR = driver.findElement(By.xpath("//*[text()='Account Name']//following-sibling::div//input"));

    public ContactSearchInput(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {

        Actions action = new Actions(driver);
        action.moveToElement(DROPDOWN_LOCATOR).click().build().perform();

        WebElement element = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@role='group']")));
        element.click();

    }


}



