package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.reports.NewReportPage;
import pages.reports.ReportsPage;
import static constants.Constants.*;
public class ReportTest extends BaseTest{

    @BeforeClass
    public void initialise() {
        reportsPage = new ReportsPage(driver);
        newReportPage = new NewReportPage(driver);
    }

    @Test
    public void createNewReport() {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openReportTab();
        reportsPage.waitForPageLoaded();
        reportsPage.clickNewReportButton();
        newReportPage.clickAllReports();

    }

}
