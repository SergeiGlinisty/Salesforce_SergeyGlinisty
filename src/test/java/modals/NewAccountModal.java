package modals;

import elements.AccountDropDown;
import elements.AccountInput;
import elements.AccountSearchInput;
import elements.AccountTextarea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewAccountModal extends BaseModal {

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Step("Filling Account form")
    public void fillForm(Account inputAccount) {
        log.debug("Filling new Account form");
        new AccountDropDown(driver, "Type").selectByVisibleText(inputAccount.getType().name);
        new AccountDropDown(driver, "Industry").selectByVisibleText(inputAccount.getIndustry().name);

        new AccountSearchInput(driver, "Account Name").setValue(inputAccount.getAccountName());

        new AccountInput(driver, "Phone").setValue(inputAccount.getPhone());
        new AccountInput(driver, "Fax").setValue(inputAccount.getFax());
        new AccountInput(driver, "Website").setValue(inputAccount.getWebsite());

        new AccountInput(driver, "Employees").setValue(inputAccount.getEmployees());
        new AccountInput(driver, "Annual Revenue").setValue(inputAccount.getAnnualRevenue());
        new AccountTextarea(driver, "Description").setValue(inputAccount.getDescription());

    }
}
