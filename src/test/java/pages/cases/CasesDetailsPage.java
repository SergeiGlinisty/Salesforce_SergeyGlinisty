package pages.cases;

import elements.CaseFormatedElement;
import enums.Priority;
import enums.Status;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Case;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class CasesDetailsPage extends BasePage {

    private final static By DETAILS_BUTTON = By.xpath("//*[@class='slds-tabs_default__link' and @data-label='Details']");

    public CasesDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting case details button")
    @Override
    public void waitForPageLoaded() {
        log.debug("Waiting DETAILS_BUTTON element");
        waitForElementDisplayed(DETAILS_BUTTON);
    }

    @Step("Getting Case info")
    public Case getCaseInfo() {
        log.debug("Getting Case info");
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
