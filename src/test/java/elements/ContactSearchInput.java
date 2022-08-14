package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContactSearchInput extends BaseElement {
    WebElement DROPDOWN_LOCATOR = driver.findElement(By.xpath("//*[text()='Account Name']//following-sibling::div//input"));

    public ContactSearchInput(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {

        try {
            Actions action = new Actions(driver);
            action.moveToElement(DROPDOWN_LOCATOR).click().build().perform();
            Thread.sleep(5000);
            action.sendKeys(Keys.ENTER).build().perform();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}



