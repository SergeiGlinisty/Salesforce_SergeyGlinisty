package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class AccountDropDown extends BaseElement {
    private final static String BUTTON_ACCOUNT_LOCATOR = "//span[text()='%s']/parent::span/following-sibling::div";
    private final static String DROPDOWN_LOCATOR = "//*[@role='menuitemradio' and text()='%s']";

    public AccountDropDown(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectByVisibleText(String visibleText) {
        WebElement button = driver.findElement(By.xpath(String.format(BUTTON_ACCOUNT_LOCATOR, label)));
        scrollIntoView(button);
        button.click();
        System.out.println("log");
        WebElement option = driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, visibleText)));
        if (Objects.nonNull(visibleText)) {
            scrollIntoView(option);
            System.out.printf("Setting %s input value = %s", label, visibleText);
        }
        System.out.println("gol");
        option.click();
    }

}
