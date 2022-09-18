package tests;


import modals.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.accounts.AccountDetailsPage;
import pages.accounts.AccountsPage;
import pages.accounts.NewAccountPage;
import pages.cases.CasePage;
import pages.cases.CasesDetailsPage;
import pages.contacts.ContactDetailsPage;
import pages.contacts.ContactsPage;
import pages.leads.LeadDetailsPage;
import pages.leads.LeadsPage;
import pages.leads.NewLeadPage;
import pages.opportunities.OpportunitiesDetailsPage;
import pages.opportunities.OpportunitiesPage;
import pages.reports.NewAccountReportPage;
import pages.reports.NewReportPage;
import pages.reports.ReportsPage;
import pages.reports.SaveReportPage;
import pages.tasks.TasksDetailsPage;
import pages.tasks.TasksPage;
import utils.PropertyReader;
import utils.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    protected static String USERNAME = PropertyReader.getProperty("username");
    protected static String PASSWORD = PropertyReader.getProperty("password");
    protected NewAccountReportPage newAccountReportPage;
    protected SaveReportPage saveReportPage;
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
    String actualReportName;
    String expectedReportName;

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
        accountDetailsPage = new AccountDetailsPage(driver);
        accountsPage = new AccountsPage(driver);
        newAccountPage = new NewAccountPage(driver);
        newAccountModal = new NewAccountModal(driver);
        opportunitiesPage = new OpportunitiesPage(driver);
        opportunitiesDetailsPage = new OpportunitiesDetailsPage(driver);
        newOpportunityModal = new NewOpportunityModal(driver);
        casePage = new CasePage(driver);
        casesDetailsPage = new CasesDetailsPage(driver);
        newCaseModal = new NewCaseModal(driver);
        newAccountReportPage = new NewAccountReportPage(driver);
        newReportPage = new NewReportPage(driver);
        reportsPage = new ReportsPage(driver);
        saveReportPage = new SaveReportPage(driver);
        tasksPage = new TasksPage(driver);
        tasksDetailsPage = new TasksDetailsPage(driver);
        newTaskModal = new NewTaskModal(driver);

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
