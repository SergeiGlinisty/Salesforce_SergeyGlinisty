package elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseElement {
    protected WebDriver driver;
    protected String label;
    private WebDriverWait wait;

    public BaseElement(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;

    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
