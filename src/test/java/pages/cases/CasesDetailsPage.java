package pages.cases;

import elements.CaseFormatedElement;
import elements.LightningFormatedElement;
import elements.TaskFormatedElement;
import enums.Industry;
import enums.Priority;
import enums.Status;
import models.Case;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CasesDetailsPage extends BasePage {

    private final static By DETAILS_BUTTON = By.xpath("//*[@class='slds-tabs_default__link' and @data-label='Details']");

    public CasesDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(DETAILS_BUTTON);
    }

    public Case getCaseInfo() {
        String status = new CaseFormatedElement(driver, "Status").getText();

        Case.CaseBuilder caseBuilder = Case.builder()
                .status(Status.fromString(status));

        String priority = new CaseFormatedElement(driver, "Priority").getText();
        if (priority != "") {
            caseBuilder.priority(Priority.fromString(priority));
        }
        String subject = new CaseFormatedElement(driver, "Subject").getText();
        if (subject != "") {
            caseBuilder.subject(subject);
        }
        String description = new CaseFormatedElement(driver, "Description").getText();
        if (description != "") {
            caseBuilder.description(description);
        }

        return caseBuilder.build();

    }


}
