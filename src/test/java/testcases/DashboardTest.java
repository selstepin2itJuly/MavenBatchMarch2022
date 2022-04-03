package testcases;

import org.testng.annotations.Test;

import config.TestData;
import pages.DashboardPage;
import pages.LandingPage;
import testbase.TestBase;
import testutility.TestUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class DashboardTest {
	private WebDriver dr;
	private LandingPage lp;
	private DashboardPage dp;

	@Test(priority = 1, description = "Dashboard Quick Launch items")
	public void getDashboardQuickLaunchItems_004() {
		 TestUtility.attachImagesToReport();
		Assert.assertTrue(dp.isWelcomeDisplayed());
		 TestUtility.attachImagesToReport();
		Assert.assertTrue(dp.isDashboardDisplayed());
		List<String> actual = dp.getQuickLanchItems();
		List<String> exp = new ArrayList<String>();
		exp.add("Assign Leave");
		exp.add("Leave List");
		exp.add("Timesheets");
		exp.add("Apply Leave");
		exp.add("My Leave");
		exp.add("My Timesheet");
		TestUtility.attachImagesToReport();
		Reporter.log(actual+"--->"+exp);
		Assert.assertEquals(actual, exp, "Quick Launch");
	}

	@Test(priority=2, description="Dashboard quick launch item count")
	public void getDashboardQuickLaunchItemsCount_006() {
		 TestUtility.attachImagesToReport();
		Assert.assertTrue(dp.isWelcomeDisplayed());
		 TestUtility.attachImagesToReport();
		Assert.assertTrue(dp.isDashboardDisplayed());
		int actual = dp.getQuickLaunchItemCounts();
		int exp = 6;
		 TestUtility.attachImagesToReport();
		 Reporter.log(actual+"--->"+exp);
		Assert.assertEquals(actual, exp, "Quick Launch Count");
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		dr = TestBase.getInstance();
		lp = new LandingPage(dr);
		dp = new DashboardPage(dr);
		lp.loginToApplication(TestData.username, TestData.password);

	}

	@AfterMethod
	public void afterMethod() {
		dr.quit();
	}

}
