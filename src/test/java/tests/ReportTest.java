package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.reports.NewAccountReportPage;
import pages.reports.NewReportPage;
import pages.reports.ReportsPage;
import pages.reports.SaveReportPage;
public class ReportTest extends BaseTest{

    @Test(description = "Creating a new Report test", groups = {"Smoke"})
    public void createNewReport() {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openReportTab();
        reportsPage.waitForPageLoaded();
        reportsPage.clickNewReportButton();
        newReportPage.selectTypeReport();
        newReportPage.clickStartReportButton();
        newAccountReportPage.clickSaveAndRunButton();
        saveReportPage.waitForPageLoaded();
        saveReportPage.saveNewReport();
        Assert.assertTrue(reportsPage.isPopupPresentSaved());
        Assert.assertEquals(expectedReportName, actualReportName);

    }

}
