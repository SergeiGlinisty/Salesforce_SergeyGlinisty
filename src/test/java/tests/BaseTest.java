package tests;


import modals.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import pages.accounts.AccountDetailsPage;
import pages.accounts.AccountsPage;
import pages.cases.CasePage;
import pages.cases.CasesDetailsPage;
import pages.contacts.ContactDetailsPage;
import pages.accounts.NewAccountPage;
import pages.contacts.ContactsPage;
import pages.leads.LeadDetailsPage;
import pages.leads.LeadsPage;
import pages.leads.NewLeadPage;
import pages.opportunities.OpportunitiesDetailsPage;
import pages.opportunities.OpportunitiesPage;
import pages.reports.NewReportPage;
import pages.reports.ReportsPage;
import pages.tasks.TasksDetailsPage;
import pages.tasks.TasksPage;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected LeadsPage leadsPage;
    protected NewLeadPage newLeadPage;

    protected AccountsPage accountsPage;
    protected NewAccountPage newAccountPage;
    protected NewLeadModal newLeadModal;
    protected LeadDetailsPage leadDetailsPage;
    protected AccountDetailsPage accountDetailsPage;
    protected NewAccountModal newAccountModal;
    protected ContactDetailsPage contactDetailsPage;
    protected ContactsPage contactsPage;
    protected NewContactModal newContactModal;
    protected OpportunitiesPage opportunitiesPage;
    protected OpportunitiesDetailsPage opportunitiesDetailsPage;
    protected NewOpportunityModal newOpportunityModal;
    protected CasePage casePage;
    protected CasesDetailsPage casesDetailsPage;
    protected NewCaseModal newCaseModal;
    protected TasksPage tasksPage;
    protected TasksDetailsPage tasksDetailsPage;
    protected NewTaskModal newTaskModal;
    protected ReportsPage reportsPage;
    protected NewReportPage newReportPage;


    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext testContext) throws Exception {
        String browserName = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browserName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        testContext.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        loginPage.open();
    }


    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
